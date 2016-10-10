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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import ro.anajianu.agendatelefonica.controller.CarteDeTelefonController;
import ro.anajianu.agendatelefonica.model.Abonat;
import ro.anajianu.agendatelefonica.model.NrFix;
import ro.anajianu.agendatelefonica.model.NrMobil;
import ro.anajianu.agendatelefonica.model.NrTelefon;

/**
 *
 * @author ana
 */
public class PanouDetalii extends JPanel implements ListSelectionListener {

    private final CarteDeTelefonController controller;

    private final JLabel pozaAbonat;
    private final ImageIcon iconAbonat;
    private final JTextField numeAbonat;
    private final JTextField prenumeAbonat;
    private final JLabel telefonAbonatEticheta;
    private final JTextField telefonAbonatValoare;
    private final JLabel cnpAbonatEticheta;
    private final JTextField cnpAbonatValoare;

    public PanouDetalii(CarteDeTelefonController controller) {
        this.controller = controller;
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
        String nrTelefonIntrodus = telefonAbonatValoare.getText();
        NrTelefon nrTelefon;
        
        if (nrTelefonIntrodus.length()==10 && (nrTelefonIntrodus.startsWith("02") || nrTelefonIntrodus.startsWith("03"))) {
            nrTelefon = new NrFix(nrTelefonIntrodus);
        } else if (nrTelefonIntrodus.length()==10&& nrTelefonIntrodus.startsWith("07")) {
            nrTelefon = new NrMobil(nrTelefonIntrodus);
        } else {
            JOptionPane.showMessageDialog(null, "Numar invalid!", "Atentie!", JOptionPane.WARNING_MESSAGE);
            throw new RuntimeException("Numar invalid!");
        }
        int nrAbonati=controller.getListaAbonati().size();
        String idCurent= Integer.toString(nrAbonati);
        Abonat abonatNou = new Abonat(idCurent, numeAbonat.getText(), prenumeAbonat.getText(), nrTelefon, cnpAbonatValoare.getText());

        return abonatNou;

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        Abonat selectedAbonat = controller.getSelectedAbonat();
        if (selectedAbonat != null) {
            numeAbonat.setText(selectedAbonat.getNume());
            prenumeAbonat.setText(selectedAbonat.getPrenume());
            telefonAbonatValoare.setText(selectedAbonat.getNumarTelefon().toString());
            cnpAbonatValoare.setText(selectedAbonat.getCNP());
        }

    }

    public void modificaAbonatAfisat() {
        Abonat abonatAfisat = controller.getSelectedAbonat();

    }

    public Abonat getAbonatAfisat() {
        NrTelefon nrDeModificat = new NrMobil(telefonAbonatValoare.getText());
        String numar = "2";
        String numeModificat = numeAbonat.getText();
        String prenumeModificat = prenumeAbonat.getText();
        String cnpModificat = cnpAbonatValoare.getText();

        return new Abonat(numar, numeModificat, prenumeModificat, nrDeModificat, cnpModificat);

    }

}
