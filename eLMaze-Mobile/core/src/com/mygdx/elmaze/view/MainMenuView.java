package com.mygdx.elmaze.view;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.elmaze.ELMaze;


public class MainMenuView extends ScreenAdapter {

    private final int SCREEN_WIDTH = Gdx.graphics.getWidth();
    private final int SCREEN_HEIGHT = Gdx.graphics.getHeight();

    private final ELMaze game;
    private Stage stage;

    // Background
    private Image backgroundImage;

    // Buttons
    private ImageButton playButton;
    private ImageButton instructionsButton;
    private ImageButton creditsButton;
    private ImageButton exitButton;

    public MainMenuView(ELMaze game) {
        this.game = game;
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
        setupTextureRegion(playButtonTextureRegionUp);
        TextureRegionDrawable playButtonDrawableUp = new TextureRegionDrawable(playButtonTextureRegionUp);

        Texture playButtonTextureDown = new Texture(Gdx.files.internal("genericButtonDown.png"));
        TextureRegion playButtonTextureRegionDown = new TextureRegion(playButtonTextureDown);
        setupTextureRegion(playButtonTextureRegionDown);
        TextureRegionDrawable playButtonDrawableDown = new TextureRegionDrawable(playButtonTextureRegionDown);

        playButton = new ImageButton(playButtonDrawableUp, playButtonDrawableDown);
        playButton.setPosition(SCREEN_WIDTH/2, SCREEN_HEIGHT*6.25f/9, 1);
    }

    private void setUpInstructionsButton(){
        Texture instructionsButtonTextureUp = new Texture(Gdx.files.internal("genericButtonUp.png"));
        TextureRegion instructionsButtonTextureRegionUp = new TextureRegion(instructionsButtonTextureUp);
        setupTextureRegion(instructionsButtonTextureRegionUp);
        TextureRegionDrawable instructionsButtonDrawableUp = new TextureRegionDrawable(instructionsButtonTextureRegionUp);

        Texture instructionsButtonTextureDown = new Texture(Gdx.files.internal("genericButtonDown.png"));
        TextureRegion instructionsButtonTextureRegionDown = new TextureRegion(instructionsButtonTextureDown);
        setupTextureRegion(instructionsButtonTextureRegionDown);
        TextureRegionDrawable instructionsButtonDrawableDown = new TextureRegionDrawable(instructionsButtonTextureRegionDown);

        instructionsButton = new ImageButton(instructionsButtonDrawableUp, instructionsButtonDrawableDown);
        instructionsButton.setPosition(SCREEN_WIDTH/2, SCREEN_HEIGHT*4.55f/9, 1);
    }

    private void setUpCreditsButton(){
        Texture creditsButtonTextureUp = new Texture(Gdx.files.internal("genericButtonUp.png"));
        TextureRegion creditsButtonTextureRegionUp = new TextureRegion(creditsButtonTextureUp);
        setupTextureRegion(creditsButtonTextureRegionUp);
        TextureRegionDrawable creditsButtonDrawableUp = new TextureRegionDrawable(creditsButtonTextureRegionUp);

        Texture creditsButtonTextureDown = new Texture(Gdx.files.internal("genericButtonDown.png"));
        TextureRegion creditsButtonTextureRegionDown = new TextureRegion(creditsButtonTextureDown);
        setupTextureRegion(creditsButtonTextureRegionDown);
        TextureRegionDrawable creditsButtonDrawableDown = new TextureRegionDrawable(creditsButtonTextureRegionDown);

        creditsButton = new ImageButton(creditsButtonDrawableUp, creditsButtonDrawableDown);
        creditsButton.setPosition(SCREEN_WIDTH/2, SCREEN_HEIGHT*2.85f/9, 1);
    }

    private void setUpExitButton(){
        Texture exitButtonTextureUp = new Texture(Gdx.files.internal("genericButtonUp.png"));
        TextureRegion exitButtonTextureRegionUp = new TextureRegion(exitButtonTextureUp);
        setupTextureRegion(exitButtonTextureRegionUp);
        TextureRegionDrawable exitButtonDrawableUp = new TextureRegionDrawable(exitButtonTextureRegionUp);

        Texture exitButtonTextureDown = new Texture(Gdx.files.internal("genericButtonDown.png"));
        TextureRegion exitButtonTextureRegionDown = new TextureRegion(exitButtonTextureDown);
        setupTextureRegion(exitButtonTextureRegionDown);
        TextureRegionDrawable exitButtonDrawableDown = new TextureRegionDrawable(exitButtonTextureRegionDown);

        exitButton = new ImageButton(exitButtonDrawableUp, exitButtonDrawableDown);
        exitButton.setPosition(SCREEN_WIDTH/2, SCREEN_HEIGHT*1.15f/9, 1);
    }

    private void setupTextureRegion(TextureRegion textureRegion) {
        textureRegion.getTexture().setWrap(Texture.TextureWrap.MirroredRepeat, Texture.TextureWrap.MirroredRepeat);
        textureRegion.setRegionHeight((int)(SCREEN_HEIGHT*0.15));
        textureRegion.setRegionWidth((int)(SCREEN_WIDTH*0.75));
    }

    private void setUpStage(){
        stage = new Stage();
        stage.addActor(backgroundImage);
        stage.addActor(playButton);
        stage.addActor(instructionsButton);
        stage.addActor(creditsButton);
        stage.addActor(exitButton);
        Gdx.input.setInputProcessor(stage);
    }

    public void handleInputs() {
        if (playButton.isChecked()) {
            game.setScreen(new PlayGameView(game));
        }
        if(instructionsButton.isChecked()){
            game.setScreen(new InstructionsView(game));
        }
        if(creditsButton.isChecked()){
            game.setScreen(new CreditsView(game));
        }
        if (exitButton.isChecked()) {
            Gdx.app.exit();
        }
    }

}