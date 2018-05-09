package com.xpertsoft.mini.esante.Metier;

import com.xpertsoft.mini.esante.Model.PrescriptionDetail;
import com.xpertsoft.mini.esante.Model.Prescriptionentet;
import com.xpertsoft.mini.esante.Model.Tiers;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;



public interface ImetierTiers {
        // gestion des Tiers
	public String SavePatient(Tiers p);
        public void UpdatePatient(Tiers p);
        public Tiers GetTiersByID(String ID);
        public void DeletTiersByID(String ID);
        public List<Tiers> getMayTiers();
        public List<Tiers> getALLTiers();
        
        // Prescription entete
	public int SaveOrUpdatePrescriptionEntet(Prescriptionentet p);
	public Prescriptionentet GetPrescriptionentetByID(int ID);
        public List<Prescriptionentet> FindPrescriptions(Date dBegin,Date dEnd,Tiers Patient,String TypePrescription,Tiers Auteur);
	public List<Prescriptionentet> getPrescriptionByTiers(Tiers Tiers);
        public List<Prescriptionentet> getAllPrescription();
        // Prescription detail
        public int SaveOrUpdatePrescriptionDetail(PrescriptionDetail d);
        public PrescriptionDetail GetPrescriptionDetailByID(int ID);
        public List<PrescriptionDetail> getDetailPrescription(int IDPrescription);
       
}
