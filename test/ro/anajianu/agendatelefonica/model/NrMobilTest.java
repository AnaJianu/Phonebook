package ro.anajianu.agendatelefonica.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


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
