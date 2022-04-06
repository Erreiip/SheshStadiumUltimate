package com.sheeesh.game.game_states.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextTooltip;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.FocusListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.sheeesh.game.Sheeesh;
import com.sheeesh.game.game_states.inter.GameState;

public class ConnectionMenu implements GameState {
    
    private static Sheeesh main;
    
    private Stage stage;
    
    private Label lblIp;
    private TextField txtfldIp;
    private TextButton btnCancel;
    
    public ConnectionMenu(Sheeesh main) {

        ConnectionMenu.main = main;
        this.stage = new Stage();
        
        // 169.254.19.21 EBDE02DF
        // Création et positionnement des composants

        this.txtfldIp = new TextField("Sheeesh", new Skin(Gdx.files.internal("skins/craftacular/skin/craftacular-ui.json")));
        this.txtfldIp.setSize(Sheeesh.screenWidth/8f, Sheeesh.screenHeight/20f);
		// this.txtfldIp.setAlignment(Align.center);
		this.txtfldIp.setPosition((Sheeesh.screenWidth*0.5f)-(this.txtfldIp.getWidth()/2f), (Sheeesh.screenHeight*0.5f)-(this.txtfldIp.getHeight()/2f));

        this.lblIp = new Label( "Adresse IP :", new Skin(Gdx.files.internal("skins/craftacular/skin/craftacular-ui.json")));
		this.lblIp.setSize(Sheeesh.screenWidth/10f, Sheeesh.screenHeight/20f);
		this.lblIp.setAlignment(Align.center);
		this.lblIp.setPosition((Sheeesh.screenWidth*0.5f)-(this.lblIp.getWidth()/2f), (Sheeesh.screenHeight*0.5f)-(this.lblIp.getHeight()/2f)+(this.txtfldIp.getHeight()));
		this.lblIp.setFontScale(Sheeesh.screenHeight/this.lblIp.getHeight()*0.025f, Sheeesh.screenHeight/this.lblIp.getHeight()*0.025f);

        this.btnCancel = new TextButton("X", new Skin(Gdx.files.internal("skins/craftacular/skin/craftacular-ui.json"))); 
        this.btnCancel.setSize(Sheeesh.screenHeight/20f, Sheeesh.screenHeight/20f);
        this.btnCancel.setPosition(Sheeesh.screenWidth/2f-this.btnCancel.getWidth()/2f-this.txtfldIp.getWidth()*0.7f, Sheeesh.screenHeight/2f-this.btnCancel.getHeight()/2f);
        this.btnCancel.getLabel().setFontScale(Sheeesh.screenHeight/this.btnCancel.getHeight()*0.025f, Sheeesh.screenHeight/this.btnCancel.getHeight()*0.025f);

        // Activation des composants

        this.txtfldIp.addListener(new FocusListener() {
            public void keyboardFocusChanged(FocusListener.FocusEvent event, Actor actor, boolean focused) {

                if(focused == true) {
                    txtfldIp.setText("");
                }
            }
        });
        this.txtfldIp.setTextFieldListener(new TextFieldListener() {
            @Override
            public void keyTyped(TextField textField, char key) {
                if ((key == '\r' || key == '\n')) {
                    ConnectionMenu.main.setIsLoading(true);
                }
            }
        });
        this.btnCancel.addListener(new ClickListener() {

            @Override
            public void clicked(InputEvent event, float x, float y) {
                ConnectionMenu.main.mainMenu();
            }
        });

        this.stage.addActor(this.lblIp);
        this.stage.addActor(this.txtfldIp);
        this.stage.addActor(this.btnCancel);

        Gdx.input.setInputProcessor(this.stage);
    }
    
    public void draw(SpriteBatch batch) {

        this.stage.getViewport().update(Sheeesh.screenWidth, Sheeesh.screenHeight, true);
        
        this.stage.draw();
    }

    public void delete() {

        for (Actor actor : this.stage.getActors()) {

            actor.remove();
        }
    }

    public Stage getStage() {

        return this.stage;
    }
}