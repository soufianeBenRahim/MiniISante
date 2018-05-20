/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpertsoft.mini.esante.gui;

import com.xpertsoft.mini.esante.Metier.MetierImplimentationTiers;
import com.xpertsoft.mini.esante.Model.PrescriptionDetail;
import com.xpertsoft.mini.esante.Model.Prescriptionentet;
import com.xpertsoft.mini.esante.Model.Tiers;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author ZED
 */
public class FichePrescription extends javax.swing.JDialog {

    /**
     * Creates new form FicheEntreeStock
     */
    String ModAppel;
    Prescriptionentet prescription;
    public FichePrescription(java.awt.Frame parent, boolean modal,String _ModAppel,Prescriptionentet _p) {
        super(parent, modal);
        initComponents();
        ModAppel=_ModAppel;
        prescription=_p;
             MetierImplimentationTiers m=new MetierImplimentationTiers();
                UTIL.RemplirComboBoxXD(jComboBoxAuteur, m.getALLTiers(), false, false);
                UTIL.RemplirComboBoxXD(jComboBoxPatient, m.getALLTiers(), false, false);
        switch(ModAppel){                                                                              
            case "Modifier":
                RemplirChamps(prescription);
                if(!prescription.equals(null)){
                    jTableDetalPrescription.setModel(
                            new AbstractTableModelPrescriptionDetail(
                                    m.getDetailPrescription(prescription.getCodePrescription())));
                }
                Setenabled(true);
                break;
                
            case "Ajouter":
           
                break;
            case "Recever":
                RemplirChamps(prescription);
           //    AbstractTableModelPrescriptionDetail model=(AbstractTableModelPrescriptionDetail) jTableDetalPrescription.getModel();
                 //while(prescription.getDetail().iterator().hasNext()){
                //model.addDetail(prescription.getDetail().iterator().next());
               // };
                jButtonValider.setEnabled(false);
                break;
        }
    }
    public void RemplirChamps(Prescriptionentet p){
                jTextFieldIdID.setText(String.valueOf(prescription.getCodePrescription()));
                jXDatePickerDateNaissanc.setDate(prescription.getDatePrescription());
                jTextAreaObservation.setText(prescription.getObservation());
                jTextFieldOrganisation.setText(prescription.getOrganisation());
             
                jComboBoxAuteur.setSelectedItem(prescription.getAuteur());
                jComboBoxPatient.setSelectedItem(prescription.getPatient());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelEntet = new javax.swing.JLabel();
        jPanelEntete = new javax.swing.JPanel();
        jLabelID = new javax.swing.JLabel();
        jTextFieldIdID = new javax.swing.JTextField();
        jLabelDate = new javax.swing.JLabel();
        jLabelMagazin = new javax.swing.JLabel();
        jComboBoxAuteur = new javax.swing.JComboBox<String>();
        jLabelFournisseur = new javax.swing.JLabel();
        jComboBoxPatient = new javax.swing.JComboBox<>();
        jLabelObservation = new javax.swing.JLabel();
        jScrollPaneObservation = new javax.swing.JScrollPane();
        jTextAreaObservation = new javax.swing.JTextArea();
        jTextFieldNomChafeur = new javax.swing.JLabel();
        jTextFieldOrganisation = new javax.swing.JTextField();
        jXDatePickerDateNaissanc = new org.jdesktop.swingx.JXDatePicker();
        jScrollPaneDetalEntree = new javax.swing.JScrollPane();
        jTableDetalPrescription = new javax.swing.JTable();
        jButtonValider = new javax.swing.JButton();
        jButtonAjouterLigne = new javax.swing.JButton();
        jButtonSuprimerLigne = new javax.swing.JButton();
        jButtonSend = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelEntet.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelEntet.setText("Prescription");

        jPanelEntete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelID.setText("ID");

        jTextFieldIdID.setEditable(false);

        jLabelDate.setText("Date Prescription");

        jLabelMagazin.setText("Auteur");

        jLabelFournisseur.setText("Patient");

        jLabelObservation.setText("Observation");

        jTextAreaObservation.setColumns(20);
        jTextAreaObservation.setRows(5);
        jScrollPaneObservation.setViewportView(jTextAreaObservation);

        jTextFieldNomChafeur.setText("Organisation");

        javax.swing.GroupLayout jPanelEnteteLayout = new javax.swing.GroupLayout(jPanelEntete);
        jPanelEntete.setLayout(jPanelEnteteLayout);
        jPanelEnteteLayout.setHorizontalGroup(
            jPanelEnteteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEnteteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEnteteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelMagazin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                    .addComponent(jLabelID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelFournisseur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelEnteteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldIdID, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                    .addGroup(jPanelEnteteLayout.createSequentialGroup()
                        .addGroup(jPanelEnteteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboBoxPatient, javax.swing.GroupLayout.Alignment.LEADING, 0, 210, Short.MAX_VALUE)
                            .addComponent(jComboBoxAuteur, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jXDatePickerDateNaissanc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelEnteteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPaneObservation, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelObservation)
                    .addGroup(jPanelEnteteLayout.createSequentialGroup()
                        .addComponent(jTextFieldNomChafeur)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldOrganisation)))
                .addContainerGap())
        );
        jPanelEnteteLayout.setVerticalGroup(
            jPanelEnteteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEnteteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEnteteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEnteteLayout.createSequentialGroup()
                        .addGroup(jPanelEnteteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelEnteteLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabelID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanelEnteteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldIdID)
                                .addComponent(jLabelObservation)))
                        .addGap(8, 8, 8)
                        .addGroup(jPanelEnteteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jXDatePickerDateNaissanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelEnteteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelEnteteLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabelMagazin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jComboBoxAuteur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelEnteteLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPaneObservation, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanelEnteteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEnteteLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabelFournisseur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelEnteteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldNomChafeur)
                        .addComponent(jTextFieldOrganisation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTableDetalPrescription.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPaneDetalEntree.setViewportView(jTableDetalPrescription);

        jButtonValider.setText("Valider");
        jButtonValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValiderActionPerformed(evt);
            }
        });

        jButtonAjouterLigne.setText("Ajouter");
        jButtonAjouterLigne.setEnabled(false);
        jButtonAjouterLigne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAjouterLigneActionPerformed(evt);
            }
        });

        jButtonSuprimerLigne.setText("Suprimer");
        jButtonSuprimerLigne.setEnabled(false);
        jButtonSuprimerLigne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuprimerLigneActionPerformed(evt);
            }
        });

        jButtonSend.setText("Fermer");
        jButtonSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(jLabelEntet)
                        .addGap(375, 448, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButtonSend, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPaneDetalEntree, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelEntete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButtonSuprimerLigne, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonAjouterLigne, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonValider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelEntet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelEntete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPaneDetalEntree, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonAjouterLigne)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonSuprimerLigne))))
                    .addComponent(jButtonValider))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSend)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValiderActionPerformed



