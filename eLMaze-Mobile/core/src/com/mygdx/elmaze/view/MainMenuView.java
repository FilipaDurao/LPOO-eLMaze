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

public class MainMenuView extends MenuView {

    // Title
    private Image title;

    // Buttons
    private Button playButton;
    private Button instructionsButton;
    private Button creditsButton;
    private Button exitButton;

    public MainMenuView(ELMaze game) {
        super(game, TYPE.MAIN);

        loadAssets();
        setupButtons();
        setupStage();
    }

    @Override
    public void render(float delta) {
        stage.act(delta); //Perform ui logic
        stage.draw(); //Draw the UI
    }

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

    private void addButtonListeners() {
        playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.activateMenu(MenuFactory.makeMenu(game, TYPE.CONNECTION));
            }
        });

        instructionsButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.activateMenu(MenuFactory.makeMenu(game, TYPE.INSTRUCTIONS));
            }
        });

        creditsButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.activateMenu(MenuFactory.makeMenu(game, TYPE.CREDITS));
            }
        });

        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });
    }

    private void setupStage() {
        title = ImageFactory.makeImage(game,"eLMazeTitle.png", SCREEN_WIDTH/2, SCREEN_HEIGHT*7.7f/9,SCREEN_WIDTH*82/100);

        stage.addActor(title);
        stage.addActor(playButton);
        stage.addActor(instructionsButton);
        stage.addActor(creditsButton);
        stage.addActor(exitButton);
    }

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