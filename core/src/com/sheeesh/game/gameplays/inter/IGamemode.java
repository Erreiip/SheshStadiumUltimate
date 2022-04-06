package com.sheeesh.game.gameplays.inter;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IGamemode extends IGame {
    
    void update(double dt) throws RemoteException;
}