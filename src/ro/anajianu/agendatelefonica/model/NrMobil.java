/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.anajianu.agendatelefonica.model;

/**
 *
 * @author ana
 */
public class NrMobil extends NrTelefon {
    
    
    public NrMobil(String nrTelefon) {
        super(nrTelefon);
        try {
            if (!nrTelefon.startsWith("07")) throw new RuntimeException();
        }
        catch(RuntimeException e) {
            System.out.println("Numarul de telefon nu este mobil!");
        }
}

    @Override
    public String toString() {
        return "NrMobil="+ getNrTelefon(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
