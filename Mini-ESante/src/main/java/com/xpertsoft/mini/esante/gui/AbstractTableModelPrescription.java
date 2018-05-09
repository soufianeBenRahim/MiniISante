/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpertsoft.mini.esante.gui;

import com.xpertsoft.mini.esante.Model.Prescriptionentet;
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
                return Prescriptios.get(rowIndex).getDatePrescription();
            case 2:
                return Prescriptios.get(rowIndex).getObservation();
            case 3:
                return Prescriptios.get(rowIndex).getOrganisation();
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
                    Prescriptios.get(rowIndex).setDatePrescription((Date) aValue);
                case 2:
                    Prescriptios.get(rowIndex).setObservation((String) aValue);
                case 3:
                    Prescriptios.get(rowIndex).setOrganisation((String) aValue);
                default:
            }
        }
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        return Prescriptionentet.class.getDeclaredFields()[columnIndex].getClass();
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true; //Toutes les cellules éditables
    }

    public void addTiers(Prescriptionentet element) {
        Prescriptios.add(element);
        fireTableRowsInserted(Prescriptios.size() - 1, Prescriptios.size() - 1);
    }

    public void removeDetail(int rowIndex) {
        Prescriptios.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
}
