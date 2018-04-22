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

    private Stage stage;

    private Texture backgroundTexture;
    private Image backgroundImage;

    private Texture playButtonTextureUp;
    private TextureRegion playButtonTextureRegionUp;
    private TextureRegionDrawable playButtonDrawableUp;

    private Texture playButtonTextureDown;
    private TextureRegion playButtonTextureRegionDown;
    private TextureRegionDrawable playButtonDrawableDown;

    private ImageButton singlePlayerButton;

    public MainMenuView() {
        setUpBackground();
        setUpSinglePlayerButton();
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

    private void setUpSinglePlayerButton(){
        playButtonTextureUp = new Texture(Gdx.files.internal("genericButtonUp.png"));
        playButtonTextureRegionUp = new TextureRegion(playButtonTextureUp);
        playButtonDrawableUp = new TextureRegionDrawable(playButtonTextureRegionUp);

        playButtonTextureDown = new Texture(Gdx.files.internal("genericButtonDown.png"));
        playButtonTextureRegionDown = new TextureRegion(playButtonTextureDown);
        playButtonDrawableDown = new TextureRegionDrawable(playButtonTextureRegionDown);

        singlePlayerButton = new ImageButton(playButtonDrawableUp, playButtonDrawableDown);
        singlePlayerButton.setPosition(0, 0, 12);
    }

    private void setUpStage(){
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        stage.addActor(backgroundImage);
        stage.addActor(singlePlayerButton);
    }

}