package com.sheeesh.game.gameplays.inter;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Alpha extends Remote {
 
    float getAlpha() throws RemoteException;
    
    void setAlpha(float alpha) throws RemoteException;
}