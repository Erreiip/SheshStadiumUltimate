package com.sheeesh.game.gameplays.inter;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Displayable extends Remote {
    
    Position    getPosition   () throws RemoteException;
    Orientation getOrientation() throws RemoteException;
    Direction   getDirection  () throws RemoteException;
    Scale       getScale      () throws RemoteException;
    SpriteRef   getSpriteRef  () throws RemoteException;
    Alpha       getAlpha      () throws RemoteException;
}