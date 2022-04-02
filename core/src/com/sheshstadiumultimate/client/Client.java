package com.sheshstadiumultimate.client;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.sheshstadiumultimate.jeu.stage.IRmiObjJeu;

public class Client {

    private static IRmiObjJeu jeuCLient;

    private static Registry reg;

    private static boolean  estConnecte;  

    private static String   ip;

    public static boolean connecter(String ip) {

        Client.ip = ip;

        try {

            Client.reg = LocateRegistry.getRegistry(8451);

            Remote r = Client.reg.lookup("rmi://" + ip + ":505050/Jeu");

            if ( r instanceof IRmiObjJeu) {
                Client.jeuCLient = ((IRmiObjJeu) r);
            }

            estConnecte = true;
            
        } catch (Exception e) {
            estConnecte = false;
        }

        return estConnecte;
    }

    public static IRmiObjJeu chercher(String obj) {
        if ( Client.reg == null ) return null;
        if ( obj.equals("")     ) return null;

        try {
            Remote r = Client.reg.lookup("rmi://" + Client.ip + "/:505050" + obj);
            if ( r instanceof IRmiObjJeu) {
                return (IRmiObjJeu) r;
            }
        } catch (Exception e) {}

        return null;
    }

    public static IRmiObjJeu getJeu() { return Client.jeuCLient; }

    public static Registry   getReg() { return Client.reg;       }
    
}
