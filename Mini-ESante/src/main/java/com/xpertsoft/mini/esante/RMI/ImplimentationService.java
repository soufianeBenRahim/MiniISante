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
import java.security.cert.PKIXRevocationChecker;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.text.html.Option;


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
        int result=JOptionPane.showConfirmDialog(menu,"Une Prescription vien d'etre arrivee voulez vous le voir", "Accuse de reception", JOptionPane.YES_NO_OPTION);
        if(JOptionPane.YES_OPTION==result){
        FichePrescription pf=new FichePrescription(menu, false, "Recever", p,detail);
        pf.setVisible(true);
        return "OK"; 
        }else {
            return "No";
        }
    }

 
    @Override
    public void DemmandeSolisitation(String Message) throws RemoteException {
        try {
            String IP = getClientHost();
            int result=JOptionPane.showConfirmDialog(menu, Message,"Solisitation" , JOptionPane.YES_NO_OPTION);
            if(result==JOptionPane.YES_OPTION){
            menu.SetIPDestant(IP);
            }
        } catch (Exception e) {

        }
    }

}
