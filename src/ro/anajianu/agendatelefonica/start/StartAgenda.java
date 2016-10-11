package ro.anajianu.agendatelefonica.start;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import ro.anajianu.agendatelefonica.controller.CarteDeTelefonController;
import ro.anajianu.agendatelefonica.model.CarteDeTelefon;

/**
 *
 * @author ana
 */
public class StartAgenda {
       
   
    public static void main(String[] args) {
        SplashScreen splashScreen = new SplashScreen();
        splashScreen.setVisible(true);
        splashScreen.start();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(StartAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        splashScreen.dispose();
        
        CarteDeTelefon model=new CarteDeTelefon();
        CarteDeTelefonController controller=new CarteDeTelefonController(model);
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                controller.initializareView();
            }
        });
        
    }
   
}
