package ro.anajianu.agendatelefonica.model;


public abstract class NrTelefon {
    private String nrTelefon;
    
    public NrTelefon(String nrTelefon) {
        this.nrTelefon=nrTelefon;
    }
    
    public String getNrTelefon() {
        return nrTelefon;
    }
    public void setNrTelefon(String nrTelefon) {
        this.nrTelefon=nrTelefon;
    }      
    
    @Override
    public String toString() {
        return nrTelefon;
    }
   
}
