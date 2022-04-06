package com.sheeesh.game.gameplays.inter;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SpriteRef extends Remote {

    String getId() throws RemoteException;
    Integer getFrame() throws RemoteException;

    void setId(String id) throws RemoteException;
    void setFrame(Integer frame) throws RemoteException;
}