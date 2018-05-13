package com.xpertsoft.mini.esante.RMI;

import com.xpertsoft.annuaireminesante.IAnnuair;
import com.xpertsoft.mini.esante.Model.Prescriptionentet;
import com.xpertsoft.mini.esante.Model.Tiers;
import com.xpertsoft.mini.esante.Networking.INetwork;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NetworkingRMI implements INetwork{
private ImplimentationService serviceImp;
private Service stub;
public NetworkingRMI(){
 
}

    @Override
    public void Recive() {
           try {
        LocateRegistry.createRegistry(1099);
        serviceImp=new ImplimentationService();
        Naming.rebind("rmi://localhost:1099/Servic", serviceImp);
        System.out.println(serviceImp.toString());
    } catch (Exception ex) {
        Logger.getLogger(NetworkingRMI.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public void Send(Tiers p) {
        
    
        
    try {
        stub = (Service)Naming.lookup("rmi://localhost:1099/Service");
        stub.SetPrescription(p);
    } catch (NotBoundException ex) {
        Logger.getLogger(NetworkingRMI.class.getName()).log(Level.SEVERE, null, ex);
    } catch (MalformedURLException ex) {
        Logger.getLogger(NetworkingRMI.class.getName()).log(Level.SEVERE, null, ex);
    } catch (RemoteException ex) {
        Logger.getLogger(NetworkingRMI.class.getName()).log(Level.SEVERE, null, ex);
    }
        
              
    }

    @Override
    public String Connect(String name, String pass) {
     String result;
        try {
        IAnnuair stub=(IAnnuair)Naming.lookup("rmi:/192.168.8.102:1099/Annuair");
        result=stub.Login(pass, pass);
        return result;
                } catch (NotBoundException ex) {
        Logger.getLogger(NetworkingRMI.class.getName()).log(Level.SEVERE, null, ex);
    } catch (Exception ex) {
        Logger.getLogger(NetworkingRMI.class.getName()).log(Level.SEVERE, null, ex);
    }
     return "";
    } 

    @Override
    public void Send(Prescriptionentet p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
   

}
