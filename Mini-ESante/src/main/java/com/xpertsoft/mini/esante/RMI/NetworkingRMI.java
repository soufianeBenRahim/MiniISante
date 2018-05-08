package com.xpertsoft.mini.esante.RMI;

import com.xpertsoft.mini.esante.Model.Prescriptionentet;
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

public NetworkingRMI(){
 
}

    @Override
    public void Recive() {
           try {
        LocateRegistry.createRegistry(1099);
        serviceImp=new ImplimentationService();
        Naming.rebind("rmi://localhost:1099/serveur", serviceImp);
        System.out.println(serviceImp.toString());
    } catch (Exception ex) {
        Logger.getLogger(NetworkingRMI.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public void Send(Prescriptionentet p) {
        
    try {
        Service stub=(Service)Naming.lookup("rmi:/localhost:1099/serveur");
        stub.SetPrescription(p);
                } catch (NotBoundException ex) {
        Logger.getLogger(NetworkingRMI.class.getName()).log(Level.SEVERE, null, ex);
    } catch (Exception ex) {
        Logger.getLogger(NetworkingRMI.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

 
   

}
