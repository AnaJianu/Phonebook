/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.anajianu.agendatelefonica.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author ana
 */
public class PanouDetalii extends JPanel {
    private JLabel pozaAbonat;
    private JTextField numeAbonat;
    private JTextField prenumeAbonat;
    private JLabel telefonAbonatEticheta;
    private JTextField telefonAbonatValoare;
    private JLabel cnpAbonatEticheta;
    private JTextField cnpAbonatValoare;
    
    public PanouDetalii() {
        pozaAbonat=new JLabel("Poza");
        numeAbonat=new JTextField();
        prenumeAbonat=new JTextField();
        telefonAbonatEticheta=new JLabel("Telefon:");
        telefonAbonatValoare=new JTextField();
        cnpAbonatEticheta=new JLabel("CNP:");
        cnpAbonatValoare=new JTextField();
        initializare();
    }

    private void initializare() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc=new GridBagConstraints();
        
        gbc.gridx=0;
        gbc.gridy=0;
        add(pozaAbonat, gbc);
        
        gbc.gridx=1;
        gbc.gridy=0;
        add(numeAbonat,gbc);
        
        gbc.gridx=2;
        gbc.gridy=0;
        add(prenumeAbonat,gbc);
        
        gbc.gridx=0;
        gbc.gridy=1;
        add(telefonAbonatEticheta,gbc);
        
        gbc.gridx=1;
        gbc.gridy=1;
        add(telefonAbonatValoare,gbc);
        
        gbc.gridx=0;
        gbc.gridy=2;
        add(cnpAbonatEticheta,gbc);
        
        gbc.gridx=1;
        gbc.gridy=2;
        add(cnpAbonatValoare,gbc);
    }
    
    
    
}
