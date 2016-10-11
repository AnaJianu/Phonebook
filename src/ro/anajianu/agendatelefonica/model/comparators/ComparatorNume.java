package ro.anajianu.agendatelefonica.model.comparators;

import java.util.Comparator;
import ro.anajianu.agendatelefonica.model.Abonat;

/**
 *
 * @author ana
 */
public class ComparatorNume implements Comparator<Abonat>{

    @Override
    public int compare(Abonat o1, Abonat o2) {
        return o1.getNume().compareTo(o2.getNume());
    }
    
    
}
