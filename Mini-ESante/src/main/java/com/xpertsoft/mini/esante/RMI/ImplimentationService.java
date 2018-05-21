/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpertsoft.mini.esante.RMI;

import com.xpertsoft.mini.esante.Model.PrescriptionDetail;
import com.xpertsoft.mini.esante.Model.Prescriptionentet;
import com.xpertsoft.mini.esante.Model.Tiers;
import com.xpertsoft.mini.esante.gui.FichePrescription;
import com.xpertsoft.mini.esante.gui.menu;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.List;


/**
 *
 * @author soufiane
 */
public class ImplimentationService extends UnicastRemoteObject implements IService{
menu menu;
    public ImplimentationService(menu _menu) throws RemoteException{
    super();
    menu=_menu;
}
   @Override
    public String SetPrescription(Prescriptionentet p,List<PrescriptionDetail> detail) throws RemoteException {
        FichePrescription pf=new FichePrescription(menu, true, "Recever", p,detail);
        pf.setVisible(true);
        return "OK"; //To change body of generated methods, choose Tools | Templates.
    }

 
    @Override
    public boolean DemmandeSolisitation() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
