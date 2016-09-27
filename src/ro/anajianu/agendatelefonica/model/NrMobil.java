package ro.anajianu.agendatelefonica.model;

public class NrMobil extends NrTelefon {
    
    
    public NrMobil(String nrTelefon) {
        super(nrTelefon);
        try {
            if (!nrTelefon.startsWith("07")) throw new RuntimeException();
        }
        catch(RuntimeException e) {
            System.out.println("Numarul de telefon nu este mobil!");
        }
}

    @Override
    public String toString() {
        return "NrMobil="+ getNrTelefon(); 
    }
    
}
