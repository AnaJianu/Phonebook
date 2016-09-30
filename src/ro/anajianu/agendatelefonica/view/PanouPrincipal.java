/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.anajianu.agendatelefonica.view;

import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author ana
 */
public class PanouPrincipal extends JPanel{
    private final PanouStanga panouStanga;
    private final PanouDreapta panouDreapta;
    
    public PanouPrincipal() {
        panouStanga=new PanouStanga();
        panouDreapta=new PanouDreapta();
        initializare();
    }

    private void initializare() {
        setLayout(new GridLayout(1, 2));
        add(panouStanga);
        add(panouDreapta);
    }
    
}