switch(ModAppel){
    case "Modifier":
        
        break;
    case "Ajouter":
        
          
           prescription.setDatePrescription(jXDatePickerDateNaissanc.getDate());
           prescription.setObservation(jTextAreaObservation.getText());
           prescription.setOrganisation(jTextFieldOrganisation.getText());
           prescription.setAuteur((Tiers)jComboBoxAuteur.getSelectedItem());
           prescription.setPatient((Tiers)jComboBoxAuteur.getSelectedItem());
           MetierImplimentationTiers m=new MetierImplimentationTiers();
           this.jTextFieldIdID.setText(String.valueOf(m.SaveOrUpdatePrescriptionEntet(prescription)));
           setEnabled(true);
//           jTableDetalPrescription.setModel(new AbstractTableModelPrescriptionDetail((List<PrescriptionDetail>) prescription.getDetail()));
        
        break;
}
Setenabled(true);
//this.setVisible(false);
// TODO add your handling code here:
    }//GEN-LAST:event_jButtonValiderActionPerformed
    private void Setenabled(boolean enabled){
        jButtonAjouterLigne.setEnabled(enabled); 
        
        jButtonSuprimerLigne.setEnabled(enabled);
    }
    private void jButtonAjouterLigneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjouterLigneActionPerformed
FicheDetailPrescription FDP=new FicheDetailPrescription(null, true, "Ajouter",0,Integer.parseInt(jTextFieldIdID.getText()));
FDP.setVisible(true);
displayDetail();
    }//GEN-LAST:event_jButtonAjouterLigneActionPerformed

    private void jButtonSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSendActionPerformed
this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSendActionPerformed

    private void jButtonSuprimerLigneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuprimerLigneActionPerformed
AbstractTableModelPrescriptionDetail model= (AbstractTableModelPrescriptionDetail)this.jTableDetalPrescription.getModel(); 
model.removeDetail(this.jTableDetalPrescription.getSelectedRow());
    }//GEN-LAST:event_jButtonSuprimerLigneActionPerformed

    private void displayDetail() {
        MetierImplimentationTiers impTiers=new MetierImplimentationTiers();
        this.jTableDetalPrescription.setModel(new AbstractTableModelPrescriptionDetail(impTiers.getDetailPrescription(Integer.parseInt(jTextFieldIdID.getText()))));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAjouterLigne;
    private javax.swing.JButton jButtonSend;
    private javax.swing.JButton jButtonSuprimerLigne;
    private javax.swing.JButton jButtonValider;
    private javax.swing.JComboBox<String> jComboBoxAuteur;
    private javax.swing.JComboBox<String> jComboBoxPatient;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelEntet;
    private javax.swing.JLabel jLabelFournisseur;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelMagazin;
    private javax.swing.JLabel jLabelObservation;
    private javax.swing.JPanel jPanelEntete;
    private javax.swing.JScrollPane jScrollPaneDetalEntree;
    private javax.swing.JScrollPane jScrollPaneObservation;
    private javax.swing.JTable jTableDetalPrescription;
    private javax.swing.JTextArea jTextAreaObservation;
    private javax.swing.JTextField jTextFieldIdID;
    private javax.swing.JLabel jTextFieldNomChafeur;
    private javax.swing.JTextField jTextFieldOrganisation;
    private org.jdesktop.swingx.JXDatePicker jXDatePickerDateNaissanc;
    // End of variables declaration//GEN-END:variables
}