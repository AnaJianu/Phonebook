package ro.anajianu.agendatelefonica.model;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class AbonatTest {
    
    NrTelefon nrTelefon;
    Abonat abonat;
    
    
    @Before
    public void setUp() {
        nrTelefon= new NrMobil("0765789789");
        abonat = new Abonat("1", "Ion", "Popescu", nrTelefon, "2920298350013");
    }
    
    @Test
    public void testToString() {
        String rezultat = "Abonat{nume=Ion, prenume=Popescu, nrTelefon=NrMobil=0765789789, CNP=2920298350013}";
        assertEquals("Metoda toString nu este suprascrisa", rezultat, abonat.toString());
    }
    
    @Test
    public void testNumeAbonat() {
        assertEquals("Numele este diferit", "Ion", abonat.getNume());
    }
    
    @Test
    public void testPrenumeAbonat() {
        assertEquals("Prenumele este diferit", "Popescu", abonat.getPrenume());
    }
    
    @Test
    public void testCNPAbonat() {
        assertEquals("CNP-ul este diferit", "2920298350013", abonat.getCNP());
    }
    
    @Test
    public void testTelefonMobilAbonat() {
        assertEquals("Mobilul este diferit", "NrMobil=0765789789", abonat.getNumarTelefon().toString());
    }

}
