package com.mygdx.elmaze.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.elmaze.ELMaze;

public class ButtonFactory {

    public static ImageButton makeImageButton(String upFileName, String downFileName, float xPos, float yPos, int width, int height) {
        ImageButton imageButton = new ImageButton(
            createDrawable(upFileName, width, height),
            createDrawable(downFileName, width, height)
        );

        imageButton.setPosition(xPos, yPos, 1);
        return imageButton;
    }

    private static TextureRegionDrawable createDrawable(String fileName, int width, int height) {
        Texture texture = new Texture(Gdx.files.internal(fileName));
        texture.setWrap(Texture.TextureWrap.MirroredRepeat, Texture.TextureWrap.MirroredRepeat);
        TextureRegion textureRegion = new TextureRegion(texture);
        textureRegion.setRegionHeight(height);
        textureRegion.setRegionWidth(width);
        return new TextureRegionDrawable(textureRegion);
    }

}
