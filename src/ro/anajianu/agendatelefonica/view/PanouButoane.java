/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.anajianu.agendatelefonica.view;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author ana
 */
public class PanouButoane extends JPanel {

    private JButton butonAdaugare;
    private JButton butonStergere;
    private JButton butonModificare;
    private JButton butonSortare;
    private JButton butonCautare;
    private JButton butonIesire;

    public PanouButoane() {
        butonAdaugare = new JButton("Adaugare");
        butonStergere = new JButton("Stergere");
        butonModificare = new JButton("Modificare");
        butonSortare = new JButton("Sortare");
        butonCautare = new JButton("Cautare");
        butonIesire = new JButton("Iesire");
        initializare();
    }
    
    public void initializare() {
        add(butonAdaugare);
        add(butonStergere);
        add(butonModificare);
        add(butonSortare);
        add(butonCautare);
        add(butonIesire);
    }

}
