/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.anajianu.agendatelefonica.view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

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

    public BaraMeniuri() {
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
}
