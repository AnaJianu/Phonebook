package ro.anajianu.agendatelefonica.controller;

import ro.anajianu.agendatelefonica.model.CarteDeTelefon;
import ro.anajianu.agendatelefonica.view.CarteDeTelefonGUI;

/**
 *
 * @author ana
 */
public class CarteDeTelefonController {
   private CarteDeTelefon modelCarte;
   private CarteDeTelefonGUI viewCarte;
   
   public CarteDeTelefonController(CarteDeTelefon model) {
       modelCarte=model;
       viewCarte=new CarteDeTelefonGUI(this);

   }

    public void stergeAbonat() {
        viewCarte.stergeCampuriDetaliiAbonat();
    }

}
