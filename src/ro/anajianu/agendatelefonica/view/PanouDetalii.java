/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.anajianu.agendatelefonica.view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author ana
 */
public class PanouDetalii extends JPanel {
    private JLabel pozaAbonat;
    private JLabel numeAbonat;
    private JLabel prenumeAbonat;
    private JLabel telefonAbonatEticheta;
    private JTextField telefonAbonatValoare;
    private JLabel cnpAbonatEticheta;
    private JTextField cnpAbonatValoare;
    
    public PanouDetalii() {
        pozaAbonat=new JLabel();
        numeAbonat=new JLabel();
        prenumeAbonat=new JLabel();
        telefonAbonatEticheta=new JLabel("Telefon:");
        telefonAbonatValoare=new JTextField();
        cnpAbonatEticheta=new JLabel("CNP:");
        cnpAbonatValoare=new JTextField();
        initializare();
    }

    private void initializare() {
        add(pozaAbonat);
        add(numeAbonat);
        add(prenumeAbonat);
        add(telefonAbonatEticheta);
        add(telefonAbonatValoare);
        add(cnpAbonatEticheta);
        add(cnpAbonatValoare);
    }
    
    
    
}
