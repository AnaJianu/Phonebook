/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.anajianu.agendatelefonica.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import ro.anajianu.agendatelefonica.model.Abonat;
import ro.anajianu.agendatelefonica.model.ModelTabel;
import ro.anajianu.agendatelefonica.model.NrMobil;

/**
 *
 * @author ana
 */
public class PanouStanga extends JPanel {

    private final JTextField campCautare;
    private final JScrollPane scrollPane;
    private final JTable tabelAbonati;

    public PanouStanga() {
        campCautare = new JTextField("Cautare");
        tabelAbonati = new JTable();
        scrollPane = new JScrollPane(tabelAbonati);
        creareAbonati();
        initializare();
    }

    private void creareAbonati() {
        List<Abonat> listaProbaAbonati = new ArrayList<>();
        NrMobil telefon = new NrMobil("0756798889");
        Abonat a1 = new Abonat("0", "Popescu", "Ion", telefon, "190032850028");
        Abonat a2 = new Abonat("1", "Dumitru", "Aura", telefon, "291090340028");
        Abonat a3 = new Abonat("2", "Visinescu", "Dan", telefon, "182082550028");
        listaProbaAbonati.add(a1);
        listaProbaAbonati.add(a2);
        listaProbaAbonati.add(a3);

        ModelTabel modelTabel = new ModelTabel(listaProbaAbonati);
        tabelAbonati.setModel(modelTabel);
    }

    private void initializare() {
        setSize(new Dimension(500, 900));
        setLayout(new GridLayout(2, 1));
        add(campCautare);
        add(scrollPane);
    }

}
