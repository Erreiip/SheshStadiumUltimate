package com.sheshstadiumultimate.jeu.stage.menu;


import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.sheshstadiumultimate.client.Client;
import com.sheshstadiumultimate.game.SheshStadiumUltimate;
import com.sheshstadiumultimate.jeu.stage.IStage;


import static com.badlogic.gdx.Gdx.*;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MenuClient implements IStage {

    private Stage         stage;

    private SheshStadiumUltimate ctrl;

    private TextButton    btnBack;
    private TextField     txtField;
    
    public MenuClient(SheshStadiumUltimate ctrl1) {

        this.ctrl = ctrl1;

        this.stage = new Stage();

        this.txtField = new TextField("" ,new Skin(files.internal("assets/skins/craftacular/skin/craftacular-ui.json")));
		this.txtField.setSize(200,50 );
		this.txtField.setPosition(graphics.getWidth()/2 - this.txtField.getWidth()/2, graphics.getHeight()/2 - this.txtField.getHeight()/2 );
        this.txtField.addListener(new InputListener() {
            @Override
            public boolean keyUp(InputEvent event, int keycode) {
                if (keycode == Input.Keys.ENTER) {
                    if (Client.connecter(txtField.getText())) {
                        ctrl.changerEtat("LOBBY_SERVEUR");
                    }
                }
                return false;
            }});

        this.btnBack = new TextButton("X",new Skin(files.internal("assets/skins/craftacular/skin/craftacular-ui.json")));
		this.btnBack.setSize(50,50 );
		this.btnBack.setPosition(graphics.getWidth()/2 - this.btnBack.getWidth() - this.txtField.getWidth()/2 - SheshStadiumUltimate.getWidth()/100, graphics.getHeight()/2 - this.btnBack.getHeight()/2  );
        this.btnBack.getLabel().setFontScale( SheshStadiumUltimate.getWidth()*2/this.btnBack.getWidth() * 0.01f );
        this.btnBack.addListener(new ClickListener(){
            
            public void clicked(InputEvent event, float x, float y) {
                ctrl.changerEtat("MENU");
            }
        });


        this.stage.addActor(this.txtField);
        this.stage.addActor(this.btnBack );
        this.stage.act();


    }

    public void resize() {
        this.stage.getViewport().update(SheshStadiumUltimate.getWidth(), SheshStadiumUltimate.getHeight(), true);
    }

    @Override
    public Stage getStage() {
        return this.stage;
    }

    @Override
    public void draw(SpriteBatch batch) {
        this.stage.draw();
        
    }

    public void clear() {
        this.stage.clear();
    }


    
}
