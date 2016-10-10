package ro.anajianu.agendatelefonica.model;


public class NrFix extends NrTelefon {
    
    public NrFix(String nrTelefon) {
        super(nrTelefon);
       
}

    @Override
    public String toString() {
        return getNrTelefon();
    }
    
    
  
}
