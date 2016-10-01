package ro.anajianu.agendatelefonica.view;

import java.awt.Dimension;
import javax.swing.JFrame;

public class CarteDeTelefonGUI {

    private final JFrame cadru;
    private final PanouPrincipal panouPrincipal;
    private BaraMeniuri baraMeniuri;

    public CarteDeTelefonGUI() {

        panouPrincipal = new PanouPrincipal();
        baraMeniuri=new BaraMeniuri();
        cadru = new JFrame("Agenda Telefonica");
        cadru.setJMenuBar(baraMeniuri);
        cadru.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cadru.setSize(new Dimension(1000, 1000));
        cadru.getContentPane().add(panouPrincipal);

        cadru.setVisible(true);
    }

    public static void main(String[] args) {
        CarteDeTelefonGUI carteDeTelefonGUI = new CarteDeTelefonGUI();
    }

}
