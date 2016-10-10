package ro.anajianu.agendatelefonica.model;

public class NrMobil extends NrTelefon {
    
    
    public NrMobil(String nrTelefon) {
        super(nrTelefon);
        
}

    @Override
    public String toString() {
        return getNrTelefon(); 
    }
    
}
