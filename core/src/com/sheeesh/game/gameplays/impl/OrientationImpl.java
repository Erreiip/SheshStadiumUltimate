package com.sheeesh.game.gameplays.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.sheeesh.game.gameplays.inter.Orientation;

public class OrientationImpl extends UnicastRemoteObject implements Orientation {
    
    private float value;

    public OrientationImpl(float value) throws RemoteException {

        this.value = value;
    }

    public float getValue() {

        return this.value;
    }
}