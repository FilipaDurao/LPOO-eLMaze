package com.mygdx.elmaze.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.elmaze.ELMaze;

public class CreditsView extends ScreenAdapter {

    private final ELMaze game;
    private final int SCREEN_WIDTH = Gdx.graphics.getWidth();
    private final int SCREEN_HEIGHT = Gdx.graphics.getHeight();

    private ImageButton exitButton;

    // Background
    private Image backgroundImage;

    // Text Table
    private Image textTableImage;

    private Stage stage;

    public CreditsView(ELMaze game) {
        this.game = game;
        setUpBackground();
        setUpTextTable();
        setUpExitButton();
        setUpStage();
    }

    @Override
    public void render(float delta) {
        stage.act(delta); //Perform ui logic
        stage.draw(); //Draw the UI

        handleInput();
    }

    public void handleInput(){
        if (exitButton.isChecked()) {
            game.setScreen(new MainMenuView(game));
        }
    }

    private void setUpBackground(){
        Texture backgroundTexture = new Texture("background.png");
        backgroundImage = new Image(backgroundTexture);
        backgroundImage.setDrawable(new TextureRegionDrawable(new TextureRegion(backgroundTexture)));
        backgroundImage.setSize(backgroundTexture.getWidth(), backgroundTexture.getHeight());
    }

    private void setUpTextTable(){
        Texture textTableTexture = new Texture("textTable.png");
        TextureRegion textTableTextureRegion = new TextureRegion(textTableTexture);
        setupTextureRegion(textTableTextureRegion, (int)(SCREEN_WIDTH*0.8), (int)(SCREEN_HEIGHT*0.6));
        textTableImage = new Image(textTableTexture);
        textTableImage.setDrawable(new TextureRegionDrawable(textTableTextureRegion));
        textTableImage.setPosition(SCREEN_WIDTH/2, SCREEN_HEIGHT*8/9, 1);
    }

    private void setupTextureRegion(TextureRegion textureRegion, int width, int height) {
        textureRegion.getTexture().setWrap(Texture.TextureWrap.MirroredRepeat, Texture.TextureWrap.MirroredRepeat);
        textureRegion.setRegionHeight(height);
        textureRegion.setRegionWidth(width);
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
        stage.addActor(textTableImage);
        stage.addActor(exitButton);
        Gdx.input.setInputProcessor(stage);
    }

}
