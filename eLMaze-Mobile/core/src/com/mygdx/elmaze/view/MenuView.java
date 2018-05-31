package com.mygdx.elmaze.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.elmaze.ELMaze;

/**
 * Represents a menu view
 */
public abstract class MenuView extends ScreenAdapter {

    /**
     * Types of existing menus
     */
    public enum TYPE { MAIN,
                       CREDITS,
                       INSTRUCTIONS,
                       PLAY,
                       CONNECTION,
                       SERVER_WAIT,
                       SERVER_DC,
                       WIN,
                       SERVER_FULL
    };

    public static final int SCREEN_WIDTH = Gdx.graphics.getWidth();
    public static final int SCREEN_HEIGHT = Gdx.graphics.getHeight();
    protected final ELMaze game;

    protected Stage stage;
    protected Image backgroundImage;
    protected Sound buttonClickSound;
    private TYPE type;

    /**
     * Creates a Menu View
     *
     * @param game Reference to the Game object
     * @param type The type of menu View that is being created
     */
    public MenuView(ELMaze game, TYPE type) {
        this.game = game;
        this.type = type;

        setupButtonSound();
        setupBackground();

        stage = new Stage();
        stage.addActor(backgroundImage);
    }

    /**
     * Activates the menu
     */
    public void activate() {
        Gdx.input.setInputProcessor(stage);
    }

    /**
     * @return Returns the type of the menu
     */
    public TYPE getType() {
        return type;
    }

    /**
     * Loads all assets needed for the menu
     */
    protected abstract void loadAssets();

    /**
     * Sets up the background of the menus with the background image
     */
    private void setupBackground(){
        this.game.getAssetManager().load( "background.png" , Texture.class);
        this.game.getAssetManager().finishLoading();
        Texture backgroundTexture = game.getAssetManager().get("background.png");
        backgroundImage = new Image(backgroundTexture);
        backgroundImage.setDrawable(new TextureRegionDrawable(new TextureRegion(backgroundTexture)));
    }

    /**
     * Sets up the sound to be played when a Button is clicked
     */
    private void setupButtonSound() {
        this.game.getAssetManager().load( "buttonClick.mp3" , Sound.class);
        this.game.getAssetManager().finishLoading();

        buttonClickSound = game.getAssetManager().get("buttonClick.mp3");
    }

    /**
     * Plays the sound of a button click
     */
    protected void playButtonSound() {
        buttonClickSound.play(0.75f);
    }
}
