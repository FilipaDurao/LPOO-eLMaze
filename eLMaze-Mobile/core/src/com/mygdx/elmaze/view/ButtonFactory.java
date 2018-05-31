package com.mygdx.elmaze.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.mygdx.elmaze.ELMaze;

/**
 * Implements functions related to the creation of Buttons
 */
public class ButtonFactory {

    /**
     * Creates a Button
     *
     * @param game Reference to the Game Object
     * @param upFileName The name of the file with the image of the Button when the Button is up
     * @param downFileName The name of the file with the image of the Button when the Button is down (pressed)
     * @param xPos The x position of the Button
     * @param yPos The y position of the Button
     * @param width The Button's width
     * @param height The Button's height
     *
     * @return Returns a Button object
     */
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
