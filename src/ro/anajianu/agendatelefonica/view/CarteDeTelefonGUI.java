package ro.anajianu.agendatelefonica.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;


public class CarteDeTelefonGUI {
    private JFrame cadru;
    private JPanel panouPrincipal;
    private JPanel panouStanga;
    private JPanel panouDreapta;
    private JTextField campCautare;
    private JTable tabelAbonati;
    private JPanel panouDetalii;
    private JPanel panouButoane;
    private JLabel pozaAbonat;
    private JLabel numeAbonat;
    private JLabel prenumeAbonat;
    private JLabel telefonAbonatEticheta;
    private JLabel telefonAbonatValoare;
    private JLabel cnpAbonatEticheta;
    private JLabel cnpAbonatValoare;
    private JButton butonAdaugare;
    private JButton butonStergere;
    private JButton butonModificare;
    private JButton butonSortare;
    private JButton butonCautare;
    private JButton butonIesire;
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
       
        panouPrincipal=new JPanel(new GridLayout(2, 2));
        panouPrincipal.setSize(new Dimension(1000, 1000));
        
        panouStanga=new JPanel(new GridLayout(2, 1));
        campCautare=new JTextField("Cautare");
        tabelAbonati=new JTable();
        panouStanga.add(campCautare);
        panouStanga.add(tabelAbonati);
        panouStanga.setSize(new Dimension(500, 900));
        
        
        
        panouDreapta=new JPanel(new GridLayout(2, 1));
        panouDreapta.setSize(new Dimension(500, 900));
        panouDetalii=new JPanel(new GridLayout(3, 3));
        panouDetalii.setSize(new Dimension(500, 450));
        panouButoane=new JPanel(new GridLayout(3, 2));
        panouButoane.setSize(new Dimension(500, 450));
        panouDreapta.add(panouDetalii);
        panouDreapta.add(panouButoane);
        
        
        
        panouPrincipal.add(panouStanga);
        panouPrincipal.add(panouDreapta);
        
        cadru=new JFrame("Agenda Telefonica");
        cadru.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        cadru.setSize(new Dimension(1000,1000));
        cadru.getContentPane().add(panouPrincipal);
        cadru.pack();
        cadru.setVisible(true);
    }
    
    public static void main (String[] args) {
        CarteDeTelefonGUI carteDeTelefonGUI=new CarteDeTelefonGUI();
    }
            
    
    
    
}
