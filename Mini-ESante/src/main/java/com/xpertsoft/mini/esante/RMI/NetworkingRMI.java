package com.xpertsoft.mini.esante.RMI;

import com.xpertsoft.annuaireminesante.IAnnuair;
import com.xpertsoft.mini.esante.Model.PrescriptionDetail;
import com.xpertsoft.mini.esante.Model.Prescriptionentet;
import com.xpertsoft.mini.esante.Model.Tiers;
import com.xpertsoft.mini.esante.gui.menu;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NetworkingRMI {

    private ImplimentationService serviceImp;
    private IService stubServiceDestant;
    private IAnnuair stubAnnuair;
    private menu menu;
    public NetworkingRMI(menu _menu) {
        menu=_menu;
    }

    public String IPAnnuaire;
    public String IPServiceDestant;
public void EndRecive(){
   
        try {
            Naming.unbind("rmi://localhost:1099/Service");
        } catch (RemoteException ex) {
            Logger.getLogger(NetworkingRMI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(NetworkingRMI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(NetworkingRMI.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    public void Recive() {
        try {
            LocateRegistry.createRegistry(1099);
            if (serviceImp == null) {
                serviceImp = new ImplimentationService(menu);
            }
            Naming.rebind("rmi://localhost:1099/Service", serviceImp);
            System.out.println(serviceImp.toString());
        } catch (RemoteException ex) {
            Logger.getLogger(NetworkingRMI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(NetworkingRMI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   public String GetIPUser(String Psudo) {
        
        try {
            GetAnnuere();
            return stubAnnuair.GetIPUser(Psudo);
           
           } catch (Exception ex) {
            Logger.getLogger(NetworkingRMI.class.getName()).log(Level.SEVERE, null, ex);
        }
       return null;
    }
    public boolean Connect(String name, String pass) {
        boolean result = false;
        try {
            GetAnnuere();
            result = stubAnnuair.Login(name, pass);
            return result;
           } catch (RemoteException ex) {
            Logger.getLogger(NetworkingRMI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
   public boolean Deconnect(String name, String pass) {
        
        try {
            GetAnnuere();
            return stubAnnuair.Desconect(name, pass);
           } catch (RemoteException ex) {
            Logger.getLogger(NetworkingRMI.class.getName()).log(Level.SEVERE, null, ex);
        }
      return false;
    }
    public void GetAnnuere() {
        try {
            stubAnnuair = (IAnnuair) Naming.lookup("rmi://" + IPAnnuaire + ":1090/Annuair");
        } catch (Exception ex) {
            Logger.getLogger(NetworkingRMI.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    public void GetServiceDestant() {
        try {
            
            stubServiceDestant = (IService) Naming.lookup("rmi://" + IPServiceDestant + ":1099/Service");
        } catch (Exception ex) {
            Logger.getLogger(NetworkingRMI.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

     public void SendPrescription(Prescriptionentet p,List<PrescriptionDetail> detail) {
        try {
            GetServiceDestant();
            stubServiceDestant.SetPrescription(p,detail);
        } catch (Exception ex) {
            Logger.getLogger(NetworkingRMI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
        public void SendSollicitation(String Message) {
        try {
            GetServiceDestant();
            stubServiceDestant.DemmandeSolisitation(Message);
        } catch (Exception ex) {
            Logger.getLogger(NetworkingRMI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
