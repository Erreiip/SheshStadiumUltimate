package com.sheeesh.game.gameplays.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.sheeesh.game.gameplays.inter.Alpha;
import com.sheeesh.game.gameplays.inter.Direction;
import com.sheeesh.game.gameplays.inter.IGame;
import com.sheeesh.game.gameplays.inter.Orientation;
import com.sheeesh.game.gameplays.inter.Player;
import com.sheeesh.game.gameplays.inter.PlayerController;
import com.sheeesh.game.gameplays.inter.Position;
import com.sheeesh.game.gameplays.inter.Scale;
import com.sheeesh.game.gameplays.inter.SpriteRef;

public class PlayerImpl extends UnicastRemoteObject implements Player {
    
    private PlayerController controller;

    private Position    pos;
    private Orientation orientation;
    private Direction   direction;
    private Scale       scale;
    private SpriteRef   sprite;
    private Alpha       alpha;

    private float speed;

    private float accelerationX;
    private float accelerationY;

    private float accelerationXSpeed;
    private float accelerationYSpeed;

    private float maxAccelerationXSpeed;
    private float maxAccelerationYSpeed;

    private boolean inAir;
    
    public PlayerImpl(PlayerController controller, IGame game) throws RemoteException {

        this.controller = controller;
        this.pos = new PositionImpl(50, 0);
        this.orientation = new OrientationImpl(0f);
        this.direction = new DirectionImpl(false);
        this.scale = new ScaleImpl(2.5f, 2.5f);
        this.sprite = new SpriteRefImpl("placeholder", null);
        this.alpha = new AlphaImpl(1f);

        game.getDisplayables().add(new DisplayableImpl(this.pos, this.orientation, this.direction, this.scale, this.sprite, this.alpha));

        this.speed = 25f;
        this.accelerationX = 0f;
        this.accelerationY = 0f;

        this.accelerationXSpeed = 20f;
        this.accelerationYSpeed = 0.2f;

        this.maxAccelerationXSpeed = 1f;
        this.maxAccelerationYSpeed = 5f;
    }

    public void update(double dt) {

        try {

            this.pos.setX((float) (this.pos.getX()+(this.accelerationX*dt)));
            if (this.accelerationX != 0f) {

                this.accelerationX = (float) (this.accelerationX - (this.accelerationX/2f)*dt);
            }

            if (this.accelerationY > 0f && this.inAir) {

                this.pos.setY((float) (this.pos.getY() + (accelerationY*dt)));
                this.accelerationY = (float) (this.accelerationX - (this.accelerationY/2f)*dt);
            } 
            else {

                this.inAir = false;
            }

            if (this.pos.getX() - this.scale.getScaleX()/2f <   0f) {this.pos.setX(0f   + this.scale.getScaleX()/2f);}
            if (this.pos.getX() + this.scale.getScaleX()/2f > 100f) {this.pos.setX(100f - this.scale.getScaleX()/2f);}

            if (this.pos.getY() - this.scale.getScaleY()/2f <   0f) {this.pos.setY(  0f); this.accelerationY = 0f;}
            if (this.pos.getY() + this.scale.getScaleY()/2f > 100f) {this.pos.setY(100f);}
        } 
        catch (Exception err) {
            
            err.printStackTrace();
        }
    }

    public void jump() {

        if (!this.inAir) {

            this.accelerationY = 30f;
            this.inAir = true;
        }
    }

    public void down() {


    }

    public void left() {

        try {

            this.accelerationX -= this.accelerationXSpeed;
        } 
        catch (Exception err) {

            err.printStackTrace();
        }
    }

    public void right() {

        try {

            this.accelerationX += this.accelerationXSpeed;
        } 
        catch (Exception err) {

            err.printStackTrace();
        }
    }

    public void use() {


    }

    public void interraction() {


    }
}