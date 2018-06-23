/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Networking;

import Model.PrescriptionDetail;
import Model.Prescriptionentet;
import Model.Tiers;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author soufiane
 */
public interface IService extends Remote{
    public String SetPrescription(Prescriptionentet p,List<PrescriptionDetail> detail) throws RemoteException;
    public void DemmandeSolisitation(String Message)throws RemoteException;
}
