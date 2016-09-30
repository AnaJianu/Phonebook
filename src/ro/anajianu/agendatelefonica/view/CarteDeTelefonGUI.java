package ro.anajianu.agendatelefonica.view;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class CarteDeTelefonGUI {

    private final JFrame cadru;
    private final PanouPrincipal panouPrincipal;

    private JMenuBar baraMeniuri;
    private JMenu meniuFisier;
    private JMenu meniuAbonati;
    private JMenu meniuAjutor;
    private JMenuItem meniuDeschide;
    private JMenuItem meniuSalvare;
    private JSeparator separatorMeniu;
    private JMenuItem meniuIesire;
    private JMenuItem meniuAdaugaAbonat;
    private JMenuItem meniuCautaAbonat;
    private JMenuItem meniuStergeAbonat;
    private JMenuItem meniuModificaAbonat;
    private JMenuItem meniuInregistrare;
    private JMenuItem meniuDespre;

    public CarteDeTelefonGUI() {

        panouPrincipal = new PanouPrincipal();
        cadru = new JFrame("Agenda Telefonica");
        cadru.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cadru.setSize(new Dimension(1000, 1000));
        cadru.getContentPane().add(panouPrincipal);
//        cadru.pack();
        cadru.setVisible(true);
    }

    public static void main(String[] args) {
        CarteDeTelefonGUI carteDeTelefonGUI = new CarteDeTelefonGUI();
    }

}
