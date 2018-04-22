package com.mygdx.elmaze.view;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.scenes.scene2d.ui.Image;


public class MainMenuView extends ApplicationAdapter{

    private int SCREEN_WIDTH = 720; //TODO verificar

    private Stage stage;

    // Necessary for Background
    private Texture backgroundTexture;
    private Image backgroundImage;

    // Necessary for Play Button
    private Texture playButtonTextureUp;
    private TextureRegion playButtonTextureRegionUp;
    private TextureRegionDrawable playButtonDrawableUp;
    private Texture playButtonTextureDown;
    private TextureRegion playButtonTextureRegionDown;
    private TextureRegionDrawable playButtonDrawableDown;
    private ImageButton playButton;

    // Necessary for Instructions Button
    private Texture instructionsButtonTextureUp;
    private TextureRegion instructionsButtonTextureRegionUp;
    private TextureRegionDrawable instructionsButtonDrawableUp;
    private Texture instructionsButtonTextureDown;
    private TextureRegion instructionsButtonTextureRegionDown;
    private TextureRegionDrawable instructionsButtonDrawableDown;
    private ImageButton instructionsButton;

    // Necessary for Credits Button
    private Texture creditsButtonTextureUp;
    private TextureRegion creditsButtonTextureRegionUp;
    private TextureRegionDrawable creditsButtonDrawableUp;
    private Texture creditsButtonTextureDown;
    private TextureRegion creditsButtonTextureRegionDown;
    private TextureRegionDrawable creditsButtonDrawableDown;
    private ImageButton creditsButton;

    // Necessary for Exit Button
    private Texture exitButtonTextureUp;
    private TextureRegion exitButtonTextureRegionUp;
    private TextureRegionDrawable exitButtonDrawableUp;
    private Texture exitButtonTextureDown;
    private TextureRegion exitButtonTextureRegionDown;
    private TextureRegionDrawable exitButtonDrawableDown;
    private ImageButton exitButton;

    public MainMenuView() {
        setUpBackground();
        setUpPlayButton();
        setUpInstructionsButton();
        setUpCreditsButton();
        setUpExitButton();
        setUpStage();
    }

    public void render() {
        stage.act(Gdx.graphics.getDeltaTime()); //Perform ui logic
        stage.draw(); //Draw the ui
    }

    private void setUpBackground(){
        backgroundTexture = new Texture("background.png");
        backgroundImage = new Image(backgroundTexture);
        backgroundImage.setDrawable(new TextureRegionDrawable(new TextureRegion(backgroundTexture)));
        backgroundImage.setSize(backgroundTexture.getWidth(), backgroundTexture.getHeight());
    }

    private void setUpPlayButton(){
        playButtonTextureUp = new Texture(Gdx.files.internal("genericButtonUp.png"));
        playButtonTextureRegionUp = new TextureRegion(playButtonTextureUp);
        playButtonDrawableUp = new TextureRegionDrawable(playButtonTextureRegionUp);

        playButtonTextureDown = new Texture(Gdx.files.internal("genericButtonDown.png"));
        playButtonTextureRegionDown = new TextureRegion(playButtonTextureDown);
        playButtonDrawableDown = new TextureRegionDrawable(playButtonTextureRegionDown);

        playButton = new ImageButton(playButtonDrawableUp, playButtonDrawableDown);
        playButton.setPosition(SCREEN_WIDTH/2, 800, 1);
    }

    private void setUpInstructionsButton(){
        instructionsButtonTextureUp = new Texture(Gdx.files.internal("genericButtonUp.png"));
        instructionsButtonTextureRegionUp = new TextureRegion(instructionsButtonTextureUp);
        instructionsButtonDrawableUp = new TextureRegionDrawable(instructionsButtonTextureRegionUp);

        instructionsButtonTextureDown = new Texture(Gdx.files.internal("genericButtonDown.png"));
        instructionsButtonTextureRegionDown = new TextureRegion(instructionsButtonTextureDown);
        instructionsButtonDrawableDown = new TextureRegionDrawable(instructionsButtonTextureRegionDown);

        instructionsButton = new ImageButton(instructionsButtonDrawableUp, instructionsButtonDrawableDown);
        instructionsButton.setPosition(SCREEN_WIDTH/2, 600, 1);
    }

    private void setUpCreditsButton(){
        creditsButtonTextureUp = new Texture(Gdx.files.internal("genericButtonUp.png"));
        creditsButtonTextureRegionUp = new TextureRegion(creditsButtonTextureUp);
        creditsButtonDrawableUp = new TextureRegionDrawable(creditsButtonTextureRegionUp);

        creditsButtonTextureDown = new Texture(Gdx.files.internal("genericButtonDown.png"));
        creditsButtonTextureRegionDown = new TextureRegion(creditsButtonTextureDown);
        creditsButtonDrawableDown = new TextureRegionDrawable(creditsButtonTextureRegionDown);

        creditsButton = new ImageButton(creditsButtonDrawableUp, creditsButtonDrawableDown);
        creditsButton.setPosition(SCREEN_WIDTH/2, 400, 1);
    }

    private void setUpExitButton(){
        exitButtonTextureUp = new Texture(Gdx.files.internal("genericButtonUp.png"));
        exitButtonTextureRegionUp = new TextureRegion(exitButtonTextureUp);
        exitButtonDrawableUp = new TextureRegionDrawable(exitButtonTextureRegionUp);

        exitButtonTextureDown = new Texture(Gdx.files.internal("genericButtonDown.png"));
        exitButtonTextureRegionDown = new TextureRegion(exitButtonTextureDown);
        exitButtonDrawableDown = new TextureRegionDrawable(exitButtonTextureRegionDown);

        exitButton = new ImageButton(exitButtonDrawableUp, exitButtonDrawableDown);
        exitButton.setPosition(SCREEN_WIDTH/2, 200, 1);
    }

    private void setUpStage(){
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        stage.addActor(backgroundImage);
        stage.addActor(playButton);
        stage.addActor(instructionsButton);
        stage.addActor(creditsButton);
        stage.addActor(exitButton);
    }

}