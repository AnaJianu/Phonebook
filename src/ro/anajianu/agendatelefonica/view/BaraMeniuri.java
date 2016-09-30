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
    private final JMenuItem meniuDeschide;
    private final JMenuItem meniuSalvare;
    private final JSeparator separatorMeniu;
    private final JMenuItem meniuIesire;

    private final JMenu meniuAbonati;
    private final JMenuItem meniuAdaugaAbonat;
    private final JMenuItem meniuCautaAbonat;
    private final JMenuItem meniuStergeAbonat;
    private final JMenuItem meniuModificaAbonat;
    
    private final JMenu meniuAjutor;
    private final JMenuItem meniuInregistrare;
    private final JMenuItem meniuDespre;

    public BaraMeniuri() {
        meniuFisier = new JMenu();
        meniuAbonati = new JMenu();
        meniuAjutor = new JMenu();
        meniuDeschide = new JMenuItem();
        meniuSalvare = new JMenuItem();
        separatorMeniu = new JSeparator();
        meniuIesire = new JMenuItem();
        meniuAdaugaAbonat = new JMenuItem();
        meniuCautaAbonat = new JMenuItem();
        meniuStergeAbonat = new JMenuItem();
        meniuModificaAbonat = new JMenuItem();
        meniuInregistrare = new JMenuItem();
        meniuDespre = new JMenuItem();
        initializare();
    }

    private void initializare() {
        meniuFisier.add(meniuDeschide);
        meniuFisier.add(meniuSalvare);
        meniuFisier.add(separatorMeniu);
        meniuFisier.add(meniuIesire);
        add(meniuFisier);
        
        meniuAbonati.add(meniuAdaugaAbonat);
        meniuAbonati.add(meniuCautaAbonat);
        meniuAbonati.add(meniuStergeAbonat);
        meniuAbonati.add(meniuModificaAbonat);
        add(meniuAbonati);
        
        meniuAjutor.add(meniuInregistrare);
        meniuAjutor.add(meniuDespre);
        add(meniuAjutor);
        
    }
}
