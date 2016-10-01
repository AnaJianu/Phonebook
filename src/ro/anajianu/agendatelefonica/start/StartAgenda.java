package ro.anajianu.agendatelefonica.start;

import ro.anajianu.agendatelefonica.controller.CarteDeTelefonController;
import ro.anajianu.agendatelefonica.model.CarteDeTelefon;

/**
 *
 * @author ana
 */
public class StartAgenda {
       
   
    public static void main(String[] args) {
        CarteDeTelefon model=new CarteDeTelefon();
        CarteDeTelefonController controller=new CarteDeTelefonController(model);
        
    }
   
}
