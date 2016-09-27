package ro.anajianu.agendatelefonica.model;

import java.util.LinkedList;
import java.util.List;


public class CarteDeTelefon {
    
    private List<Abonat> abonati=new LinkedList<>();
    
    public void adaugareAbonat(Abonat a) {
        abonati.add(a);
    }
    
    public void stergereAbonat(Abonat a) {
        abonati.remove(a);
    }
    
    public void modificareAbonat(Abonat abonatVechi, Abonat abonatNou) {
        if (abonati.contains(abonatVechi)) {
            abonati.remove(abonatVechi);
            abonati.add(abonatNou);
        }
                
    }
    
    public boolean contineAbonat(Abonat a) {
        return abonati.contains(a);
    }

    @Override
    public String toString() {
        return abonati.toString();
    }
    
    
    
    
}
