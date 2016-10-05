/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.anajianu.agendatelefonica.view;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import ro.anajianu.agendatelefonica.controller.CarteDeTelefonController;

/**
 *
 * @author ana
 */
public class BaraMeniuri extends JMenuBar {

    private final JMenu meniuFisier;
    private final JMenuItem submeniuDeschide;
    private final JMenuItem submeniuSalvare;
    private final JSeparator separatorMeniu;
    private final JMenuItem submeniuIesire;

    private final JMenu meniuAbonati;
    private final JMenuItem submeniuAdaugaAbonat;
    private final JMenuItem submeniuCautaAbonat;
    private final JMenuItem submeniuStergeAbonat;
    private final JMenuItem submeniuModificaAbonat;

    private final JMenu meniuAjutor;
    private final JMenuItem submeniuInregistrare;
    private final JMenuItem submeniuDespre;

    private final CarteDeTelefonController controller;

    public BaraMeniuri(CarteDeTelefonController controller) {
        this.controller = controller;

        meniuFisier = new JMenu("Fisier");
        submeniuDeschide = new JMenuItem("Deschide");
        submeniuSalvare = new JMenuItem("Salvare");
        separatorMeniu = new JSeparator();
        submeniuIesire = new JMenuItem("Iesire");

        meniuAbonati = new JMenu("Abonati");
        submeniuAdaugaAbonat = new JMenuItem("Adauga");
        submeniuCautaAbonat = new JMenuItem("Cauta");
        submeniuStergeAbonat = new JMenuItem("Sterge");
        submeniuModificaAbonat = new JMenuItem("Modifica");

        meniuAjutor = new JMenu("Ajutor");
        submeniuInregistrare = new JMenuItem("Inregistrare");
        submeniuDespre = new JMenuItem("Despre");
        initializare();
        initializareSubmeniuIesire();
        initializareSubmeniuStergeAbonat();
        initializareSubmeniuCautaAbonat();
        initializareSubmeniuDeschide();
    }

    private void initializare() {
        meniuFisier.add(submeniuDeschide);
        meniuFisier.add(submeniuSalvare);
        meniuFisier.add(separatorMeniu);
        meniuFisier.add(submeniuIesire);
        add(meniuFisier);

        meniuAbonati.add(submeniuAdaugaAbonat);
        meniuAbonati.add(submeniuCautaAbonat);
        meniuAbonati.add(submeniuStergeAbonat);
        meniuAbonati.add(submeniuModificaAbonat);
        add(meniuAbonati);

        meniuAjutor.add(submeniuInregistrare);
        meniuAjutor.add(submeniuDespre);
        add(meniuAjutor);

    }

    private void initializareSubmeniuIesire() {
        submeniuIesire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.iesireDinAplicatie();
            }
        });
    }

    private void initializareSubmeniuStergeAbonat() {
        submeniuStergeAbonat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.stergeAbonat();
            }
        });

    }

    private void initializareSubmeniuCautaAbonat() {
        submeniuCautaAbonat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.cautaAbonatDinMeniu();
            }
        });

    }

    private void initializareSubmeniuDeschide() {
        submeniuDeschide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File fisierSelectat = fileChooser.getSelectedFile();
                    try {
                        Desktop.getDesktop().open(fisierSelectat);
                    } catch (IOException ex) {
                        Logger.getLogger(BaraMeniuri.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        });
    }

}
