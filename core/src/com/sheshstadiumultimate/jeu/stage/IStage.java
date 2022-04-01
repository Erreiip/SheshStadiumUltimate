package com.sheshstadiumultimate.jeu.stage;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;

public interface IStage {
    public void resize();
    public Stage getStage();
    public void draw(SpriteBatch batch);
    public void clear();
}
