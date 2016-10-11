package ro.anajianu.agendatelefonica.model;

import java.util.LinkedList;
import java.util.List;


public class CarteDeTelefon {
    
    private List<Abonat> abonati;
    private ModelTabel modelTabel;

    public CarteDeTelefon() {
        abonati=new LinkedList<>();
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
    
    public void incarcaBazaDeDate(List<Abonat> listaDeIncarcat) {
       abonati = listaDeIncarcat;
       initializareModelTabel();
       
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
