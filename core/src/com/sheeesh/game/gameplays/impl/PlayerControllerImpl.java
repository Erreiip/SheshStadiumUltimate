package com.sheeesh.game.gameplays.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.sheeesh.game.gameplays.inter.Player;
import com.sheeesh.game.gameplays.inter.PlayerController;

public class PlayerControllerImpl extends UnicastRemoteObject implements PlayerController {
    
    private boolean jump;
    private boolean down;
    
    private boolean left;
    private boolean right;

    private boolean use;
    private boolean interraction;

    private Player player;
    
    public PlayerControllerImpl() throws RemoteException {

        this.jump = false;
        this.down = false;
        
        this.left  = false;
        this.right = false;

        this.use          = false;
        this.interraction = false;

        this.player = null;
    }

    public void setPlayer(Player player) {

        this.player = player;
    }

    public void jump() {

        try {

            this.player.jump();
        } 
        catch (Exception err) {

            err.printStackTrace();
        }
    }

    public void down() {

        try {

            this.player.down();
        } 
        catch (Exception err) {

            err.printStackTrace();
        }
    }

    public void left() {

        try {

            this.player.left();
        } 
        catch (Exception err) {

            err.printStackTrace();
        }
    }

    public void right() {

        try {

            this.player.right();
        } 
        catch (Exception err) {

            err.printStackTrace();
        }
    }

    public void use() {

        try {

            this.player.use();
        } 
        catch (Exception err) {

            err.printStackTrace();
        }
    }

    public void interraction() {

        try {

            this.player.interraction();
        } 
        catch (Exception err) {

            err.printStackTrace();
        }
    }
}