package com.sheeesh.game.gameplays.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.sheeesh.game.gameplays.inter.Scale;

public class ScaleImpl extends UnicastRemoteObject implements Scale {
 
    private float scaleX;
    private float scaleY;

    public ScaleImpl(float scaleX, float scaleY) throws RemoteException {

        this.scaleX = scaleX;
        this.scaleY = scaleY;
    }

    public float getScaleX() {

        return this.scaleX;
    }

    public float getScaleY() {

        return this.scaleY;
    }
}