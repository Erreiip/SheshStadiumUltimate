package com.sheeesh.game.gameplays.inter;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Direction extends Remote {
    
    boolean isLookingLeft() throws RemoteException;
}