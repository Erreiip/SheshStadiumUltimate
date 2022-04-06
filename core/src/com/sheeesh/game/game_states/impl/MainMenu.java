package com.sheeesh.game.game_states.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.sheeesh.game.Sheeesh;
import com.sheeesh.game.game_states.inter.GameState;
import com.sheeesh.game.net.Client;
import com.sheeesh.game.net.Server;

public class MainMenu implements GameState {
    
    private static Sheeesh main;
    
    private Stage stage;
    
    private TextButton btnCreateLobby;
    private TextButton btnJoinLobby;
    
    public MainMenu(Sheeesh main) {

        MainMenu.main = main;
        this.stage = new Stage();
        
        // 169.254.19.21 EBDE02DF
        // Création et positionnement des composants

        this.btnCreateLobby = new TextButton("Lancer un lobby", new Skin(Gdx.files.internal("skins/craftacular/skin/craftacular-ui.json")));
        this.btnCreateLobby.setSize(Sheeesh.screenWidth/10f, Sheeesh.screenHeight/20f);
        this.btnCreateLobby.setPosition((Sheeesh.screenWidth/2f)-(this.btnCreateLobby.getWidth()/2f), (Sheeesh.screenHeight/2f)-(this.btnCreateLobby.getHeight()/2f));
        this.btnCreateLobby.getLabel().setFontScale(Sheeesh.screenHeight/this.btnCreateLobby.getHeight()*0.025f, Sheeesh.screenHeight/this.btnCreateLobby.getHeight()*0.025f);

        this.btnJoinLobby = new TextButton("Rejoindre un lobby", new Skin(Gdx.files.internal("skins/craftacular/skin/craftacular-ui.json"))); 
        this.btnJoinLobby.setSize(Sheeesh.screenWidth/10f, Sheeesh.screenHeight/20f);
        this.btnJoinLobby.setPosition(Sheeesh.screenWidth/2f-this.btnCreateLobby.getWidth()/2f, Sheeesh.screenHeight/2f-this.btnCreateLobby.getHeight()/2f-this.btnCreateLobby.getHeight()*1.5f);
        this.btnJoinLobby.getLabel().setFontScale(Sheeesh.screenHeight/this.btnCreateLobby.getHeight()*0.025f, Sheeesh.screenHeight/this.btnCreateLobby.getHeight()*0.025f);

        // Activation des composants

        this.btnCreateLobby.addListener(new ClickListener() {

            @Override
            public void clicked(InputEvent event, float x, float y) {

                MainMenu.main.setIsLoading(true);
                try {

                    Server.startServer();
                    Client.connectLocalhost();
                    MainMenu.main.lobbyMenu();
                    MainMenu.main.setIsLoading(false);
                }
                catch (Exception err) {

                    err.printStackTrace();
                    MainMenu.main.setIsLoading(false);
                }
                
            }
        });
        this.btnJoinLobby.addListener(new ClickListener() {

            @Override
            public void clicked(InputEvent event, float x, float y) {
                MainMenu.main.connectionMenu();
            }
        });

        this.stage.addActor(this.btnCreateLobby);
        this.stage.addActor(this.btnJoinLobby);

        Gdx.input.setInputProcessor(this.stage);
    }
    
    public void draw(SpriteBatch batch) {

        this.stage.getViewport().update(Sheeesh.screenWidth, Sheeesh.screenHeight, true);
        
        this.stage.draw();
    }

    public Stage getStage() {

        return this.stage;
    }
}