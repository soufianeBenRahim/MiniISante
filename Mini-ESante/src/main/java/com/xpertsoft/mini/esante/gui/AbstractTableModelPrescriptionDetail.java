/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpertsoft.mini.esante.gui;

import com.xpertsoft.mini.esante.Model.PrescriptionDetail;
import com.xpertsoft.mini.esante.Model.Prescriptionentet;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author soufiane
 */
public class AbstractTableModelPrescriptionDetail extends AbstractTableModel {

    public AbstractTableModelPrescriptionDetail(List<PrescriptionDetail> Detail) {
        this.Detail = Detail;
     
        this.entetes=new String[]{"ID","Description"};
    }
    private List<PrescriptionDetail> Detail;

    private String[] entetes;

    @Override
    public int getRowCount() {
        return Detail.size();//To change body of generated methods, choose Tools | Templates.
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
                return Detail.get(rowIndex).getCodeDetail();
            case 1:
                return Detail.get(rowIndex).getDescription();
            case 2:
                return Detail.get(rowIndex).getPrespection();
            default:
                return null; //Ne devrait jamais arriver
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (aValue != null) {
            switch (columnIndex) {
                case 0:
                    Detail.get(rowIndex).setCodeDetail((int) aValue);
                case 1:
                    Detail.get(rowIndex).setDescription((String) aValue);
                case 2:
                    Detail.get(rowIndex).setPrespection((Prescriptionentet) aValue);
                default:
            }
        }
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        return PrescriptionDetail.class.getDeclaredFields()[columnIndex].getClass();
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true; //Toutes les cellules éditables
    }

    public void addTiers(PrescriptionDetail element) {
        Detail.add(element);
        fireTableRowsInserted(Detail.size() - 1, Detail.size() - 1);
    }

    public void removeDetail(int rowIndex) {
        Detail.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
}
