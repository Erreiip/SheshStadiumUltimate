package com.sheeesh.game.gameplays.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.sheeesh.game.gameplays.inter.Alpha;

public class AlphaImpl extends UnicastRemoteObject implements Alpha {
    
    private float alpha;

    public AlphaImpl(float alpha) throws RemoteException {

        this.alpha = alpha;
    }

    public float getAlpha() {

        return this.alpha;
    }

    public void setAlpha(float alpha) {

        this.alpha = alpha;
    }
}