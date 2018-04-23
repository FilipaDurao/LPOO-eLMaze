package com.mygdx.elmaze.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.elmaze.ELMaze;

public class CreditsView extends MenuView {

    // Background
    private Image backgroundImage;

    // Text Table
    private Image textTableImage;
    private ImageButton exitButton;

    public CreditsView(ELMaze game) {
        super(game, TYPE.CREDITS);
        setUpBackground();
        setUpTextTable();
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

    private void setUpTextTable(){
        Texture textTableTexture = new Texture("textTable.png");
        TextureRegion textTableTextureRegion = new TextureRegion(textTableTexture);
        setupTextureRegion(textTableTextureRegion, (int)(SCREEN_WIDTH*0.75), (int)(SCREEN_HEIGHT*0.60));
        textTableImage = new Image(textTableTextureRegion);
        textTableImage.setPosition(SCREEN_WIDTH/2, SCREEN_HEIGHT*3/5, 1);
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
    }

}
