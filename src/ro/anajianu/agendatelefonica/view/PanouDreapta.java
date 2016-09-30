/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.anajianu.agendatelefonica.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author ana
 */
public class PanouDreapta extends JPanel {

    private final PanouDetalii panouDetalii;
    private final PanouButoane panouButoane;

    public PanouDreapta() {
        panouDetalii = new PanouDetalii();
        panouButoane = new PanouButoane();
        initializare();
    }

    private void initializare() {
        setSize(new Dimension(500, 900));
        setLayout(new GridLayout(2, 1));
        add(panouDetalii);
        add(panouButoane);
    }

}
