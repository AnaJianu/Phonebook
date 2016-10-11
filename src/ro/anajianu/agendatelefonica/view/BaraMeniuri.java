/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.anajianu.agendatelefonica.view;

import com.sun.glass.events.KeyEvent;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import ro.anajianu.agendatelefonica.controller.CarteDeTelefonController;

/**
 *
 * @author ana
 */
public class BaraMeniuri extends JMenuBar {

    private static boolean isAppRegistered = false;

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
        initializareSubmeniuSalvare();
        initializareSubmeniuInregistrare();
        initializareSubmeniuDespre();
        initializareSubmeniuModificare();
    }

    private void initializare() {
        meniuFisier.add(submeniuDeschide);
        meniuFisier.add(submeniuSalvare);
        meniuFisier.add(separatorMeniu);
        meniuFisier.add(submeniuIesire);
        meniuFisier.setMnemonic(KeyEvent.VK_F);
        add(meniuFisier);

        meniuAbonati.add(submeniuAdaugaAbonat);
        meniuAbonati.add(submeniuCautaAbonat);
        meniuAbonati.add(submeniuStergeAbonat);
        meniuAbonati.add(submeniuModificaAbonat);
        meniuAbonati.setMnemonic(KeyEvent.VK_A);
        add(meniuAbonati);

        meniuAjutor.add(submeniuInregistrare);
        meniuAjutor.add(submeniuDespre);
        meniuAjutor.setMnemonic(KeyEvent.VK_U);
        add(meniuAjutor);

    }

    private void initializareSubmeniuIesire() {
        submeniuIesire.setMnemonic(KeyEvent.VK_I);
        submeniuIesire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.iesireDinAplicatie();
            }
        });
    }

    private void initializareSubmeniuStergeAbonat() {
        submeniuStergeAbonat.setMnemonic(KeyEvent.VK_R);
        submeniuStergeAbonat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.stergeAbonat();
            }
        });

    }

    private void initializareSubmeniuCautaAbonat() {
        submeniuCautaAbonat.setMnemonic(KeyEvent.VK_C);
        submeniuCautaAbonat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.cautaAbonatDinMeniu();
            }
        });

    }

    private void initializareSubmeniuDeschide() {
        submeniuDeschide.setMnemonic(KeyEvent.VK_D);
        submeniuDeschide.setEnabled(isAppRegistered);
        submeniuDeschide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File fisierSelectat = fileChooser.getSelectedFile();
                    controller.incarcaDateDinFisier(fisierSelectat);
                }

            }
        });
    }

    private void initializareSubmeniuSalvare() {
        submeniuSalvare.setMnemonic(KeyEvent.VK_S);
        submeniuSalvare.setEnabled(isAppRegistered);
        submeniuSalvare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Alege locatia de salvare");

                int selection = fileChooser.showSaveDialog(null);
                if (selection == JFileChooser.APPROVE_OPTION) {
                    String absolutePath = fileChooser.getSelectedFile().getAbsolutePath();
                    File file = new File(absolutePath);
                    System.out.print(file);
                    controller.salveazaFisier(file);
                }
            }
        });
    }

    private void initializareSubmeniuInregistrare() {
        submeniuInregistrare.setMnemonic(KeyEvent.VK_I);
        submeniuInregistrare.addActionListener(new ActionListener() {
            private final int codInregistrare = 1234;

            @Override
            public void actionPerformed(ActionEvent e) {

                String cod = JOptionPane.showInputDialog(null, "Va rugam introduceti codul de inregistrare!", "Cod inregistrare", JOptionPane.OK_CANCEL_OPTION);
                if (cod.equals("1234")) {
                    isAppRegistered = true;
                    submeniuDeschide.setEnabled(isAppRegistered);
                    submeniuSalvare.setEnabled(isAppRegistered);
                    submeniuInregistrare.setEnabled(!isAppRegistered);
                    controller.dezactivareReclame();
                    JOptionPane.showMessageDialog(null, "Cod corect!",
                            "Operatiune reusita!",
                            JOptionPane.OK_OPTION);

                } else {
                    JOptionPane.showMessageDialog(null, "Cod invalid!",
                            "Atentie!",
                            JOptionPane.OK_OPTION);
                }

            }
        });
    }

    private void initializareSubmeniuDespre() {
        submeniuDespre.setMnemonic(KeyEvent.VK_D);
        submeniuDespre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] texte = {"Autorul aplicatiei: Ana Jianu. ",
                    "Aplicatia este o agenda telefonica si are, pe scurt, facilitati de: ",
                    "1.Adaugare abonat",
                    "2.Stergere abonat",
                    "3.Sortare lista abonati",
                    "4.Modificare date abonat",
                    "5.Cautare abonat",
                    "6.Iesire din aplicatie"
                };
                JList lista = new JList(texte);

                JScrollPane panouDespre = new JScrollPane(lista);

                panouDespre.setPreferredSize(new Dimension(350, 200));
                JOptionPane.showMessageDialog(null, panouDespre, "Despre autor si aplicatie", JOptionPane.CLOSED_OPTION);

            }

        });
    }

    private void initializareSubmeniuModificare() {
        submeniuModificaAbonat.setMnemonic(KeyEvent.VK_M);
        submeniuModificaAbonat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.modificaAbonat();
            }
        });
    }

}
