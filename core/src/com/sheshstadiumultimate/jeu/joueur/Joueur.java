package com.sheshstadiumultimate.jeu.joueur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Joueur extends UnicastRemoteObject  {

    private int    x;
    private int    y;

    private String dir;

    private int    vitesse;

    private String id;

    public Joueur() throws RemoteException { super();}

    public Joueur(String id) throws RemoteException  {

        super();

        this.x = this.y = 0;
        this.id         = id;

        this.vitesse    = 10;
        this.dir        = "" ;

    }

    public void deplacer(double pourcentY, double pourcentX) throws RemoteException{

        this.x += this.vitesse * pourcentY;
        this.y += this.vitesse * pourcentX;


        if ( pourcentX == 0 && pourcentY == 0 ) this.dir = "";

        if ( pourcentX >  0 ) this.dir  = "N";
        if ( pourcentX <  0 ) this.dir  = "S";
        if ( pourcentX == 0 ) this.dir  = "";

        if ( pourcentY >  0 ) this.dir += "E";
        if ( pourcentY <  0 ) this.dir += "O";
        if ( pourcentY == 0 ) this.dir += "";

        if ( pourcentX == 0 && pourcentY == 0 ) this.dir = "";

    }

    /*public boolean voit( IObjetJeu o, float hauteur, float largeur ) {
        if ( o.getY() < this.getY() - hauteur/2  || o.getY() > this.getY() + hauteur/2 ) return false;
        if ( o.getX() < this.getX() - largeur/2  || o.getX() > this.getX() + largeur/2 ) return false;

        return true;
    }*/



    public String getID() throws RemoteException  { return this.id; }
    public int getX()     throws RemoteException  { return this.x;  }
    public int getY()     throws RemoteException  { return this.y;  }
    public String getDir() throws RemoteException { return this.dir;}


    public void setX(int x) throws RemoteException{ this.x = x;     }
    public void setY(int y) throws RemoteException{ this.y = y;     }


}
