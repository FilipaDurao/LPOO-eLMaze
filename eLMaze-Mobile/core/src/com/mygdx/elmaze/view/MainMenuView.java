package com.mygdx.elmaze.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.elmaze.view.MenuFactory;
import com.mygdx.elmaze.ELMaze;

import javax.swing.text.ViewFactory;


public class MainMenuView extends MenuView {

    // Background
    private Image backgroundImage;

    // Buttons
    private ImageButton playButton;
    private ImageButton instructionsButton;
    private ImageButton creditsButton;
    private ImageButton exitButton;

    public MainMenuView(ELMaze game) {
        super(game, TYPE.MAIN);
        setUpBackground();
        setUpPlayButton();
        setUpInstructionsButton();
        setUpCreditsButton();
        setUpExitButton();
        setUpStage();
    }

    @Override
    public void render(float delta) {
        stage.act(delta); //Perform ui logic
        stage.draw(); //Draw the UI

        handleInputs();
    }

    private void setUpBackground(){
        Texture backgroundTexture = new Texture("background.png");
        backgroundImage = new Image(backgroundTexture);
        backgroundImage.setDrawable(new TextureRegionDrawable(new TextureRegion(backgroundTexture)));
        backgroundImage.setSize(backgroundTexture.getWidth(), backgroundTexture.getHeight());
    }

    private void setUpPlayButton(){
        Texture playButtonTextureUp = new Texture(Gdx.files.internal("genericButtonUp.png"));
        TextureRegion playButtonTextureRegionUp = new TextureRegion(playButtonTextureUp);
        setupTextureRegion(playButtonTextureRegionUp, (int)(SCREEN_WIDTH*0.75), (int)(SCREEN_HEIGHT*0.15));
        TextureRegionDrawable playButtonDrawableUp = new TextureRegionDrawable(playButtonTextureRegionUp);

        Texture playButtonTextureDown = new Texture(Gdx.files.internal("genericButtonDown.png"));
        TextureRegion playButtonTextureRegionDown = new TextureRegion(playButtonTextureDown);
        setupTextureRegion(playButtonTextureRegionDown, (int)(SCREEN_WIDTH*0.75), (int)(SCREEN_HEIGHT*0.15));
        TextureRegionDrawable playButtonDrawableDown = new TextureRegionDrawable(playButtonTextureRegionDown);

        playButton = new ImageButton(playButtonDrawableUp, playButtonDrawableDown);
        playButton.setPosition(SCREEN_WIDTH/2, SCREEN_HEIGHT*6.25f/9, 1);
    }

    private void setUpInstructionsButton(){
        Texture instructionsButtonTextureUp = new Texture(Gdx.files.internal("genericButtonUp.png"));
        TextureRegion instructionsButtonTextureRegionUp = new TextureRegion(instructionsButtonTextureUp);
        setupTextureRegion(instructionsButtonTextureRegionUp, (int)(SCREEN_WIDTH*0.75), (int)(SCREEN_HEIGHT*0.15));
        TextureRegionDrawable instructionsButtonDrawableUp = new TextureRegionDrawable(instructionsButtonTextureRegionUp);

        Texture instructionsButtonTextureDown = new Texture(Gdx.files.internal("genericButtonDown.png"));
        TextureRegion instructionsButtonTextureRegionDown = new TextureRegion(instructionsButtonTextureDown);
        setupTextureRegion(instructionsButtonTextureRegionDown, (int)(SCREEN_WIDTH*0.75), (int)(SCREEN_HEIGHT*0.15));
        TextureRegionDrawable instructionsButtonDrawableDown = new TextureRegionDrawable(instructionsButtonTextureRegionDown);

        instructionsButton = new ImageButton(instructionsButtonDrawableUp, instructionsButtonDrawableDown);
        instructionsButton.setPosition(SCREEN_WIDTH/2, SCREEN_HEIGHT*4.55f/9, 1);
    }

    private void setUpCreditsButton(){
        Texture creditsButtonTextureUp = new Texture(Gdx.files.internal("genericButtonUp.png"));
        TextureRegion creditsButtonTextureRegionUp = new TextureRegion(creditsButtonTextureUp);
        setupTextureRegion(creditsButtonTextureRegionUp, (int)(SCREEN_WIDTH*0.75), (int)(SCREEN_HEIGHT*0.15));
        TextureRegionDrawable creditsButtonDrawableUp = new TextureRegionDrawable(creditsButtonTextureRegionUp);

        Texture creditsButtonTextureDown = new Texture(Gdx.files.internal("genericButtonDown.png"));
        TextureRegion creditsButtonTextureRegionDown = new TextureRegion(creditsButtonTextureDown);
        setupTextureRegion(creditsButtonTextureRegionDown, (int)(SCREEN_WIDTH*0.75), (int)(SCREEN_HEIGHT*0.15));
        TextureRegionDrawable creditsButtonDrawableDown = new TextureRegionDrawable(creditsButtonTextureRegionDown);

        creditsButton = new ImageButton(creditsButtonDrawableUp, creditsButtonDrawableDown);
        creditsButton.setPosition(SCREEN_WIDTH/2, SCREEN_HEIGHT*2.85f/9, 1);
    }

    private void setUpExitButton(){
        Texture exitButtonTextureUp = new Texture(Gdx.files.internal("genericButtonUp.png"));
        TextureRegion exitButtonTextureRegionUp = new TextureRegion(exitButtonTextureUp);
        setupTextureRegion(exitButtonTextureRegionUp, (int)(SCREEN_WIDTH*0.75), (int)(SCREEN_HEIGHT*0.15));
        TextureRegionDrawable exitButtonDrawableUp = new TextureRegionDrawable(exitButtonTextureRegionUp);

        Texture exitButtonTextureDown = new Texture(Gdx.files.internal("genericButtonDown.png"));
        TextureRegion exitButtonTextureRegionDown = new TextureRegion(exitButtonTextureDown);
        setupTextureRegion(exitButtonTextureRegionDown, (int)(SCREEN_WIDTH*0.75), (int)(SCREEN_HEIGHT*0.15));
        TextureRegionDrawable exitButtonDrawableDown = new TextureRegionDrawable(exitButtonTextureRegionDown);

        exitButton = new ImageButton(exitButtonDrawableUp, exitButtonDrawableDown);
        exitButton.setPosition(SCREEN_WIDTH/2, SCREEN_HEIGHT*1.15f/9, 1);
    }

    private void setUpStage(){
        stage = new Stage();
        stage.addActor(backgroundImage);
        stage.addActor(playButton);
        stage.addActor(instructionsButton);
        stage.addActor(creditsButton);
        stage.addActor(exitButton);
    }

    public void handleInputs() {
        if (playButton.isChecked()) {
            game.activateMenu(MenuFactory.makeMenu(game, TYPE.PLAY));
        }
        if(instructionsButton.isChecked()) {
            game.activateMenu(MenuFactory.makeMenu(game, TYPE.INSTRUCTIONS));
        }
        if(creditsButton.isChecked()) {
            game.activateMenu(MenuFactory.makeMenu(game, TYPE.CREDITS));
        }
        if (exitButton.isPressed()) {
            Gdx.app.exit();
        }
    }

}