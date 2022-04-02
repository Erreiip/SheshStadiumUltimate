package com.sheshstadiumultimate.jeu.stage.lobby;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.sheshstadiumultimate.client.Client;
import com.sheshstadiumultimate.game.SheshStadiumUltimate;
import com.sheshstadiumultimate.jeu.stage.IStage;
import com.sheshstadiumultimate.serveur.Serveur;

import static com.badlogic.gdx.Gdx.*;

import java.net.InetAddress;
import java.rmi.registry.LocateRegistry;


public class Lobby implements IStage{

    private Stage        stage;

    SheshStadiumUltimate ctrl;

    private Label        lblIp;
    private String       ip;

    private TextButton btnBack;

    public Lobby(SheshStadiumUltimate ctrl1) {

        this.ctrl = ctrl1;

        this.stage = new Stage( );

        

        if ( Client.getReg() == null ) {
            Serveur.lancerServeur(this);
            Client.connecter(this.ip);
        }

        

        this.lblIp = new Label(this.ip,new Skin(files.internal("assets/skins/craftacular/skin/craftacular-ui.json")));
		this.lblIp.setPosition(graphics.getWidth()/2 - this.lblIp.getWidth()/2, graphics.getHeight() - this.lblIp.getHeight());
        this.lblIp.setAlignment(Align.center);
        this.lblIp.setFontScale((SheshStadiumUltimate.getWidth()*0.0005f), (SheshStadiumUltimate.getHeight()*0.001f));

        this.btnBack = new TextButton("X",new Skin(files.internal("assets/skins/craftacular/skin/craftacular-ui.json")));
		this.btnBack.setSize(50,50 );
		this.btnBack.setPosition(0, graphics.getHeight() - this.btnBack.getHeight() );
        this.btnBack.getLabel().setFontScale( SheshStadiumUltimate.getWidth()*2/this.btnBack.getWidth() * 0.01f );
        this.btnBack.addListener(new ClickListener(){
            
            public void clicked(InputEvent event, float x, float y) {
                ctrl.changerEtat("MENU");
            }
        });

        this.stage.addActor(this.btnBack);
        this.stage.addActor(this.lblIp);
        this.stage.act();
        
    }

    public void draw(SpriteBatch batch) {
        this.stage.draw();
    }

    public Stage getStage() {
        return this.stage;
    }

    public void setIp( String ip) {
        this.ip = ip;
        if ( this.lblIp != null )
            this.lblIp.setText(this.ip);
    }

    public Array<Actor> getActors() {
        return this.stage.getActors();
    }

    public void resize() {
        this.stage.getViewport().update(SheshStadiumUltimate.getWidth(), SheshStadiumUltimate.getHeight(), true);
    }

    public void clear() {
        this.stage.clear();
    }



        
}
