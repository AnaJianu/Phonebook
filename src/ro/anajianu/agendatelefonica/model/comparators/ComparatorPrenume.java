/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.anajianu.agendatelefonica.model.comparators;

import java.util.Comparator;
import ro.anajianu.agendatelefonica.model.Abonat;

/**
 *
 * @author ana
 */
public class ComparatorPrenume implements Comparator<Abonat> {

    @Override
    public int compare(Abonat o1, Abonat o2) {
        return o1.getPrenume().compareTo(o2.getPrenume());
    }

}
