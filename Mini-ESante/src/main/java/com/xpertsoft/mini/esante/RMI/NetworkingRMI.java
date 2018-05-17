package com.xpertsoft.mini.esante.RMI;

import com.xpertsoft.annuaireminesante.IAnnuair;
import com.xpertsoft.mini.esante.Model.Prescriptionentet;
import com.xpertsoft.mini.esante.Model.Tiers;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NetworkingRMI {
private ImplimentationService serviceImp;
private IService stub;
public NetworkingRMI(){
 
}

 public String IPAnnuaire;
 public String IPServiceDestant;
    public void Recive() {
           try {
        LocateRegistry.createRegistry(1099);
        serviceImp=new ImplimentationService();
        Naming.rebind("rmi://localhost:1099/Service", serviceImp);
        System.out.println(serviceImp.toString());
    } catch (RemoteException ex) {
        Logger.getLogger(NetworkingRMI.class.getName()).log(Level.SEVERE, null, ex);
    } catch (MalformedURLException ex) {
        Logger.getLogger(NetworkingRMI.class.getName()).log(Level.SEVERE, null, ex);
    } 
    }




    public boolean Connect(String name, String pass) {
     boolean result=false;
        try {    
        IAnnuair stub=(IAnnuair)Naming.lookup("rmi://"+IPAnnuaire+":1099/Annuair");
        result=stub.Login(pass, pass);
        this.Recive();
        return result;
                } catch (NotBoundException ex) {
        Logger.getLogger(NetworkingRMI.class.getName()).log(Level.SEVERE, null, ex);
    } catch (MalformedURLException ex) {
        Logger.getLogger(NetworkingRMI.class.getName()).log(Level.SEVERE, null, ex);
    } catch (RemoteException ex) {
        Logger.getLogger(NetworkingRMI.class.getName()).log(Level.SEVERE, null, ex);
    }
     return result;
    } 



    public void SendTiers(Tiers T) {
           
    try {
        stub = (IService)Naming.lookup("rmi://"+IPServiceDestant+":1099/Service");
        stub.SetTiers(T);
    } catch (NotBoundException ex) {
        Logger.getLogger(NetworkingRMI.class.getName()).log(Level.SEVERE, null, ex);
    } catch (MalformedURLException ex) {
        Logger.getLogger(NetworkingRMI.class.getName()).log(Level.SEVERE, null, ex);
    } catch (RemoteException ex) {
        Logger.getLogger(NetworkingRMI.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    public void SendPrescription(Prescriptionentet p) {
  
    try {
        stub = (IService)Naming.lookup("rmi://"+IPServiceDestant+":1099/Service");
        stub.SetPrescription(p);
    } catch (NotBoundException ex) {
        Logger.getLogger(NetworkingRMI.class.getName()).log(Level.SEVERE, null, ex);
    } catch (MalformedURLException ex) {
        Logger.getLogger(NetworkingRMI.class.getName()).log(Level.SEVERE, null, ex);
    } catch (RemoteException ex) {
        Logger.getLogger(NetworkingRMI.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }

 
   

}
