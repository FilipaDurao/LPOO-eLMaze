package com.mygdx.elmaze.view.menus;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;

/**
 * Implements functions related to the creation of Images
 */
public class ImageFactory {

	/**
	 * Creates an Image
	 * 
	 * @param fileName The name of the file containing the image
	 * @param xPos The x position of the Image
	 * @param yPos The y position of the Image
	 * @param width The width of the Image
	 * @param height The height of the Image
	 * 
	 * @return Returns an Image
	 */
    public static Image makeImage(String fileName, float xPos, float yPos, int width, int height) {
        Image img = new Image(new TextureRegionDrawable(new TextureRegion(new Texture(fileName))));

        img.setBounds(xPos, yPos, width, height);
        img.setPosition(xPos, yPos, Align.center);

        return img;
    }

    /**
    * Creates an Image
	 * 
	 * @param fileName The name of the file containing the image
	 * @param xPos The x position of the Image
	 * @param yPos The y position of the Image
	 * @param width The width of the Image
	 * 
     * @return Returns an Image
     */
    public static Image makeImage(String fileName, float xPos, float yPos, int width) {
        Texture texture = new Texture(fileName);
        float ratio = (float)texture.getWidth()/(float)texture.getHeight();
        int height = (int)(width/ratio);

        return makeImage(fileName, xPos, yPos, width, height);
    }

}

