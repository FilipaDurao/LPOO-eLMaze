package com.mygdx.elmaze.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class ButtonFactory {

    public static Button makeButton(String upFileName, String downFileName, float xPos, float yPos, int width, int height) {
        ImageButton imageButton = new ImageButton(
            createDrawable(upFileName, width, height),
            createDrawable(downFileName, width, height)
        );

        imageButton.setPosition(xPos, yPos, 1);
        return imageButton;
    }

    private static TextureRegionDrawable createDrawable(String fileName, int width, int height) {
        Texture texture = createSizedTexture(fileName, width, height);
        texture.setWrap(Texture.TextureWrap.MirroredRepeat, Texture.TextureWrap.MirroredRepeat);

        TextureRegion textureRegion = new TextureRegion(texture);
        textureRegion.setRegionHeight(height);
        textureRegion.setRegionWidth(width);

        return new TextureRegionDrawable(textureRegion);
    }

    private static Texture createSizedTexture(String fileName, int width, int height) {
        Pixmap originalSizePMap = new Pixmap(Gdx.files.internal(fileName));
        Pixmap newSizePMap = new Pixmap(width, height, originalSizePMap.getFormat());

        newSizePMap.drawPixmap(originalSizePMap,
                0, 0, originalSizePMap.getWidth(), originalSizePMap.getHeight(),
                0, 0, newSizePMap.getWidth(), newSizePMap.getHeight()
        );

        return new Texture(newSizePMap);
    }

}
