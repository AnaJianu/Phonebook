/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.anajianu.agendatelefonica.view;

import java.awt.GridLayout;
import javax.swing.JPanel;
import ro.anajianu.agendatelefonica.controller.CarteDeTelefonController;

/**
 *
 * @author ana
 */
public class PanouPrincipal extends JPanel {

    private final PanouStanga panouStanga;
    private final PanouDreapta panouDreapta;

    public PanouPrincipal(CarteDeTelefonController controller) {
        panouStanga = new PanouStanga(controller);
        panouDreapta = new PanouDreapta(controller);
        initializare();
        initializareListenerSelectieTabel();
    }

    private void initializare() {
        setLayout(new GridLayout(1, 2));
        add(panouStanga);
        add(panouDreapta);
    }

    public PanouStanga getPanouStanga() {
        return panouStanga;
    }

    public PanouDreapta getPanouDreapta() {
        return panouDreapta;
    }

    private void initializareListenerSelectieTabel() {
        PanouDetalii panouDetalii = panouDreapta.getPanouDetalii();
        panouStanga.adaugaSelectionListenerPeTabel(panouDetalii);
    }

}
