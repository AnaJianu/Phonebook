/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.anajianu.agendatelefonica.start;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 *
 * @author ana
 */
public class SplashScreen extends JFrame {
    private final JLabel labelImagine;
    private final ImageIcon imagineFundal;
    private static JProgressBar baraProgres;
    private Thread threadPrincipal = null;

    public SplashScreen() {
        super("Initializare Agenda Telefonica");
        setSize(560, 480);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setLayout(null);

        imagineFundal = new ImageIcon("resources/agendaTelefonicaSplashScreen.png");
        labelImagine = new JLabel(imagineFundal);
        labelImagine.setBounds(0, 0, 560, 480);
        add(labelImagine);

        JLabel labelAutor = new JLabel("Ana Jianu");
        add(labelAutor);
        labelAutor.setBounds(480, 440, 150, 20);

        baraProgres = new JProgressBar();
        baraProgres.setMinimum(0);
        baraProgres.setMaximum(100);
        baraProgres.setStringPainted(true);
        baraProgres.setBackground(Color.ORANGE);

        baraProgres.setBounds(0, 450, 560, 40);
        add(baraProgres);

        threadPrincipal = new Thread() {

            @Override
            public void run() {
                int i = 0;
                while (i <= 100) {
                    baraProgres.setValue(i);
                    try {
                        sleep(35);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(SplashScreen.class.getName()).
                                log(Level.SEVERE, null, ex);
                    }
                    i++;
                }
            }
        };

    }

    public void start() {
        threadPrincipal.start();
    }

}
