package ro.anajianu.agendatelefonica.view;

import java.awt.Dimension;
import javax.swing.JFrame;
import ro.anajianu.agendatelefonica.controller.CarteDeTelefonController;

public class CarteDeTelefonGUI {

    private final JFrame cadru;
    private final PanouPrincipal panouPrincipal;
    private final BaraMeniuri baraMeniuri;

    public CarteDeTelefonGUI(CarteDeTelefonController controller) {

        panouPrincipal = new PanouPrincipal(controller);
        baraMeniuri=new BaraMeniuri();
        cadru = new JFrame("Agenda Telefonica");
        cadru.setJMenuBar(baraMeniuri);
        cadru.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cadru.setSize(new Dimension(1000, 1000));
        cadru.getContentPane().add(panouPrincipal);

        cadru.setVisible(true);
    }

    public void stergeCampuriDetaliiAbonat() {
        panouPrincipal.getPanouDreapta().getPanouDetalii().stergeCampuriDetaliiAbonat();
    }


}
