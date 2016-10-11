package ro.anajianu.agendatelefonica.view;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import ro.anajianu.agendatelefonica.controller.CarteDeTelefonController;
import ro.anajianu.agendatelefonica.model.Abonat;

public class CarteDeTelefonGUI {

    private final JFrame cadru;
    private final PanouPrincipal panouPrincipal;
    private final BaraMeniuri baraMeniuri;

    public CarteDeTelefonGUI(CarteDeTelefonController controller) {

        panouPrincipal = new PanouPrincipal(controller);
        baraMeniuri = new BaraMeniuri(controller);
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

    public void adaugaAbonatDinView() {
        Abonat abonatNou = panouPrincipal.getPanouDreapta().getPanouDetalii().getAbonatDeAdaugat();
        panouPrincipal.getPanouStanga().adaugaAbonatInTabel(abonatNou);
        stergeCampuriDetaliiAbonat();
    }

    public void stergeAbonatDinTabel() {
        panouPrincipal.getPanouStanga().stergeAbonatDinTabel();
    }

    public void iesireDinAplicatie() {
        panouPrincipal.getPanouDreapta().getPanouButoane().iesireDinAplicatie();
    }

    public PanouPrincipal getPanouPrincipal() {
        return panouPrincipal;
    }

    public void sortareAbonatInTabel() {
        String[] coloane = {"Nume", "Prenume", "Telefon", "CNP"};

        Object optiuneSelectata = JOptionPane.showInputDialog(null, "Alegeti criteriul de sortare", "Sortare lista", JOptionPane.DEFAULT_OPTION, null, coloane, "Nume");
        if (optiuneSelectata != null) {
            String coloanaSelectata = optiuneSelectata.toString();
            panouPrincipal.getPanouStanga().sortareAbonat(coloanaSelectata);
        }

    }

}
