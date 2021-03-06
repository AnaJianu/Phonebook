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
    private final JButton butonCautare;
    private final JButton butonIesire;
    private final JButton butonSortare;
    private final CarteDeTelefonController controller;

    public PanouButoane(CarteDeTelefonController controller) {

        this.controller = controller;

        butonAdaugare = new JButton("Adaugare");
        butonStergere = new JButton("Stergere");
        butonModificare = new JButton("Modificare");
        butonCautare = new JButton("Cautare");
        butonIesire = new JButton("Iesire");
        butonSortare = new JButton("Sortare");
        initializare();
    }

    private void initializare() {
        initializareButonStergere();
        initializareButonIesire();
        initializareButonAdaugare();
        initializareButonCautare();
        initializareButonModificare();
        initializareButonSortare();

        add(butonAdaugare);
        add(butonStergere);
        add(butonModificare);
        add(butonCautare);
        add(butonIesire);
        add(butonSortare);

        setLayout(new GridLayout(3, 2));

    }

    private void initializareButonStergere() {
        butonStergere.setToolTipText("Sterge abonat");
        butonStergere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.stergeAbonat();
            }
        });
    }

    private void initializareButonIesire() {
        butonIesire.setToolTipText("Iesire din aplicatie");
        butonIesire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iesireDinAplicatie();
            }
        });
    }

    public void iesireDinAplicatie() {
        int n = JOptionPane.showConfirmDialog(null, "Confirmati iesirea din aplicatie?", "Iesire aplicatie", JOptionPane.YES_NO_OPTION);
        if (n == 0) {
            System.exit(0);
        }
    }

    private void initializareButonAdaugare() {
        butonAdaugare.setToolTipText("Adaugare abonat");
        butonAdaugare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.adaugaAbonat();
            }
        });
    }

    private void initializareButonCautare() {
        butonCautare.setToolTipText("Cautare abonat");
        butonCautare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.cautaAbonatDinMeniu();
            }
        });
    }

    private void initializareButonModificare() {
        butonModificare.setToolTipText("Modificare date abonat");
        butonModificare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.modificaAbonat();

            }
        });
    }

    private void initializareButonSortare() {
        butonSortare.setToolTipText("Sortare lista abonati");
        butonSortare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.sortareAbonati();
            }
        });
    }

}
