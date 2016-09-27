package ro.anajianu.agendatelefonica.model;


public class NrFix extends NrTelefon {
    
    public NrFix(String nrTelefon) {
        super(nrTelefon);
        try {
            if (!nrTelefon.startsWith("02")||!nrTelefon.startsWith("03")) throw new RuntimeException();
        }
        catch(RuntimeException e) {
            System.out.println("Numarul de telefon nu este fix!");
        }
}

    @Override
    public String toString() {
        return "NrFix="+getNrTelefon();
    }
    
    
  
}
