package ro.anajianu.agendatelefonica.view;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author ana
 */
public class FereastraCautare {
    private final JFrame cadruCautare;
    private final JPanel panouCautare;
    private final JTextField campCautare;
    
   
    
    public FereastraCautare() {
        
        
        cadruCautare=new JFrame("Cauta abonat");
        panouCautare=new JPanel();
        campCautare=new JTextField("Cautare...");
        campCautare.setColumns(8);
        cadruCautare.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cadruCautare.setSize(new Dimension(170, 70));
        panouCautare.add(campCautare);
        cadruCautare.getContentPane().add(panouCautare);

          
    }
    
    public void initializare() {
        cadruCautare.setVisible(true);
    }
    
    public JTextField getCampCautare() {
        return campCautare;
    }
    
    
    
}
