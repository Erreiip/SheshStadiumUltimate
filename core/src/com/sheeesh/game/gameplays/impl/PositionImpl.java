package com.sheeesh.game.gameplays.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.sheeesh.game.gameplays.inter.Position;

public class PositionImpl extends UnicastRemoteObject implements Position {
    
    private float x;
    private float y;

    public PositionImpl(int x, int y) throws RemoteException {

        this.x = x; this.y = y;
    }

    public float getX() {

        return this.x;
    }

    public float getY() {

        return this.y;
    }

    public void setX(float x) {

        this.x = x;
    }

    public void setY(float y) {

        this.y = y;
    }
}