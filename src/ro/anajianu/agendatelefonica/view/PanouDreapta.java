/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.anajianu.agendatelefonica.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;
import ro.anajianu.agendatelefonica.controller.CarteDeTelefonController;

/**
 *
 * @author ana
 */
public class PanouDreapta extends JPanel {

    private final PanouDetalii panouDetalii;
    private final PanouButoane panouButoane;
    private final PanouReclame panouReclame;

    public PanouDreapta(CarteDeTelefonController controller) {
        panouDetalii = new PanouDetalii(controller);
        panouButoane = new PanouButoane(controller);
        panouReclame = new PanouReclame(controller);
        initializare();
    }

    private void initializare() {
        setSize(new Dimension(500, 900));
        setLayout(new GridLayout(3, 1));
        add(panouDetalii);
        add(panouButoane);
        add(panouReclame);
    }
    
    public PanouDetalii getPanouDetalii() {
        return panouDetalii;
    }

    public PanouButoane getPanouButoane() {
        return panouButoane;
    }

    public PanouReclame getPanouReclame() {
        return panouReclame;
    }

}
