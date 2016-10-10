/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.anajianu.agendatelefonica.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;
import ro.anajianu.agendatelefonica.controller.CarteDeTelefonController;
import ro.anajianu.agendatelefonica.model.Abonat;
import ro.anajianu.agendatelefonica.model.CarteDeTelefon;
import ro.anajianu.agendatelefonica.model.ModelTabel;
import ro.anajianu.agendatelefonica.model.NrMobil;

/**
 *
 * @author ana
 */
public class PanouStanga extends JPanel {

    private JTextField campCautare;
    private final JScrollPane scrollPane;
    private final JTable tabelAbonati;
    private ModelTabel modelTabel;
    private TableRowSorter<ModelTabel> filtruTabel;
    private List<Abonat> listaProbaAbonati;
    private final CarteDeTelefonController controller;
    private CarteDeTelefon modelCarte;

    public PanouStanga(CarteDeTelefonController controller) {
        this.controller = controller;
        modelCarte=controller.getModelCarte();
        campCautare = new JTextField("Cautare...");
        tabelAbonati = new JTable();
        scrollPane = new JScrollPane(tabelAbonati);

        creareAbonati();
        initializare();
        adaugareDocumentListenerCautare(campCautare);
    }

    private void creareAbonati() {
        
        listaProbaAbonati = controller.getListaAbonati();


        modelTabel = modelCarte.getModelTabel();
        tabelAbonati.setModel(modelTabel);
        tabelAbonati.setAutoCreateRowSorter(true);
        filtruTabel = new TableRowSorter<>(modelTabel);
        tabelAbonati.setRowSorter(filtruTabel);
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

    public void adaugareDocumentListenerCautare(JTextField campPentruListener) {

        campPentruListener.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = campPentruListener.getText();

                if (text.trim().length() == 0) {
                    filtruTabel.setRowFilter(null);
                } else {
                    filtruTabel.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = campPentruListener.getText();

                if (text.trim().length() == 0) {
                    filtruTabel.setRowFilter(null);
                } else {
                    filtruTabel.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    public void adaugaSelectionListenerPeTabel(PanouDetalii panouDetalii) {
        ListSelectionModel modelSelectie = tabelAbonati.getSelectionModel();
        modelSelectie.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        modelSelectie.addListSelectionListener(panouDetalii);

    }

    public Abonat getAbonatSelectatDinTabel() {
        int selectedRow = tabelAbonati.getSelectedRow();
        if (selectedRow == -1) {
            return null;
        }
        return modelTabel.getAbonatAt(selectedRow);

    }

}
