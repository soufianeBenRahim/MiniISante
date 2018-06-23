/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Networking;

import java.rmi.Remote;
import java.rmi.RemoteException;



/**
 *
 * @author Soufiane
 */
public interface IAnnuair extends Remote{
    public boolean Login(String Psudo,String Pass,String UsIP) throws RemoteException;
    public boolean Desconect(String Psudo,String Pass) throws RemoteException;
    public String GetIPUser(String Psudo) throws RemoteException;
}
