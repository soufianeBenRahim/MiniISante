package com.xpertsoft.mini.esante.Networking;

import com.xpertsoft.mini.esante.Model.Prescriptionentet;

public interface INetwork {
    
	public void Recive();
        public void Send(Prescriptionentet p);
}
