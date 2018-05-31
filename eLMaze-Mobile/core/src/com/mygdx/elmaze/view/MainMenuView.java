package com.mygdx.elmaze.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.elmaze.ELMaze;
import com.mygdx.elmaze.controller.GameController;

/**
 * Represents the Main Menu View
 */
public class MainMenuView extends MenuView {

    private Image title;
    private Button playButton;
    private Button instructionsButton;
    private Button creditsButton;
    private Button exitButton;

    /**
     * Creates the Main menu
     *
     * @param game Reference to the Game object
     */
    public MainMenuView(ELMaze game) {
        super(game, TYPE.MAIN);

        loadAssets();
        setupButtons();
        setupStage();
    }

    /**
     * Renders the menu on the screen
     *
     * @param delta Time since last render
     */
    @Override
    public void render(float delta) {
        stage.act(delta);
        stage.draw();
    }

    /**
     * Sets up all the Buttons of the menu
     */
    private void setupButtons() {
        exitButton = ButtonFactory.makeButton(game,"exitButtonUp.png","exitButtonDown.png",
                SCREEN_WIDTH/2, SCREEN_HEIGHT*1.15f/9, (int)(SCREEN_WIDTH*0.75), (int)(SCREEN_HEIGHT*0.13));
        creditsButton = ButtonFactory.makeButton(game,"creditsButtonUp.png","creditsButtonDown.png",
                SCREEN_WIDTH/2, SCREEN_HEIGHT*2.70f/9, (int)(SCREEN_WIDTH*0.75), (int)(SCREEN_HEIGHT*0.13));
        instructionsButton = ButtonFactory.makeButton(game,"instructionsButtonUp.png","instructionsButtonDown.png",
                SCREEN_WIDTH/2, SCREEN_HEIGHT*4.25f/9, (int)(SCREEN_WIDTH*0.75), (int)(SCREEN_HEIGHT*0.13));
        playButton = ButtonFactory.makeButton(game, "playButtonUp.png","playButtonDown.png",
                SCREEN_WIDTH/2, SCREEN_HEIGHT*5.80f/9, (int)(SCREEN_WIDTH*0.75), (int)(SCREEN_HEIGHT*0.13));

        addButtonListeners();
    }

    /**
     * Adds all the Button listeners
     */
    private void addButtonListeners() {
        playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                playButtonSound();
                game.activateMenu(MenuFactory.makeMenu(game, TYPE.CONNECTION));
                GameController.getInstance().stopGame();
            }
        });

        instructionsButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                playButtonSound();
                game.activateMenu(MenuFactory.makeMenu(game, TYPE.INSTRUCTIONS));
            }
        });

        creditsButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                playButtonSound();
                game.activateMenu(MenuFactory.makeMenu(game, TYPE.CREDITS));
            }
        });

        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                playButtonSound();
                Gdx.app.exit();
            }
        });
    }

    /**
     * Sets up the stage
     */
    private void setupStage() {
        title = ImageFactory.makeImage(game,"eLMazeTitle.png", SCREEN_WIDTH/2, SCREEN_HEIGHT*7.7f/9,SCREEN_WIDTH*82/100);

        stage.addActor(title);
        stage.addActor(playButton);
        stage.addActor(instructionsButton);
        stage.addActor(creditsButton);
        stage.addActor(exitButton);
    }

    /**
     * Loads all assets needed for the menu
     */
    protected void loadAssets() {
        this.game.getAssetManager().load("eLMazeTitle.png" , Texture.class);
        this.game.getAssetManager().load("exitButtonUp.png" , Texture.class);
        this.game.getAssetManager().load("exitButtonDown.png" , Texture.class);
        this.game.getAssetManager().load("creditsButtonUp.png" , Texture.class);
        this.game.getAssetManager().load("creditsButtonDown.png" , Texture.class);
        this.game.getAssetManager().load("instructionsButtonUp.png" , Texture.class);
        this.game.getAssetManager().load("instructionsButtonDown.png" , Texture.class);
        this.game.getAssetManager().load("playButtonUp.png" , Texture.class);
        this.game.getAssetManager().load("playButtonDown.png" , Texture.class);
        this.game.getAssetManager().finishLoading();
    }

}