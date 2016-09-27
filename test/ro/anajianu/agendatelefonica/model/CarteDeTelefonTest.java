/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.anajianu.agendatelefonica.model;

import org.junit.Assert;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author ana
 */
public class CarteDeTelefonTest {
    
    CarteDeTelefon agenda = new CarteDeTelefon();
    NrTelefon nrTelefon= new NrMobil("0765789789");
    Abonat abonat = new Abonat("Ion", "Popescu", nrTelefon, "2920298350013");
    
    @Test
    public void testAdaugaAbonat() {
        agenda.adaugareAbonat(abonat);
        assertTrue(agenda.contineAbonat(abonat));
        
    }
    
    @Test 
    public void testStergeAbonat() {
        agenda.adaugareAbonat(abonat);
        assertTrue(agenda.contineAbonat(abonat));
        
        agenda.stergereAbonat(abonat);
        assertFalse(agenda.contineAbonat(abonat));
    }

    @Test
    public void testModificaAbonat() {
        Abonat abonatModificat = new Abonat("Ion", "Popescu", nrTelefon, "1720298350013");
        agenda.adaugareAbonat(abonat);
                
        assertTrue(agenda.contineAbonat(abonat));
        agenda.modificareAbonat(abonat, abonatModificat);
        assertTrue(agenda.contineAbonat(abonatModificat));
        
    }
    
}
