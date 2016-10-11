package ro.anajianu.agendatelefonica.model;

import java.io.Serializable;


public abstract class NrTelefon implements Serializable{
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
