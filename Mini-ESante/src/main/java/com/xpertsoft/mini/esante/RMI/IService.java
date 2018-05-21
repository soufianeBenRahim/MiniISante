/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpertsoft.mini.esante.RMI;

import com.xpertsoft.mini.esante.Model.PrescriptionDetail;
import com.xpertsoft.mini.esante.Model.Prescriptionentet;
import com.xpertsoft.mini.esante.Model.Tiers;
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
