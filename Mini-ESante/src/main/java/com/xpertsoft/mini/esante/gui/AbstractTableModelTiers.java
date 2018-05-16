/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpertsoft.mini.esante.gui;
import com.xpertsoft.mini.esante.Metier.MetierImplimentationTiers;
import com.xpertsoft.mini.esante.Model.Tiers;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author soufiane
 */
import java.sql.Date;
public class AbstractTableModelTiers extends AbstractTableModel {
    private final List<Tiers> ListeTiers;
 
    private final String[] entetes ;
 
    public AbstractTableModelTiers(List<Tiers> ListeTiers) {
        super();
 
        this.ListeTiers = ListeTiers;

        entetes=new String[]{"N° SS","Nom","Prenom","Adress","Date Naissance"};
    }
 @Override
    public int getRowCount() {
        return ListeTiers.size();
    }
 @Override
    public int getColumnCount() {
        return entetes.length;
    }
 @Override
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
       
    }


 
   @Override
public boolean isCellEditable(int rowIndex, int columnIndex) {
    return true; //Toutes les cellules éditables
}
 
 @Override
public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0:
                return ListeTiers.get(rowIndex).getNss();
            case 1:
                return ListeTiers.get(rowIndex).getNom();
            case 2:
                return ListeTiers.get(rowIndex).getPrenom();
            case 3:
                return ListeTiers.get(rowIndex).getAdress();
            case 4:
                return ListeTiers.get(rowIndex).getDatenaissance();
       
         
            default:
                return null; //Ne devrait jamais arriver
        }
    }

@Override
public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    if(aValue != null){
        
 
        switch(columnIndex){
            case 0:
                ListeTiers.get(rowIndex).setNss((String) aValue);
            case 1:
                 ListeTiers.get(rowIndex).setNom((String) aValue);
            case 2:
                 ListeTiers.get(rowIndex).setPrenom((String) aValue);
            case 3:
                 ListeTiers.get(rowIndex).setAdress((String) aValue);
            case 4:
                 ListeTiers.get(rowIndex).setDatenaissance((Date) aValue);
           
            default:
        }
    }
}

@Override
public Class getColumnClass(int columnIndex){
     return Tiers.class.getDeclaredFields()[columnIndex].getClass();
    
    
}

  
   public void addTiers(Tiers element) {
        ListeTiers.add(element);
 
        fireTableRowsInserted(ListeTiers.size() -1, ListeTiers.size() -1);
    }
 
    public void removeTiers(int rowIndex) {
        
    MetierImplimentationTiers m = new MetierImplimentationTiers();
        m.DeletTiersByID(ListeTiers.get(rowIndex).getNss());
         ListeTiers.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
       
    }

}
