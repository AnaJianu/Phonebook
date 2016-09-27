package ro.anajianu.agendatelefonica.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ 
    AbonatTest.class,
    CarteDeTelefonTest.class,
    NrFixTest.class,
    NrMobilTest.class
})
public class AgendaTelefonicaTestSuite {
    
}
