/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.anajianu.agendatelefonica.model;

/**
 *
 * @author ana
 */
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
        return "NrTelefon="+nrTelefon;
    }
   
}
