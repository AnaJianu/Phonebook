/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.anajianu.agendatelefonica.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ana
 */
public class ModelTabel extends AbstractTableModel{
    
    List<Abonat> listaAbonati;
    String[] baraColoane={"Nr.", "Nume", "Prenume", "Telefon", "CNP" };
    
    
    public ModelTabel(List<Abonat> lista){
        listaAbonati=lista;
    } 
    @Override
    public int getRowCount() {
        return listaAbonati.size();
    }

    @Override
    public int getColumnCount() {
        return baraColoane.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Abonat abonat = listaAbonati.get(rowIndex);
        switch (columnIndex) { 
            case 0: 
                return abonat.getNumar();
            case 1:
                return abonat.getNume();
            case 2:
                return abonat.getPrenume();
            case 3:
                return abonat.getNumarTelefon();
            case 4:
                return abonat.getCNP();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return baraColoane[column];
    }

    public void notificareAdaugareAbonat() {
        fireTableDataChanged();
    }

    public void notificareStergereAbonat() {
        fireTableDataChanged();
    }
    
    
    
}
