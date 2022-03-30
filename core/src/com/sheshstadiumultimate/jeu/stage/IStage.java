package com.sheshstadiumultimate.jeu.stage;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public interface IStage {
    public void resize();
    public Stage getStage();
    public void draw(SpriteBatch batch);
}
