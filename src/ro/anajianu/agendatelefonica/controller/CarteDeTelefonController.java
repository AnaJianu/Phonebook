package ro.anajianu.agendatelefonica.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import ro.anajianu.agendatelefonica.model.Abonat;
import ro.anajianu.agendatelefonica.model.CarteDeTelefon;
import ro.anajianu.agendatelefonica.start.ThreadSalvareBazaDate;
import ro.anajianu.agendatelefonica.view.CarteDeTelefonGUI;
import ro.anajianu.agendatelefonica.view.FereastraCautare;

/**
 *
 * @author ana
 */
public class CarteDeTelefonController {

    private final CarteDeTelefon modelCarte;
    private final CarteDeTelefonGUI viewCarte;

    public CarteDeTelefonController(CarteDeTelefon model) {
        modelCarte = model;
        viewCarte = new CarteDeTelefonGUI(this);
        incarcaDateleLaPornireaAplicatiei();

    }
    
    public void initializareView() {
        viewCarte.initializare();
    }

    private void incarcaDateleLaPornireaAplicatiei() {
        File file = new File("resources/agenda.atl");
        incarcaDateDinFisier(file);
    }

    public void stergeAbonat() {
        viewCarte.stergeAbonatDinTabel();
        viewCarte.stergeCampuriDetaliiAbonat();

    }

    public void adaugaAbonat() {
        viewCarte.adaugaAbonatDinView();
    }

    public void iesireDinAplicatie() {
        viewCarte.iesireDinAplicatie();
    }

    public void cautaAbonatDinMeniu() {
        FereastraCautare fereastraCautare = new FereastraCautare();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                fereastraCautare.initializare();
            }
        });
        viewCarte.getPanouPrincipal().getPanouStanga().adaugareDocumentListenerCautare(fereastraCautare.getCampCautare());
    }

    public Abonat getSelectedAbonat() {
        return viewCarte.getPanouPrincipal().getPanouStanga().getAbonatSelectatDinTabel();
    }

    public List<Abonat> getListaAbonati() {
        return modelCarte.getListaAbonati();
    }

    public void modificaAbonat() {
        if (getSelectedAbonat() != null) {
            Abonat abonatAfisat = viewCarte.getPanouPrincipal().getPanouDreapta().getPanouDetalii().getAbonatAfisat();
            modelCarte.modificareAbonat(getSelectedAbonat(), abonatAfisat);
            viewCarte.stergeCampuriDetaliiAbonat();
        } else {
            JOptionPane.showMessageDialog(null, "Va rugam selectati un abonat!",
                    "Modificare abonat",
                    JOptionPane.OK_OPTION);
        }
    }

    public CarteDeTelefon getModelCarte() {
        return modelCarte;
    }

    public void sortareAbonati() {
        viewCarte.sortareAbonatInTabel();

    }

    public void salveazaFisier(File file) {
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(modelCarte.getListaAbonati());
            oos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CarteDeTelefonController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CarteDeTelefonController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void incarcaDateDinFisier(File fisierSelectat) {
        FileInputStream fis;
        try {
            fis = new FileInputStream(fisierSelectat);
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<Abonat> bazaDate = (List<Abonat>) ois.readObject();
            ois.close();

            modelCarte.incarcaBazaDeDate(bazaDate);
            viewCarte.getPanouPrincipal().getPanouStanga().initializareListaAbonatiInTabel();
            programeazaSalvareBazeiDeDate(fisierSelectat);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CarteDeTelefonController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(CarteDeTelefonController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private void programeazaSalvareBazeiDeDate(File file) {
        TimerTask salvator = new ThreadSalvareBazaDate(this, file);
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(salvator, 0, 300*1000);
        

        
    }

}
