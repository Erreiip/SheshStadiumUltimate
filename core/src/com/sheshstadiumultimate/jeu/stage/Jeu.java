package com.sheshstadiumultimate.jeu.stage;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import com.sheshstadiumultimate.jeu.joueur.Joueur;

public class Jeu extends UnicastRemoteObject implements IRmiObjJeu{

    private ArrayList<Joueur>     alJoueurs;


    public Jeu() throws RemoteException {
        super();
        this.alJoueurs = new ArrayList<Joueur>();

    }

    public ArrayList<Joueur> getListeJoueur() throws RemoteException {
        return this.alJoueurs;
    }
}
