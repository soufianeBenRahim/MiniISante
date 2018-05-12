package com.xpertsoft.mini.esante.gui;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import com.xpertsoft.mini.esante.Model.Tiers;
import java.awt.Component;
import javax.swing.*;
/**
 *
 * @author soufiane
 */
class MyListeCellRenderer extends JPanel implements ListCellRenderer {

    JLabel[] lbl;
    int Lenght;
   

    public MyListeCellRenderer() {
        Lenght = 3;
        
        lbl = new JLabel[3];
       setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        for (int x = 0; x < Lenght; x++) {
            
            lbl[x] = new JLabel();
 
            lbl[x].setOpaque(false);
        if (x==0){lbl[x].setVisible(false);}
            add(lbl[x]);
        }
    }

    public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {
        if (value!=null){
            String NSS=((Tiers) value).getNss();
            lbl[0].setText(NSS );
            String Nom=((Tiers) value).getNom();
            lbl[2].setText(Nom);
            String Prenom=((Tiers) value).getPrenom();
            lbl[2].setText(" || "+Prenom);
        }
        return this;
    }
}
