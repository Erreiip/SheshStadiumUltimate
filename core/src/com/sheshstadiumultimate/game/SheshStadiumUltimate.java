package com.sheshstadiumultimate.game;

import com.sheshstadiumultimate.camera.Camera;
import com.sheshstadiumultimate.jeu.stage.IStage;
import com.sheshstadiumultimate.jeu.stage.lobby.Lobby;
import com.sheshstadiumultimate.jeu.stage.menu.Menu;
import com.sheshstadiumultimate.jeu.stage.menu.MenuClient;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import static com.badlogic.gdx.Gdx.*;

import java.awt.Dimension;


public class SheshStadiumUltimate extends ApplicationAdapter {
	SpriteBatch batch;
	Menu        scene;
	Button      btnJeu;
	Label       lblJeu;

	String      etat;

	IStage        stage;

	private static int height;
	private static int width;
	
	@Override
	public void create () {
		
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

        SheshStadiumUltimate.height = (int) dimension.getHeight();
        SheshStadiumUltimate.width  = (int) dimension.getWidth ();


		graphics.setWindowedMode(graphics.getDisplayMode().width, graphics.getDisplayMode().height);
		graphics.setFullscreenMode(graphics.getDisplayMode());
		
		
		this.stage = new Menu(this);
		input.setInputProcessor(stage.getStage());

		this.etat = "MENU";

		
		this.batch = new SpriteBatch();
		

	}

	@Override
	public void render () {

		ScreenUtils.clear(0,0,0,0);

		this.batch.begin();

		stage.resize();
		stage.draw(this.batch);
		Camera.dessiner(batch);
		

		this.batch.end();
		
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}

	public void changerEtat(String etat) {
		this.stage.clear();

		if ( etat.equals("LOBBY_SERVEUR")) {
			this.stage = new Lobby();
		}

		if ( etat.equals("MENU_CLIENT")) {
			this.stage = new MenuClient(this);
		}

				
	}

	public static int getHeight() {
		return SheshStadiumUltimate.height;
	}

	public static int getWidth() {
		return SheshStadiumUltimate.width;
	}

	


}
