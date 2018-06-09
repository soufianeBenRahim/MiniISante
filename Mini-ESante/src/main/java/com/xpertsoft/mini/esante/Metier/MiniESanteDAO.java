package com.xpertsoft.mini.esante.Metier;


import com.xpertsoft.mini.esante.Model.PrescriptionDetail;
import com.xpertsoft.mini.esante.Model.Prescriptionentet;
import com.xpertsoft.mini.esante.Model.Tiers;
import java.sql.Date;
import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Set;

public class MiniESanteDAO implements ImetierTiers {

    HibernateUtil Util;

    public MiniESanteDAO() {
        Util = new HibernateUtil();
    }
//Tiers
    @Override
    public String SavePatient(Tiers T) {
        Session session = Util.getSessionFactory().openSession();
        Transaction tx = null;
        String IDPatient = null;
        try {
            tx = session.beginTransaction();
            IDPatient = (String) session.save(T);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return IDPatient;
    }
   @Override
    public void UpdatePatient(Tiers T) {
          Session session = Util.getSessionFactory().openSession();
        Transaction tx = null;
        String IDPatient = null;
        try {
            tx = session.beginTransaction();
             Tiers Tr = (Tiers)session.get(Tiers.class, T.getNss()); 
         Tr.setDatenaissance(T.getDatenaissance());
         Tr.setNom(T.getNom());
         Tr.setPrenom(T.getPrenom());
         
         session.merge(Tr);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    @Override
    public Tiers GetTiersByID(String ID) {
        
      Session session = Util.getSessionFactory().openSession();
      Transaction tx = null;
      Tiers T ;
      try {
         tx = session.beginTransaction();
          T=(Tiers)session.get(Tiers.class, ID); 
          tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
         T=null;
      } finally {
         session.close(); 
      }
      return T;
   } 

    @Override
    public void DeletTiersByID(String ID) {
            Session session = Util.getSessionFactory().openSession();
      Transaction tx = null;
      Tiers T ;
      try {
         tx = session.beginTransaction();
          T=(Tiers)session.get(Tiers.class, ID); 
         session.delete(T); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 

      } finally {
         session.close(); 
      }

    }
    @Override
    public List<Tiers> getMayTiers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int SaveOrUpdatePrescriptionEntet(Prescriptionentet p) {
          Session session = Util.getSessionFactory().openSession();
        Transaction tx = null;
        int IDPatient = 0;
        try {
            tx = session.beginTransaction();
            IDPatient = (int) session.save(p);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return IDPatient;
    }

    @Override
    public int SaveOrUpdatePrescriptionDetail(PrescriptionDetail d) {
             Session session = Util.getSessionFactory().openSession();
        Transaction tx = null;
        int ID =0;
        try {
            tx = session.beginTransaction();
           ID=(int)  session.save(d);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            ID=0;
        } finally {
            session.close();
        }
        return ID;
    }

    @Override
    public List<Prescriptionentet> FindPrescriptions(Date dBegin, Date dEnd, Tiers Patient, String TypePrescription, Tiers Auteur) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Prescriptionentet> getPrescriptionByTiers(Tiers Tiers) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PrescriptionDetail> getDetailPrescription(int IDPrescription) {
       Session session = Util.getSessionFactory().openSession();
      Transaction tx = null;
      List<PrescriptionDetail> Detail =new ArrayList<PrescriptionDetail>();
      try {
         tx = session.beginTransaction();
         Detail = session.createQuery("FROM PrescriptionDetail d where d.prespection.codePrescription= "+IDPrescription).list(); 
  
         tx.commit();
         return Detail;
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
      return null;
    }

    @Override
    public List<Tiers> getALLTiers() {
        
      //Get the session from the session factory.
      Session session = Util.getSessionFactory().openSession();
      Transaction tx = null;
      List<Tiers> TiersResult=new ArrayList<Tiers>();
      try{
         tx = session.beginTransaction();
         //Make an HQL query to get the results from books table . You can also use SQL here.
       TiersResult=  session.createQuery("FROM Tiers").list();
         //Iterate over the result and print it.
       
         tx.commit();

      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace();
         
      }finally {
         session.close();
         
      }
      return TiersResult;
   }  

    @Override
    public Prescriptionentet GetPrescriptionentetByID(int ID) {
                 Session session = Util.getSessionFactory().openSession();
      Transaction tx = null;
      Prescriptionentet p ;
      try {
         tx = session.beginTransaction();
          p=(Prescriptionentet)session.get(Prescriptionentet.class, ID); 
          tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
         p=null;
      } finally {
         session.close(); 
      }
      return p;
    }

    @Override
    public PrescriptionDetail GetPrescriptionDetailByID(int ID) {
            Session session = Util.getSessionFactory().openSession();
      Transaction tx = null;
      PrescriptionDetail D ;
      try {
         tx = session.beginTransaction();
          D=(PrescriptionDetail)session.get(PrescriptionDetail.class, ID); 
          tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
         D=null;
      } finally {
         session.close(); 
      }
      return D;
    }

    public List<Prescriptionentet> getAllPrescription() {
           //Get the session from the session factory.
      Session session = Util.getSessionFactory().openSession();
      Transaction tx = null;
      List<Prescriptionentet> PrescriptionResult=new ArrayList<Prescriptionentet>();
      try{
         tx = session.beginTransaction();
         //Make an HQL query to get the results from books table . You can also use SQL here.
       PrescriptionResult=  session.createQuery("FROM Prescriptionentet").list();
         //Iterate over the result and print it.
       
         tx.commit();

      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace();
         
      }finally {
         session.close();
         
      }
      return PrescriptionResult;
    }

    @Override
    public PrescriptionDetail setDescriptionToPrescriptionDetail(int Id, String Description) {
      Session session = Util.getSessionFactory().openSession();
      Transaction tx = null;
      PrescriptionDetail D ;
      try {
         tx = session.beginTransaction();
          D=(PrescriptionDetail)session.get(PrescriptionDetail.class, Id); 
          D.setDescription(Description);
          tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
         D=null;
      } finally {
         session.close(); 
      }
      return D;
    }

    @Override
    public void DeletDetailPrescriptionByID(int Id) {
         
            Session session = Util.getSessionFactory().openSession();
      Transaction tx = null;
      PrescriptionDetail d ;
      try {
         tx = session.beginTransaction();
          d=(PrescriptionDetail)session.get(PrescriptionDetail.class, Id); 
         session.delete(d); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 

      } finally {
         session.close(); 
      }

        }

    @Override
    public void DeletPrescriptionByID(int Id) {
                Session session = Util.getSessionFactory().openSession();
      Transaction tx = null;
      Prescriptionentet p ;
      try {
         tx = session.beginTransaction();
          p=(Prescriptionentet)session.get(Prescriptionentet.class, Id); 
         session.delete(p); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 

      } finally {
         session.close(); 
      }
    }

    @Override
    public void DeletDetailPrescriptionByIDPrescription(int Id) {
                      Session session = Util.getSessionFactory().openSession();
      Transaction tx = null;
      Prescriptionentet p ;
      try {
         tx = session.beginTransaction();
          p=(Prescriptionentet)session.get(Prescriptionentet.class, Id); 
         p.getDetail().clear();
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 

      } finally {
         session.close(); 
      }
    }

 

}
