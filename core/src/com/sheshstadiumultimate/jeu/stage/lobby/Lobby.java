package com.sheshstadiumultimate.jeu.stage.lobby;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.sheshstadiumultimate.game.SheshStadiumUltimate;
import com.sheshstadiumultimate.jeu.stage.IStage;
import com.sheshstadiumultimate.serveur.Serveur;

import static com.badlogic.gdx.Gdx.*;


public class Lobby implements IStage{

    private Stage        stage;

    SheshStadiumUltimate ctrl;

    private Label        lblIp;
    private String       ip;

    public Lobby() {

        this.stage = new Stage( );

        Serveur.lancerServeur(this);

        this.lblIp = new Label(this.ip,new Skin(files.internal("assets/skins/craftacular/skin/craftacular-ui.json")));
		this.lblIp.setPosition(graphics.getWidth()/2 - this.lblIp.getWidth()/2, graphics.getHeight() - this.lblIp.getHeight());
        this.lblIp.setAlignment(Align.center);
        this.lblIp.setFontScale((int)(SheshStadiumUltimate.getWidth()*0.001), (int)(SheshStadiumUltimate.getHeight()*0.001));

        this.stage.addActor(lblIp);
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

        
}
