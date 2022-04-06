package com.sheeesh.game.net;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.rmi.*;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.sheeesh.game.gameplays.inter.IGame;
import com.sheeesh.game.gameplays.inter.IGamemode;
import com.sheeesh.game.gameplays.inter.PlayerController;

import java.net.InetAddress;

public class Client {

    private static String distantURL;
    private static IGame game;

    private static PlayerController controller;

    public static void connectLocalhost() {

        try {

            Client.game = (IGame) Naming.lookup(Server.URL + "/game");
            Client.controller = Client.game.join();
        } 
        catch (Exception e) {

            e.printStackTrace();
        } 
    }

    public static void sendInputs() throws RemoteException {

        if (Client.controller == null) return;

        if (Gdx.input.isKeyPressed(Input.Keys.W)) {

            Client.controller.jump();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.A) && !Gdx.input.isKeyPressed(Input.Keys.D)) {

            Client.controller.left();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.D) && !Gdx.input.isKeyPressed(Input.Keys.A)) {

            Client.controller.right();
        }
    }

    public static IGame getGame() {

        return Client.game;
    }
}