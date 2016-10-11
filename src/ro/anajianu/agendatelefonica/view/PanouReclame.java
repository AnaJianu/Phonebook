/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.anajianu.agendatelefonica.view;

import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ana
 */
public class PanouReclame extends JPanel {

    private JLabel suportReclame;
    private ImageIcon reclama1;
    private ImageIcon reclama2;
    private ImageIcon reclama3;
    private int randomNumber;
    private static final int BANNER_DISPLAY_TIME = 2000;
    private final Random rand = new Random();

    private Thread mainAdsThread = null;

    public PanouReclame() {
        initializare();
        startRotireReclame();
    }

    private void initializare() {
        setSize(400, 100);
        reclama1 = new ImageIcon("resources/reclama1.jpg");
        reclama2 = new ImageIcon("resources/reclama2.jpg");
        reclama3 = new ImageIcon("resources/reclama3.jpg");
        suportReclame = new JLabel(reclama1);
        suportReclame.setBounds(0, 0, 400, 100);
        add(suportReclame);
    }

    private void startRotireReclame() {
        mainAdsThread = new Thread() {

            @Override
            public void run() {
                while (true) {
                    randomNumber = rand.nextInt(4);

                    switch (randomNumber) {
                        case 3:
                            suportReclame.setIcon(reclama3);
                            repaint();
                            afiseazaReclamaPentruPerioada(BANNER_DISPLAY_TIME);
                            break;
                        case 2:
                            suportReclame.setIcon(reclama2);
                            repaint();
                            afiseazaReclamaPentruPerioada(BANNER_DISPLAY_TIME);
                            break;
                        case 1:
                            suportReclame.setIcon(reclama1);
                            repaint();
                            afiseazaReclamaPentruPerioada(BANNER_DISPLAY_TIME);
                            break;
                        default:
                            break;
                    }

                }
            }

        };
        mainAdsThread.start();
    }

    private void afiseazaReclamaPentruPerioada(int milisecunde) {
        try {
            sleep(milisecunde);
        } catch (InterruptedException ex) {
            Logger.getLogger(PanouReclame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
