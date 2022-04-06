package com.sheeesh.game.game_states.inter;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public interface GameState {
    
    public abstract void draw(SpriteBatch batch);

    public abstract Stage getStage();
}