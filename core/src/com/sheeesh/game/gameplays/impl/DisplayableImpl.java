package com.sheeesh.game.gameplays.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.sheeesh.game.gameplays.inter.Alpha;
import com.sheeesh.game.gameplays.inter.Direction;
import com.sheeesh.game.gameplays.inter.Displayable;
import com.sheeesh.game.gameplays.inter.Orientation;
import com.sheeesh.game.gameplays.inter.Position;
import com.sheeesh.game.gameplays.inter.Scale;
import com.sheeesh.game.gameplays.inter.SpriteRef;

public class DisplayableImpl extends UnicastRemoteObject implements Displayable {
    
    private Position    pos;
    private Orientation orientation;
    private Direction   direction;
    private Scale       scale;
    private SpriteRef   sprite;
    private Alpha       alpha;

    public DisplayableImpl(
        Position    pos,
        Orientation orientation,
        Direction   direction,
        Scale       scale,
        SpriteRef   sprite,
        Alpha       alpha
    ) 
    throws RemoteException {

        this.pos         = pos;
        this.orientation = orientation;
        this.direction   = direction;
        this.scale       = scale;
        this.sprite      = sprite;
        this.alpha       = alpha;
    }

    public Position getPosition() {

        return this.pos;
    }

    public Orientation getOrientation() {

        return this.orientation;
    }

    public Direction getDirection() {

        return this.direction;
    }

    public Scale getScale() {

        return this.scale;
    }

    public SpriteRef getSpriteRef() {

        return this.sprite;
    }

    public Alpha getAlpha() {

        return this.alpha;
    }
}