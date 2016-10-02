/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.anajianu.agendatelefonica.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
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
    private ModelTabel modelTabel;
    private List<Abonat> listaProbaAbonati;

    public PanouStanga() {
        campCautare = new JTextField("Cautare...");
        tabelAbonati = new JTable();
        scrollPane = new JScrollPane(tabelAbonati);
        creareAbonati();
        initializare();
    }

    private void creareAbonati() {
        listaProbaAbonati = new ArrayList<>();
        NrMobil telefon = new NrMobil("0756798889");
        Abonat a1 = new Abonat("0", "Popescu", "Ion", telefon, "190032850028");
        Abonat a2 = new Abonat("1", "Dumitru", "Andra", telefon, "291090340028");
        Abonat a3 = new Abonat("2", "Visinescu", "Dan", telefon, "182082550028");
        listaProbaAbonati.add(a1);
        listaProbaAbonati.add(a2);
        listaProbaAbonati.add(a3);

        modelTabel = new ModelTabel(listaProbaAbonati);
        tabelAbonati.setModel(modelTabel);
    }

    private void initializare() {
        setSize(new Dimension(500, 900));
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        campCautare.setHorizontalAlignment(JTextField.CENTER);
        add(campCautare, c);
        c.gridx = 0;
        c.gridy = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.VERTICAL;
        scrollPane.setMinimumSize(new Dimension(500, 900));
        add(scrollPane, c);
    }

    void adaugaAbonatInTabel(Abonat abonatNou) {
        listaProbaAbonati.add(abonatNou);
        modelTabel.notificareAdaugareAbonat();
    }

    void stergeAbonatDinTabel() {
        int randSelectat = tabelAbonati.getSelectedRow();
        if (randSelectat == -1) {
            notificaUtilizatorul();
        } else {
            listaProbaAbonati.remove(randSelectat);
            modelTabel.notificareStergereAbonat();
        }

    }

    private void notificaUtilizatorul() {
        JOptionPane.showMessageDialog(null, "Va rugam selectati un abonat!", 
                "Stergere abonat din tabel", 
                JOptionPane.OK_OPTION);
    }

}
