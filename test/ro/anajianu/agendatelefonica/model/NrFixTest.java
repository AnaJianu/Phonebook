package ro.anajianu.agendatelefonica.model;

import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class NrFixTest {
    
    NrFix nrFix;
    
    @Before
    public void setUp() {
        nrFix = new NrFix("0234123456");
    }
    
    @Test
    public void testToString() {
        String expected = "NrFix=0234123456";
        String result = nrFix.toString();
        assertEquals(expected, result);
    }
    
    
}
