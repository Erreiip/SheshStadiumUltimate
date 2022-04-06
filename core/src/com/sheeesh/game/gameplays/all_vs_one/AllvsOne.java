package com.sheeesh.game.gameplays.all_vs_one;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import com.sheeesh.game.gameplays.impl.PlayerControllerImpl;
import com.sheeesh.game.gameplays.impl.PlayerImpl;
import com.sheeesh.game.gameplays.inter.Displayable;
import com.sheeesh.game.gameplays.inter.IGame;
import com.sheeesh.game.gameplays.inter.IGamemode;
import com.sheeesh.game.gameplays.inter.Player;
import com.sheeesh.game.gameplays.inter.PlayerController;

public class AllvsOne extends UnicastRemoteObject implements IGamemode {
    
    private List<Player> players;
    private List<Displayable> displayables;
    
    public AllvsOne() throws RemoteException {

        this.players = new ArrayList<Player>();
        this.displayables = new ArrayList<Displayable>();
    }
    
    public void update(double dt) {

        for (Player player : this.players) {

            try {

                player.update(dt);
            } 
            catch (Exception err) {
                
                err.printStackTrace();
            }
        }
    }

    public PlayerController join() throws RemoteException {

        PlayerController controller = new PlayerControllerImpl();
        Player player = new PlayerImpl(controller, this);
        controller.setPlayer(player);
        this.players.add(player);

        return controller;
    }

    public List<Displayable> getDisplayables() {

        return this.displayables;
    }
}