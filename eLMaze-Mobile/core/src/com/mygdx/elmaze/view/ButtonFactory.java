package com.mygdx.elmaze.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.mygdx.elmaze.ELMaze;

public class ButtonFactory {

    public static Button makeButton(ELMaze game, String upFileName, String downFileName, float xPos, float yPos, int width, int height) {
        Button button = new Button(
            new TextureRegionDrawable(new TextureRegion( (Texture)game.getAssetManager().get(upFileName) )),
            new TextureRegionDrawable(new TextureRegion( (Texture)game.getAssetManager().get(downFileName) ))
        );

        button.setBounds(xPos, yPos, width, height);
        button.setPosition(xPos, yPos, Align.center);

        return button;
    }

}
