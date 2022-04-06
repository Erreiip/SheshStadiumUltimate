package com.sheeesh.game.net;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
// import com.sheeesh.game.game.SheeeshGame;

import com.badlogic.gdx.Gdx;
import com.sheeesh.game.gameplays.all_vs_one.AllvsOne;
import com.sheeesh.game.gameplays.inter.IGame;
import com.sheeesh.game.gameplays.inter.IGamemode;

import java.net.InetAddress;

public class Server {
 
    public final static int PORT = 6969;
    public static String URL;

    private static IGamemode game;
    private static GameEngine engine;

    public static boolean mesCouillesSurTonFrontCaFaitUnRadeau = false;

    public static void startServer() {

        try {

            Server.URL = String.format("rmi://%s:%d", InetAddress.getLocalHost().getHostAddress(), Server.PORT);
            Server.game = new AllvsOne();    
            
            LocateRegistry.createRegistry(Server.PORT);
            
            System.out.println("Enregistrement de l'objet avec l'url : " + Server.URL);
            Naming.rebind(Server.URL + "/game", (IGame) Server.game);
        } 
        catch (Exception err) {

            err.printStackTrace();
        }

        Server.engine = new GameEngine(Server.game);
        Server.engine.start();
    }

    public static void mesCouillesSurTonFrontCaFaitUnRadeau() {
        
    }
}

class GameEngine extends Thread {

    private IGamemode game;

    public GameEngine(IGamemode game) {

        this.game = game;
    }

    public void run() {
        
        long timestamp = System.nanoTime();
        while (true) {

            try {

                this.game.update((System.nanoTime()-timestamp)*1e-9);
                Thread.sleep(0);
                timestamp = System.nanoTime();
            } 
            catch (Exception err) {
                
                err.printStackTrace();
            }
        }     
    }
}