package com.sheeesh.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.sheeesh.game.game_states.impl.ConnectionMenu;
import com.sheeesh.game.game_states.impl.LobbyMenu;
import com.sheeesh.game.game_states.impl.MainMenu;
import com.sheeesh.game.game_states.inter.GameState;
import com.sheeesh.game.net.Client;
import com.sheeesh.game.net.Server;
import com.sheeesh.game.utils.ResizeTexture;

import org.w3c.dom.Text;

import java.rmi.*;
import java.net.InetAddress;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Sheeesh extends ApplicationAdapter {
	
	public static int screenWidth; 
	public static int screenHeight; 

	private boolean isLoading;
	private Texture grayBlurr;
	private Sprite loadingIcon;
	private float loadingRotation;
	
	SpriteBatch batch;
	Texture img;

	Label lblFPS, lblCursor;

	GameState gameState;
	
	@Override
	public void create () {

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Sheeesh.screenWidth  = (int) screenSize.getWidth();
		Sheeesh.screenHeight = (int) screenSize.getHeight();

		// System.out.println(Sheeesh.screenWidth + " " + Sheeesh.screenHeight);
		
		Gdx.graphics.setWindowedMode(Sheeesh.screenWidth, Sheeesh.screenHeight);
		Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());

		// Server.startServer();
		// Client.connectServer("127.0.0.1");

		img = ResizeTexture.resizeTexture("player/placeholder.png", 5);

		this.mainMenu();
		this.isLoading = false;
		this.loadingRotation = 0f;

		this.lblFPS = new Label( "Sheeesh", new Skin(Gdx.files.internal("skins/craftacular/skin/craftacular-ui.json")));
		this.lblFPS.setSize(Sheeesh.screenWidth/10f, Sheeesh.screenHeight/20f);
		this.lblFPS.setAlignment(Align.center);
		this.lblFPS.setPosition((Sheeesh.screenWidth*0.5f)-(this.lblFPS.getWidth()/2f), (Sheeesh.screenHeight*0.95f)-(this.lblFPS.getHeight()/2f));
		this.lblFPS.setFontScale(Sheeesh.screenHeight/this.lblFPS.getHeight()*0.02f, Sheeesh.screenHeight/this.lblFPS.getHeight()*0.02f);

		this.lblCursor = new Label( "Sheeesh", new Skin(Gdx.files.internal("skins/craftacular/skin/craftacular-ui.json")));
		this.lblCursor.setSize(Sheeesh.screenWidth/10f, Sheeesh.screenHeight/20f);
		this.lblCursor.setAlignment(Align.center);
		this.lblCursor.setPosition((Sheeesh.screenWidth*0.5f)-(this.lblCursor.getWidth()/2f), (Sheeesh.screenHeight*0.05f)-(this.lblCursor.getHeight()/2f));
		this.lblCursor.setFontScale(Sheeesh.screenHeight/this.lblCursor.getHeight()*0.025f, Sheeesh.screenHeight/this.lblCursor.getHeight()*0.025f);

		this.batch = new SpriteBatch();
	}

	@Override
	public void render () {

		this.lblCursor.setText(String.format("x : %d, y : %d", Gdx.input.getX(), Gdx.input.getY()));
		try {

			Client.sendInputs();
		}
		catch (Exception err) {

			err.printStackTrace();
		}

		ScreenUtils.clear(0, 0, 0, 0);
		batch.begin();
	
		this.gameState.draw(this.batch);

		this.lblFPS.setText(Gdx.graphics.getFramesPerSecond() + " fps");
		this.lblFPS.draw(this.batch, 1);

		if (this.isLoading) this.drawLoading();

		batch.end();
	}
	
	@Override
	public void dispose () {

		batch.dispose();
		img.dispose();
	}

	public void mainMenu() {

		if (this.gameState != null) this.gameState.getStage().clear();
		this.gameState = new MainMenu(this);
	}

	public void connectionMenu() {

		this.gameState.getStage().clear();
		this.gameState = new ConnectionMenu(this);
	}

	public void lobbyMenu() {

		this.gameState.getStage().clear();
		this.gameState = new LobbyMenu(this);
	}

	public void drawLoading() {

		if (this.grayBlurr == null) {

			this.grayBlurr = ResizeTexture.resizeTexture("ui/blurry_gray.png", 100, 100);
		}
			
		if (this.loadingIcon == null) {

			this.loadingIcon = new Sprite(ResizeTexture.resizeTexture("ui/loading.png", 5));
			this.loadingIcon.setPosition(Sheeesh.screenWidth/2f-this.loadingIcon.getWidth()/2f, Sheeesh.screenHeight/2f-this.loadingIcon.getHeight()/2f);
		}			

		this.batch.draw(this.grayBlurr, 0, 0);
		this.loadingIcon.setRotation(this.loadingRotation--);
		this.loadingIcon.draw(this.batch);
	}

	public void setIsLoading(boolean isLoading) {

		if (isLoading) Gdx.input.setInputProcessor(null);
		else Gdx.input.setInputProcessor(this.gameState.getStage());
		this.isLoading = isLoading;

	}
}
