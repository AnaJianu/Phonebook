/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.anajianu.agendatelefonica.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ana
 */
public class NrMobilTest {
    
    NrMobil nrMobil;
    
    @Before
    public void setUp() {
        nrMobil = new NrMobil("0723456789");
    }

    /**
     * Test of toString method, of class NrMobil.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        NrMobil instance = nrMobil;
        String expResult = "NrMobil=0723456789";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
