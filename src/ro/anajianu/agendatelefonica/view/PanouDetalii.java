/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.anajianu.agendatelefonica.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author ana
 */
public class PanouDetalii extends JPanel {
    private final JLabel pozaAbonat;
    private final JTextField numeAbonat;
    private final JTextField prenumeAbonat;
    private final JLabel telefonAbonatEticheta;
    private final JTextField telefonAbonatValoare;
    private final JLabel cnpAbonatEticheta;
    private final JTextField cnpAbonatValoare;
    
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
        gbc.anchor=GridBagConstraints.NORTHWEST;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets=new Insets(20, 20, 0, 0);
        add(pozaAbonat, gbc);
        
        gbc.gridx=1;
        gbc.gridy=0;
        gbc.ipadx=100;
        add(numeAbonat,gbc);
        
        gbc.gridx=2;
        gbc.gridy=0;
        gbc.ipadx=100;
        add(prenumeAbonat,gbc);
        
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.ipadx=0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets=new Insets(0, 0, 0, 0);
        add(telefonAbonatEticheta,gbc);
        
        gbc.gridx=1;
        gbc.gridy=1;
        gbc.gridwidth=2;
        gbc.ipadx=200;
        add(telefonAbonatValoare,gbc);
        
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.ipadx=0;
        add(cnpAbonatEticheta,gbc);
        
        gbc.gridx=1;
        gbc.gridy=2;
        gbc.gridwidth=2;
        gbc.ipadx=200;
        add(cnpAbonatValoare,gbc);
    }
    
    
    
}
