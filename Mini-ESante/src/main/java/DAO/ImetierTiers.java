package DAO;

import Model.PrescriptionDetail;
import Model.Prescriptionentet;
import Model.Tiers;
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
        public void DeletPrescriptionByID(int Id);
        // Prescription detail
        public int SaveOrUpdatePrescriptionDetail(PrescriptionDetail d);
        public PrescriptionDetail GetPrescriptionDetailByID(int ID);
        public List<PrescriptionDetail> getDetailPrescription(int IDPrescription);
        public PrescriptionDetail setDescriptionToPrescriptionDetail(int Id,String Description);
        public void DeletDetailPrescriptionByID(int Id);
        public void DeletDetailPrescriptionByIDPrescription(int Id);
       
}
