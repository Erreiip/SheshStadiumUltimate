package com.sheeesh.game.gameplays.inter;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Player extends Remote {
    
    void update(double dt) throws RemoteException;

    void jump() throws RemoteException;
    void down() throws RemoteException;
    
    void  left() throws RemoteException;
    void right() throws RemoteException;

    void          use() throws RemoteException;
    void interraction() throws RemoteException;
}