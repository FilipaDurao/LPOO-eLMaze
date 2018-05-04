package com.mygdx.elmaze.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;

public class ButtonFactory {

    public static Button makeButton(String upFileName, String downFileName, float xPos, float yPos, int width, int height) {
        Button button = new Button(
            new TextureRegionDrawable(new TextureRegion(new Texture(upFileName))),
            new TextureRegionDrawable(new TextureRegion(new Texture(downFileName)))
        );

        button.setBounds(xPos, yPos, width, height);
        button.setPosition(xPos, yPos, Align.center);

        return button;
    }

}
