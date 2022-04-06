package com.sheeesh.game.utils;

import com.badlogic.gdx.graphics.Texture;
import com.sheeesh.game.Sheeesh;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.Gdx;

public class ResizeTexture {
    
    private ResizeTexture() {}

    public static Texture resizeTexture(String path, int pourcentOnScreenSize) {

        Pixmap pixmap200 = new Pixmap(Gdx.files.internal(path));
        Pixmap pixmap100 = new Pixmap(Sheeesh.screenWidth*pourcentOnScreenSize/100, Sheeesh.screenWidth*pourcentOnScreenSize/100, pixmap200.getFormat());
        pixmap100.drawPixmap(pixmap200,
                0, 0, pixmap200.getWidth(), pixmap200.getHeight(),
                0, 0, pixmap100.getWidth(), pixmap100.getHeight()
        );
        Texture texture = new Texture(pixmap100);
        pixmap200.dispose();
        pixmap100.dispose();

        return texture;
    }

    public static Texture resizeTexture(String path, int pourcentOnScreenSizeX, int pourcentOnScreenSizeY) {

        Pixmap pixmap200 = new Pixmap(Gdx.files.internal(path));
        Pixmap pixmap100 = new Pixmap(Sheeesh.screenWidth*pourcentOnScreenSizeX/100, Sheeesh.screenHeight*pourcentOnScreenSizeY/100, pixmap200.getFormat());
        pixmap100.drawPixmap(pixmap200,
                0, 0, pixmap200.getWidth(), pixmap200.getHeight(),
                0, 0, pixmap100.getWidth(), pixmap100.getHeight()
        );
        Texture texture = new Texture(pixmap100);
        pixmap200.dispose();
        pixmap100.dispose();

        return texture;
    }
}