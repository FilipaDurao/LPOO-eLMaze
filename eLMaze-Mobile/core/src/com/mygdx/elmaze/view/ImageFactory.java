package com.mygdx.elmaze.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;

public class ImageFactory {

    public static Image makeImage(String fileName, float xPos, float yPos, int width, int height) {
        Image img = new Image(new TextureRegionDrawable(new TextureRegion(new Texture(fileName))));

        img.setBounds(xPos, yPos, width, height);
        img.setPosition(xPos, yPos, Align.center);

        return img;
    }

    public static Image makeImage(String fileName, float xPos, float yPos, int width) {
        Texture texture = new Texture(fileName);
        float ratio = (float)texture.getWidth()/(float)texture.getHeight();
        int height = (int)(width/ratio);

        return makeImage(fileName, xPos, yPos, width, height);
    }

}
