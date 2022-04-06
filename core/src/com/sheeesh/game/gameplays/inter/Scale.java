package com.sheeesh.game.gameplays.inter;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Scale extends Remote {

    float getScaleX() throws RemoteException;
    float getScaleY() throws RemoteException;
}