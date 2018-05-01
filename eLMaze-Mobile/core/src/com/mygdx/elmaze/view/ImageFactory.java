package com.mygdx.elmaze.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import javax.xml.soap.Text;

public class ImageFactory {

    public static Image makeImage(String fileName, float xPos, float yPos, int width, int height) {
        Texture texture = makeSizedTexture(fileName, width, height);

        Image img = new Image(texture);
        img.setPosition(xPos, yPos);
        img.setDrawable(new TextureRegionDrawable(new TextureRegion(texture)));

        return img;
    }

    public static Texture makeSizedTexture(String fileName, int width, int height) {
        Pixmap originalSizePMap = new Pixmap(Gdx.files.internal(fileName));
        Pixmap newSizePMap = new Pixmap(width, height, originalSizePMap.getFormat());

        newSizePMap.drawPixmap(originalSizePMap,
                0, 0, originalSizePMap.getWidth(), originalSizePMap.getHeight(),
                0, 0, newSizePMap.getWidth(), newSizePMap.getHeight()
        );

        return new Texture(newSizePMap);
    }

    public static Texture makeSizedTexture(String fileName, int width) {
        Pixmap originalSizePMap = new Pixmap(Gdx.files.internal(fileName));

        float ratio = (float)originalSizePMap.getWidth()/(float)originalSizePMap.getHeight();

        Pixmap newSizePMap = new Pixmap(
                width,
                (int) (width/ratio),
                originalSizePMap.getFormat()
        );

        newSizePMap.drawPixmap(originalSizePMap,
                0, 0, originalSizePMap.getWidth(), originalSizePMap.getHeight(),
                0, 0, newSizePMap.getWidth(), newSizePMap.getHeight()
        );

        return new Texture(newSizePMap);
    }

}
