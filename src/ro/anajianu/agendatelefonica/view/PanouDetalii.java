package ro.anajianu.agendatelefonica.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
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
    private final JTextField numeAbonat;
    private final JTextField prenumeAbonat;
    private final JLabel telefonAbonatEticheta;
    private final JTextField telefonAbonatValoare;
    private final JLabel cnpAbonatEticheta;
    private final JTextField cnpAbonatValoare;

    public PanouDetalii(CarteDeTelefonController controller) {
        this.controller = controller;
        pozaAbonat = new JLabel("NP", SwingConstants.CENTER);
        pozaAbonat.setForeground(Color.BLACK);
        pozaAbonat.setBackground(Color.ORANGE);
        pozaAbonat.setOpaque(true);
        numeAbonat = new JTextField("Nume");
        numeAbonat.setColumns(120);
        prenumeAbonat = new JTextField("Prenume");
        prenumeAbonat.setColumns(120);
       
        telefonAbonatEticheta = new JLabel("Telefon:");
        telefonAbonatValoare = new JTextField();
        telefonAbonatValoare.setColumns(60);
        cnpAbonatEticheta = new JLabel("CNP:");
        cnpAbonatValoare = new JTextField();
        cnpAbonatValoare.setColumns(80);
        initializare();
    }

    private void initializare() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(pozaAbonat, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(numeAbonat, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        add(prenumeAbonat, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(telefonAbonatEticheta, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(telefonAbonatValoare, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(cnpAbonatEticheta, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(cnpAbonatValoare, gbc);
    }

    public void stergeCampuriDetaliiAbonat() {
        numeAbonat.setText("");
        prenumeAbonat.setText("");
        telefonAbonatValoare.setText("");
        cnpAbonatValoare.setText("");
        pozaAbonat.setText("  ");
    }

    /**
     * Preia textul din panoul de detalii si valideaza informatiile introduse
     * de utilizator.
     * Afiseaza o fereastra in cazul in urmatoarele cazuri:
     * - Numele si Prenumele lipsesc;
     * - CNP-ul are lungimea incorecta sau nu incepe cu cifrele 1/2. Pe langa
     * aceasta verificare, este validata si data nasterii din CNP.
     * In cazul in care data nasterii este incorecta, utilizatorul este
     * notificat si arunca o exceptie de tipul {@link RuntimeException}.
     * - Telefonul are lungime incorecta si nu incepe cu 07 (mobil) sau 02/03
     * (fix).
     * 
     *
     * @return Abonat care a fost initializat din informatiile introduse de
     * utilizator.
     */
    public Abonat getAbonatDeAdaugat() {
        String nrTelefonIntrodus = telefonAbonatValoare.getText();
        NrTelefon nrTelefon;

        nrTelefon = creareTelefonDin(nrTelefonIntrodus);
        int nrAbonati = controller.getListaAbonati().size();
        String idCurent = Integer.toString(nrAbonati);

        String numeIntrodus = numeAbonat.getText();
        String prenumeIntrodus = prenumeAbonat.getText();
        String cnpIntrodus = cnpAbonatValoare.getText();

        if (numeIntrodus.length() == 0 && prenumeIntrodus.length() == 0) {
            JOptionPane.showMessageDialog(null, "Introduceti numele si prenumele!", "Atentie!", JOptionPane.WARNING_MESSAGE);
            throw new RuntimeException("Nume si prenume lipsa!");
        }

        if (cnpIntrodus.length() != 13 && (!cnpIntrodus.startsWith("1") || !cnpIntrodus.startsWith("2"))) {
            JOptionPane.showMessageDialog(null, "Introduceti CNP-ul corect!", "Atentie!", JOptionPane.WARNING_MESSAGE);
            throw new RuntimeException("CNP invalid!");
        }

        String dataDinCNP = cnpIntrodus.substring(1, 7);
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
            sdf.setLenient(false);
            sdf.parse(dataDinCNP);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Data de nastere invalida!", "Atentie!", JOptionPane.WARNING_MESSAGE);
            throw new RuntimeException(ex);
        }

        Abonat abonatNou = new Abonat(idCurent, numeIntrodus, prenumeIntrodus, nrTelefon, cnpIntrodus);

        return abonatNou;

    }

    private NrTelefon creareTelefonDin(String nrTelefonIntrodus) throws RuntimeException {
        NrTelefon nrTelefon = null;
        if (nrTelefonIntrodus.length() == 10 && (nrTelefonIntrodus.startsWith("02") || nrTelefonIntrodus.startsWith("03"))) {
            nrTelefon = new NrFix(nrTelefonIntrodus);
        } else if (nrTelefonIntrodus.length() == 10 && nrTelefonIntrodus.startsWith("07")) {
            nrTelefon = new NrMobil(nrTelefonIntrodus);
        } else {
            JOptionPane.showMessageDialog(null, "Numar invalid!", "Atentie!", JOptionPane.WARNING_MESSAGE);
            throw new RuntimeException("Numar invalid!");
        }
        return nrTelefon;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        Abonat selectedAbonat = controller.getSelectedAbonat();
        if (selectedAbonat != null) {
            numeAbonat.setText(selectedAbonat.getNume());
            prenumeAbonat.setText(selectedAbonat.getPrenume());
            telefonAbonatValoare.setText(selectedAbonat.getNumarTelefon().toString());
            cnpAbonatValoare.setText(selectedAbonat.getCNP());
            pozaAbonat.setText(selectedAbonat.getNume().substring(0, 1)+selectedAbonat.getPrenume().substring(0, 1));
        }

    }

    public void modificaAbonatAfisat() {
        Abonat abonatAfisat = controller.getSelectedAbonat();

    }

    public Abonat getAbonatAfisat() {
        NrTelefon nrDeModificat = creareTelefonDin(telefonAbonatValoare.getText());
        String numar = "SCHIMBAT_LA_MODIFICARE";
        String numeModificat = numeAbonat.getText();
        String prenumeModificat = prenumeAbonat.getText();
        String cnpModificat = cnpAbonatValoare.getText();

        return new Abonat(numar, numeModificat, prenumeModificat, nrDeModificat, cnpModificat);

    }

}
