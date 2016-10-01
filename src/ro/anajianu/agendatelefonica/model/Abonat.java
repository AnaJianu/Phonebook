package ro.anajianu.agendatelefonica.model;

public class Abonat {
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
    public String toString() {
        return "Abonat{nume="+ nume+", prenume="+prenume+", nrTelefon="+nrTelefon+", CNP="+CNP+"}";
    }
          
}
