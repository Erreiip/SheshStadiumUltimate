package com.sheshstadiumultimate.jeu.stage;

import java.rmi.Remote; 
import java.rmi.RemoteException;
import java.util.ArrayList;

import com.sheshstadiumultimate.jeu.joueur.Joueur; 

public interface IRmiObjJeu extends Remote {
    public ArrayList<Joueur> getListeJoueur()throws RemoteException;
}
