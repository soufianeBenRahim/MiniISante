/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpertsoft.mini.esante.RMI;

import com.xpertsoft.mini.esante.Model.Prescriptionentet;
import com.xpertsoft.mini.esante.Model.Tiers;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;


/**
 *
 * @author soufiane
 */
public class ImplimentationService extends UnicastRemoteObject implements IService{
public ImplimentationService() throws RemoteException{
    super();
}
   @Override
    public String SetPrescription(Prescriptionentet p) throws RemoteException {
        
        return "OK"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String SetTiers(Tiers p) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean DemmandeSolisitation() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
