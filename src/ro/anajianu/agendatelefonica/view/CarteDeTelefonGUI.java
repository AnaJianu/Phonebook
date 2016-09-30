package ro.anajianu.agendatelefonica.view;

import java.awt.Dimension;
import javax.swing.JFrame;

public class CarteDeTelefonGUI {

    private final JFrame cadru;
    private final PanouPrincipal panouPrincipal;
    private BaraMeniuri baraMeniuri;

    public CarteDeTelefonGUI() {

        panouPrincipal = new PanouPrincipal();
        cadru = new JFrame("Agenda Telefonica");
        cadru.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cadru.setSize(new Dimension(1000, 1000));
        cadru.getContentPane().add(panouPrincipal);
        cadru.setJMenuBar(baraMeniuri);
        cadru.setVisible(true);
    }

    public static void main(String[] args) {
        CarteDeTelefonGUI carteDeTelefonGUI = new CarteDeTelefonGUI();
    }

}
