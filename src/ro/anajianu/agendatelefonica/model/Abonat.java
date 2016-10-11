package ro.anajianu.agendatelefonica.model;

import java.io.Serializable;
import java.util.Objects;

public class Abonat implements Serializable{
    
    private static final long serialVersionUID = 4404946957604206097L;
    
    private String numar;
    private String nume;
    private String prenume;
    private String CNP;
    private NrTelefon nrTelefon;
    
    public Abonat (String numar, String nume, String prenume,NrTelefon nrTelefon, String CNP) {
        this.numar=numar;
        this.nume=nume;
        this.prenume=prenume;
        this.nrTelefon=nrTelefon;
        this.CNP=CNP;
    }

    public String getNumar() {
        return numar;
    }

    public void setNumar(String numar) {
        this.numar = numar;
    }
    
    public String getNume() {
        return nume;
    }
    
    public void setNume(String nume) {
        this.nume=nume;
    }
    
    public String getPrenume() {
        return prenume;
    }
    
    public void setPrenume(String prenume) {
        this.prenume=prenume;
    }
    
    public String getCNP() {
        return CNP;
    }
    
    public void setCNP (String CNP) {
        this.CNP=CNP;
    }
    
    public NrTelefon getNumarTelefon() {
        return nrTelefon;
    }
    
    public void setNumarTelefon(NrTelefon nrTelefon) {
        this.nrTelefon = nrTelefon;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj==null) {
            return false;
        }
        if (obj instanceof Abonat) {
            Abonat altAbonat=(Abonat) obj;
            if (!altAbonat.numar.equals(numar)) {
                return false;
            }
            if (!altAbonat.nume.equals(nume)) {
                return false;
            }
            if (!altAbonat.prenume.equals(prenume)) {
                return false;
            }
            if (!altAbonat.nrTelefon.equals(nrTelefon)) {
                return false;
            }
            if (!altAbonat.CNP.equals(CNP)) {
                return false;
            }
        }
        return true;

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.numar);
        hash = 47 * hash + Objects.hashCode(this.nume);
        hash = 47 * hash + Objects.hashCode(this.prenume);
        hash = 47 * hash + Objects.hashCode(this.CNP);
        hash = 47 * hash + Objects.hashCode(this.nrTelefon);
        return hash;
    }

    
    
    
    @Override
    public String toString() {
        return "Abonat{nume="+ nume+", prenume="+prenume+", nrTelefon="+nrTelefon+", CNP="+CNP+"}";
    }
          
}
