package com.sheshstadiumultimate.serveur;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.sheshstadiumultimate.game.SheshStadiumUltimate;
import com.sheshstadiumultimate.jeu.stage.Jeu;
import com.sheshstadiumultimate.jeu.stage.lobby.Lobby;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;

public class Serveur extends Thread{


    private static Jeu     serveurJeu;
    private static String  url;

    private static Serveur serveurThread;

    private static String ip;

    private static  boolean  serveurLance;

    private static  Lobby ctrl;

    private static Registry reg;


    public static void lancerServeur( Lobby ctrl) {
        
        if ( Serveur.serveurLance) return;

        Serveur.ctrl = ctrl;

        try {
            Serveur.ip = InetAddress.getLocalHost().getHostName();
        } catch ( Exception e) {

            Serveur.ip = "Non connecté";
        }

        
        try {
            Serveur.reg = LocateRegistry.createRegistry(8451);

            Serveur.serveurJeu = new Jeu();
            Serveur.url = "rmi://" + Serveur.ip + ":505050/Jeu";
            Serveur.reg.bind(Serveur.url, Serveur.serveurJeu);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        Serveur.serveurLance = false;

        Serveur.serveurThread = new Serveur();
        Serveur.serveurThread.start();

        Serveur.ctrl.setIp(Serveur.ip);

    }

    public void run() {
        while ( Serveur.serveurLance ) {

            try {

                Serveur.reg.unbind(Serveur.url);
                Serveur.reg.rebind(Serveur.url, Serveur.serveurJeu);

            } catch (Exception  e) {
                e.printStackTrace();
                Serveur.serveurLance = false;
                Serveur.ip           = "Non connecté";
                Serveur.ctrl.setIp(Serveur.ip); 
                
            }

        }
    }

    
}
