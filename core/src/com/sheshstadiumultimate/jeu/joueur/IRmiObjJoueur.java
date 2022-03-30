package com.sheshstadiumultimate.jeu.joueur;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRmiObjJoueur extends Remote {
    public void deplacer(double pourcentY, double pourcentX) throws RemoteException;
    public String getID()throws RemoteException;
    public int getX()throws RemoteException;
    public int getY()throws RemoteException;
    public String getDir()throws RemoteException;
    public void setX(int x)throws RemoteException;
    public void setY(int y)throws RemoteException;
}
