package com.xpertsoft.mini.esante.Networking;

import com.xpertsoft.mini.esante.Model.Prescriptionentet;
import com.xpertsoft.mini.esante.Model.Tiers;

public interface INetwork {
    
	public void Recive();
        public void SendTiers(Tiers T);
        public void SendPrescription(Prescriptionentet p);
        public String Connect(String name,String pass);
}
