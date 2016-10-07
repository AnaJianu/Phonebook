package ro.anajianu.agendatelefonica.controller;

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
    
    
   

}
