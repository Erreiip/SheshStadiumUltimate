package com.sheeesh.game.gameplays.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.sheeesh.game.gameplays.inter.SpriteRef;

public class SpriteRefImpl extends UnicastRemoteObject implements SpriteRef {
    
    private String id;
    private Integer frame;

    public SpriteRefImpl(String id, Integer frame) throws RemoteException {

        this.id = id;
        this.frame = frame;
    }

    public String getId() {

        return this.id;
    }

    public Integer getFrame() {

        return this.frame;
    }

    public void setId(String id) {

        this.id = id;
    }

    public void setFrame(Integer frame) {

        this.frame = frame;
    }
}