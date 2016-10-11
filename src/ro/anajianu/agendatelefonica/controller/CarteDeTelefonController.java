package ro.anajianu.agendatelefonica.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import ro.anajianu.agendatelefonica.model.Abonat;
import ro.anajianu.agendatelefonica.model.CarteDeTelefon;
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

}
