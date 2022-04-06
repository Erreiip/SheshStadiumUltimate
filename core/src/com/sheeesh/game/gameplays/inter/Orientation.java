package com.sheeesh.game.gameplays.inter;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Orientation extends Remote {
    
    float getValue() throws RemoteException;
}