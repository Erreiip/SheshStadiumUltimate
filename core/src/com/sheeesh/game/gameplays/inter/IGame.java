package com.sheeesh.game.gameplays.inter;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IGame extends Remote {
 
    PlayerController join() throws RemoteException;
    List<Displayable> getDisplayables() throws RemoteException;
}