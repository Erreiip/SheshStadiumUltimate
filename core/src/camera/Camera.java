package camera;

import java.rmi.RemoteException;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sheeesh.game.Sheeesh;
import com.sheeesh.game.gameplays.inter.Displayable;
import com.sheeesh.game.net.Client;

public class Camera {
    
    private static Map<TextureRef, Texture> textures;
    private static Sprite placeholder = new Sprite(new Texture(Gdx.files.internal("player/placeholder.png")));
    
    public static void draw(SpriteBatch batch) throws RemoteException {

        for (Displayable element : Client.getGame().getDisplayables()) {

            Sprite sprite = new Sprite(Camera.placeholder);
            sprite.setPosition(Sheeesh.screenWidth*(element.getPosition().getX()/100f)-element.getScale().getScaleX()/2, Sheeesh.screenHeight*(element.getPosition().getY()/100f));
            sprite.setRotation(element.getOrientation().getValue());
            sprite.setSize(Sheeesh.screenWidth*element.getScale().getScaleX()/100, Sheeesh.screenWidth*element.getScale().getScaleY()/100);
            sprite.setAlpha(element.getAlpha().getAlpha());
            sprite.draw(batch);
        }
    }

    private static boolean containsTexture(String id, Integer frame) {

        for (TextureRef tRef : textures.keySet()) {

            if (tRef.equals(id, frame)) {

                return true;
            }
        }
        return false;
    }
}