package com.mygdx.elmaze.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.elmaze.ELMaze;

public class InstructionsView extends MenuView {

    // Background
    private Image backgroundImage;
    private ImageButton exitButton;

    public InstructionsView(ELMaze game) {
        super(game, TYPE.INSTRUCTIONS);
        setUpBackground();
        setUpExitButton();
        setUpStage();
    }

    @Override
    public void render(float delta) {
        stage.act(delta); //Perform ui logic
        stage.draw(); //Draw the UI

        handleInputs();
    }

    public void handleInputs(){
        if (exitButton.isChecked()) {
            exitButton.setDisabled(true);
            game.activateMenu(MenuFactory.makeMenu(game, TYPE.MAIN));
        }
    }

    private void setUpBackground(){
        Texture backgroundTexture = new Texture("background.png");
        backgroundImage = new Image(backgroundTexture);
        backgroundImage.setDrawable(new TextureRegionDrawable(new TextureRegion(backgroundTexture)));
        backgroundImage.setSize(backgroundTexture.getWidth(), backgroundTexture.getHeight());
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
        stage.addActor(exitButton);
    }

}
