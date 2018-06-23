/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import DAO.MiniESanteDAO;
import Model.Prescriptionentet;
import Model.Tiers;
import java.sql.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author soufiane
 */
public class AbstractTableModelPrescription extends AbstractTableModel{
      public AbstractTableModelPrescription(List<Prescriptionentet> _Prescriptios) {
        this.Prescriptios = _Prescriptios;

     this.entetes=new String[]{"ID","Patient","Date prescription","Organisation","Auteur","Observation"};
     
    }
    private List<Prescriptionentet> Prescriptios;

    private String[] entetes;

    @Override
    public int getRowCount() {
        return Prescriptios.size();//To change body of generated methods, choose Tools | Templates.
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
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Prescriptios.get(rowIndex).getCodePrescription();
            case 1:
                return Prescriptios.get(rowIndex).getPatient().getNom();
                
            case 2:
                return Prescriptios.get(rowIndex).getDatePrescription();

            case 3:
                return Prescriptios.get(rowIndex).getOrganisation();
                
            case 4:    
                return Prescriptios.get(rowIndex).getAuteur().getNom();
                
            case 5 :
                return Prescriptios.get(rowIndex).getObservation();
            default:
                return null; //Ne devrait jamais arriver
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (aValue != null) {
            switch (columnIndex) {
                case 0:
                    Prescriptios.get(rowIndex).setCodePrescription((int) aValue);
                case 1:
                     Prescriptios.get(rowIndex).setPatient((Tiers) aValue);
                case 2:   
                    Prescriptios.get(rowIndex).setDatePrescription((Date) aValue);
                case 3:
                    Prescriptios.get(rowIndex).setOrganisation((String) aValue);
                case 4:
                   
                    Prescriptios.get(rowIndex).setAuteur(((Tiers) aValue));
                case 5:
                    
                    Prescriptios.get(rowIndex).setOrganisation((String) aValue);
                default:
            }
        }
    }

    @Override
    public Class getColumnClass(int columnIndex) {

            switch (columnIndex) {
                case 0:
                    return String.class;
                case 1:
                     return Tiers.class;
                case 2:   
                   return Date.class;
                case 3:
                   return String.class;
                case 4:
                   
                    return Tiers.class;
                case 5:
                    
                    return String.class;
                default:
            }

        return Prescriptionentet.class.getDeclaredFields()[columnIndex].getClass();
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true; //Toutes les cellules éditables
    }

    public void addPrescription(Prescriptionentet element) {
        Prescriptios.add(element);
        fireTableRowsInserted(Prescriptios.size() - 1, Prescriptios.size() - 1);
    }

    public void removePrescription(int rowIndex) {
        MiniESanteDAO m = new MiniESanteDAO();
        int code=Prescriptios.get(rowIndex).getCodePrescription();
        m.DeletPrescriptionByID(code);
        Prescriptios.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
}
