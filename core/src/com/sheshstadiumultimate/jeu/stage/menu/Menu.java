package com.sheshstadiumultimate.jeu.stage.menu;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.sheshstadiumultimate.game.SheshStadiumUltimate;
import com.sheshstadiumultimate.jeu.stage.IStage;

import static com.badlogic.gdx.Gdx.*;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Menu implements IStage{
    
    private Stage stage;

    private TextButton btnServeur;
    private TextButton btnClient;

    private SheshStadiumUltimate ctrl;

    private Label  lblDebug;

    public Menu(SheshStadiumUltimate ctrl1) {
        
        this.stage = new Stage( );

        this.ctrl = ctrl1;

        this.btnServeur = new TextButton("Lancer Serveur",new Skin(files.internal("assets/skins/craftacular/skin/craftacular-ui.json")));
		this.btnServeur.setSize(225,55 );
        this.btnServeur.setOrigin  (graphics.getWidth()/2 - this.btnServeur.getWidth()/2, graphics.getHeight()/2 - this.btnServeur.getHeight()/2 );
		this.btnServeur.setPosition(graphics.getWidth()/2 - this.btnServeur.getWidth()/2, graphics.getHeight()/2 + SheshStadiumUltimate.getHeight()/100 );
        this.btnServeur.getLabel().setFontScale( SheshStadiumUltimate.getWidth()*2/this.btnServeur.getWidth() * 0.037f );
		this.btnServeur.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ctrl.changerEtat("LOBBY_SERVEUR");
            }
		});

        this.btnClient = new TextButton("Rejoindre Serveur",new Skin(files.internal("assets/skins/craftacular/skin/craftacular-ui.json")));
		this.btnClient.setSize(225,55 );
        this.btnClient.setOrigin  (graphics.getWidth()/2 - this.btnServeur.getWidth()/2, graphics.getHeight()/2 - this.btnServeur.getHeight()/2 );
		this.btnClient.setPosition(graphics.getWidth()/2 - this.btnServeur.getWidth()/2, graphics.getHeight()/2 - this.btnServeur.getHeight() - SheshStadiumUltimate.getHeight()/100 );
        this.btnClient.getLabel().setFontScale( SheshStadiumUltimate.getWidth()*2/this.btnServeur.getWidth() * 0.037f );
        this.btnClient.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ctrl.changerEtat("MENU_CLIENT");
            }
		});
    

        
    
        this.stage.addActor(this.btnClient);
        this.stage.addActor(this.btnServeur);
        this.stage.act();
    }

    public void draw(SpriteBatch batch) {
        this.stage.draw();
    }

    public Stage getStage() {
        return this.stage;
    }

    public void resize() {
        this.stage.getViewport().update(SheshStadiumUltimate.getWidth(), SheshStadiumUltimate.getHeight(), true);
    }

    public Array<Actor> getActors() {
        return this.stage.getActors();
    }


    public void clear() {
        this.stage.clear();
    }

    public void debug( float x, float y) {
        this.lblDebug.setText("x : " + x + " y : " + y );
    }
}
