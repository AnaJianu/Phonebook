/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.anajianu.agendatelefonica.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import ro.anajianu.agendatelefonica.controller.CarteDeTelefonController;

/**
 *
 * @author ana
 */
public class PanouButoane extends JPanel {

    private final JButton butonAdaugare;
    private final JButton butonStergere;
    private final JButton butonModificare;
    private final JButton butonSortare;
    private final JButton butonCautare;
    private final JButton butonIesire;
    private CarteDeTelefonController controller;

    public PanouButoane(CarteDeTelefonController controller) {

        this.controller = controller;

        butonAdaugare = new JButton("Adaugare");
        butonStergere = new JButton("Stergere");

        butonModificare = new JButton("Modificare");
        butonSortare = new JButton("Sortare");
        butonCautare = new JButton("Cautare");
        butonIesire = new JButton("Iesire");
        initializare();
    }

    private void initializare() {
        initializareButonStergere();
        initializareButonIesire();

        add(butonAdaugare);
        add(butonStergere);
        add(butonModificare);
        add(butonSortare);
        add(butonCautare);
        add(butonIesire);

        setLayout(new GridLayout(3, 2));

    }

    private void initializareButonStergere() {
        butonStergere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.print("Stergere");
                controller.stergeAbonat();
            }
        });
    }

    private void initializareButonIesire() {
        butonIesire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = JOptionPane.showConfirmDialog(null, "Confirmati iesirea din aplicatie?","Iesire aplicatie", JOptionPane.YES_NO_OPTION);
                if (n==0) {
                    System.exit(0);
                }
            }
        });
    }

}
