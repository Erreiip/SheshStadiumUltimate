package com.sheeesh.game.gameplays.inter;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Position extends Remote {
    
    float getX() throws RemoteException;
    float getY() throws RemoteException;

    void setX(float x) throws RemoteException;
    void setY(float x) throws RemoteException;
}