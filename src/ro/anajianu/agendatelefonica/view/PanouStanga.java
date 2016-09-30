/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.anajianu.agendatelefonica.view;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author ana
 */
public class PanouStanga extends JPanel{
    private JTextField campCautare;
    private JTable tabelAbonati;
    
    public PanouStanga() {
        campCautare=new JTextField("Cautare");
        tabelAbonati=new JTable();
        initializare();
    }
    
    public void initializare() {
        setSize(new Dimension(500, 900));
        add(campCautare);
        add(tabelAbonati);
    }
  
    
}
