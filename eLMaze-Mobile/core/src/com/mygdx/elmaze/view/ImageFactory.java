package com.mygdx.elmaze.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.mygdx.elmaze.ELMaze;

public class ImageFactory {

    public static Image makeImage(ELMaze game, String fileName, float xPos, float yPos, int width, int height) {
        Image img = new Image(new TextureRegionDrawable(new TextureRegion(
                (Texture)game.getAssetManager().get(fileName)
        )));

        img.setBounds(xPos, yPos, width, height);
        img.setPosition(xPos, yPos, Align.center);

        return img;
    }

    public static Image makeImage(ELMaze game, String fileName, float xPos, float yPos, int width) {
        Texture texture = game.getAssetManager().get(fileName);
        float ratio = (float)texture.getWidth()/(float)texture.getHeight();
        int height = (int)(width/ratio);

        return makeImage(game, fileName, xPos, yPos, width, height);
    }

}
