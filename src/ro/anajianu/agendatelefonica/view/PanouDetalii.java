/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.anajianu.agendatelefonica.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import ro.anajianu.agendatelefonica.controller.CarteDeTelefonController;
import ro.anajianu.agendatelefonica.model.Abonat;
import ro.anajianu.agendatelefonica.model.NrMobil;
import ro.anajianu.agendatelefonica.model.NrTelefon;

/**
 *
 * @author ana
 */
public class PanouDetalii extends JPanel {

    private final JLabel pozaAbonat;
    private final ImageIcon iconAbonat;
    private final JTextField numeAbonat;
    private final JTextField prenumeAbonat;
    private final JLabel telefonAbonatEticheta;
    private final JTextField telefonAbonatValoare;
    private final JLabel cnpAbonatEticheta;
    private final JTextField cnpAbonatValoare;

    public PanouDetalii(CarteDeTelefonController controller) {
        iconAbonat = new ImageIcon("resources/emptyPhoto.png");
        pozaAbonat = new JLabel(iconAbonat);
        numeAbonat = new JTextField("Nume");
        prenumeAbonat = new JTextField("Prenume");
        telefonAbonatEticheta = new JLabel("Telefon:");
        telefonAbonatValoare = new JTextField();
        cnpAbonatEticheta = new JLabel("CNP:");
        cnpAbonatValoare = new JTextField();
        initializare();
    }

    private void initializare() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(pozaAbonat, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.ipadx = 100;
        add(numeAbonat, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.ipadx = 100;
        add(prenumeAbonat, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipadx = 0;
        add(telefonAbonatEticheta, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.ipadx = 200;
        add(telefonAbonatValoare, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.ipadx = 0;
        add(cnpAbonatEticheta, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.ipadx = 200;
        add(cnpAbonatValoare, gbc);
    }

    public void stergeCampuriDetaliiAbonat() {
        numeAbonat.setText("");
        prenumeAbonat.setText("");
        telefonAbonatValoare.setText("");
        cnpAbonatValoare.setText("");
    }

    public Abonat getAbonatDeAdaugat() {
        NrTelefon nrTelefon = new NrMobil(telefonAbonatValoare.getText());

        Abonat abonatNou = new Abonat("3", numeAbonat.getText(), prenumeAbonat.getText(), nrTelefon, cnpAbonatValoare.getText());

        return abonatNou;
        
        

    }

}
