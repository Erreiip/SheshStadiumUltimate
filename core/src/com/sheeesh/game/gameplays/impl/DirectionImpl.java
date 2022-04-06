package com.sheeesh.game.gameplays.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.sheeesh.game.gameplays.inter.Direction;

public class DirectionImpl extends UnicastRemoteObject implements Direction {

    private boolean lookingLeft;

    public DirectionImpl(boolean lookingLeft) throws RemoteException {

        this.lookingLeft = lookingLeft;
    }

    public boolean isLookingLeft() {

        return this.lookingLeft;
    }
}   