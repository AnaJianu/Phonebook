package ro.anajianu.agendatelefonica.model;

import java.util.LinkedList;
import java.util.List;


public class CarteDeTelefon {
    
    private List<Abonat> abonati=new LinkedList<>();
    private ModelTabel modelTabel;

    public CarteDeTelefon() {
        creareBazaDate();
        initializareModelTabel();
    }
    
    
    
    public void adaugareAbonat(Abonat a) {
        abonati.add(a);
        modelTabel.notificareAdaugareAbonat();
    }
    
    public void stergereAbonat(Abonat a) {
        abonati.remove(a);
        modelTabel.notificareStergereAbonat();
    }
    
    public void modificareAbonat(Abonat abonatVechi, Abonat abonatNou) {
        if (abonati.contains(abonatVechi)) {
            abonati.remove(abonatVechi);
            abonati.add(abonatNou);
            modelTabel.notificareAdaugareAbonat();
        }
                
    }
    
    private void creareBazaDate() {
        NrMobil telefon = new NrMobil("0756798889");
        Abonat a1 = new Abonat("0", "Popescu", "Ion", telefon, "190032850028");
        Abonat a2 = new Abonat("1", "Dumitru", "Andra", telefon, "291090340028");
        Abonat a3 = new Abonat("2", "Visinescu", "Dan", telefon, "182082550028");
        abonati.add(a1);
        abonati.add(a2);
        abonati.add(a3);
    }
    private void initializareModelTabel() {
        modelTabel= new ModelTabel(abonati);
    }
    
    public List<Abonat> getListaAbonati() {
        return abonati;
    }
    
    public boolean contineAbonat(Abonat a) {
        return abonati.contains(a);
    }
    
    public ModelTabel getModelTabel() {
        return modelTabel;
    }

    @Override
    public String toString() {
        return abonati.toString();
    }
    
    
    
    
}
