package com.sheeesh.game.game_states.impl;

import java.rmi.RemoteException;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.sheeesh.game.Sheeesh;
import com.sheeesh.game.game_states.inter.GameState;
import com.sheeesh.game.net.Client;

import camera.Camera;

public class LobbyMenu implements GameState {
    
    private Stage stage;
    private Sheeesh main;
    
    public LobbyMenu(Sheeesh main) {

        this.main = main;
    }
    
    public void draw(SpriteBatch batch) {

        if (Client.getGame() != null) {

            try {

                Camera.draw(batch);
                
            }
            catch (Exception err) {

                err.printStackTrace();
            }
        }
    }

    public Stage getStage() {

        return this.stage;
    }
}