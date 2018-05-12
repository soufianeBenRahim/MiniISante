/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpertsoft.mini.esante.gui;

import com.xpertsoft.mini.esante.Model.Tiers;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import jdk.nashorn.internal.objects.NativeArray;

/**
 *
 * @author soufiane
 */
public class UTIL {
        public static void RemplirComboBoxXD(JComboBox CB, List<Tiers>  ListTiers, Boolean AjouterTout, Boolean AvecNull) {
        CB.removeAllItems();

        if (AjouterTout) {
            Tiers ST = new Tiers();
            ST.setNss("0");
            ST.setNom("Touts");
            ListTiers.add(0, ST);
           
        }
        if (AvecNull) {
            Tiers ST = new Tiers();
            ST.setNss("0");
            ST.setNom("Null");
            ListTiers.add(0, ST);
           
        }

        if (ListTiers != null) {
            for (Tiers var : ListTiers) 
            { 
                CB.addItem(var);
            }
        }
        CB.setRenderer(new MyListeCellRenderer());
    }
}
