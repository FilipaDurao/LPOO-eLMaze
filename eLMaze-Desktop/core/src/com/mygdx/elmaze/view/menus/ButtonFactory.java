package com.mygdx.elmaze.view.menus;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;

public class ButtonFactory {

    public static Button makeButton(Texture upTexture, Texture downTexture, float xPos, float yPos, int width, int height) {
        Button button = new Button(
            new TextureRegionDrawable(new TextureRegion(upTexture)),
            new TextureRegionDrawable(new TextureRegion(downTexture))
        );

        button.setBounds(xPos, yPos, width, height);
        button.setPosition(xPos, yPos, Align.center);

        return button;
    }

}
