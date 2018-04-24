package com.mygdx.elmaze.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.elmaze.ELMaze;

public class ServerConnectionView extends MenuView {

    // Background
    private Image backgroundImage;
    private ImageButton exitButton;

    // Symbol Buttons
    private ImageButton alfaButton;
    private ImageButton betaButton;
    private ImageButton chiButton;
    private ImageButton deltaButton;
    private ImageButton epsilonButton;
    private ImageButton etaButton;
    private ImageButton gamaButton;
    private ImageButton lambdaButton;
    private ImageButton muButton;
    private ImageButton omegaButton;
    private ImageButton phiButton;
    private ImageButton piButton;
    private ImageButton psiButton;
    private ImageButton rhoButton;
    private ImageButton sigmaButton;
    private ImageButton tauButton;

    public ServerConnectionView(ELMaze game) {
        super(game, TYPE.CONNECTION);
        setUpBackground();
        //setUpTextTable();   // To show the code the user is writing
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
        setupTextureRegion(exitButtonTextureRegionUp, (int)(SCREEN_WIDTH*0.75), (int)(SCREEN_HEIGHT*0.15));
        TextureRegionDrawable exitButtonDrawableUp = new TextureRegionDrawable(exitButtonTextureRegionUp);

        Texture exitButtonTextureDown = new Texture(Gdx.files.internal("genericButtonDown.png"));
        TextureRegion exitButtonTextureRegionDown = new TextureRegion(exitButtonTextureDown);
        setupTextureRegion(exitButtonTextureRegionDown, (int)(SCREEN_WIDTH*0.75), (int)(SCREEN_HEIGHT*0.15));
        TextureRegionDrawable exitButtonDrawableDown = new TextureRegionDrawable(exitButtonTextureRegionDown);

        exitButton = new ImageButton(exitButtonDrawableUp, exitButtonDrawableDown);
        exitButton.setPosition(SCREEN_WIDTH/2, SCREEN_HEIGHT*1.15f/9, 1);
    }

    private void setUpAlfaButton(){
        Texture alfaButtonTextureUp = new Texture(Gdx.files.internal("alfaButtonUp.png"));
        TextureRegion alfaButtonTextureRegionUp = new TextureRegion(alfaButtonTextureUp);
        setupTextureRegion(alfaButtonTextureRegionUp, (int)(SCREEN_WIDTH*0.75), (int)(SCREEN_HEIGHT*0.15));
        TextureRegionDrawable alfaButtonDrawableUp = new TextureRegionDrawable(alfaButtonTextureRegionUp);

        Texture alfaButtonTextureDown = new Texture(Gdx.files.internal("alfaButtonDown.png"));
        TextureRegion alfaButtonTextureRegionDown = new TextureRegion(alfaButtonTextureDown);
        setupTextureRegion(alfaButtonTextureRegionDown, (int)(SCREEN_WIDTH*0.75), (int)(SCREEN_HEIGHT*0.15));
        TextureRegionDrawable alfaButtonDrawableDown = new TextureRegionDrawable(alfaButtonTextureRegionDown);

        alfaButton = new ImageButton(alfaButtonDrawableUp, alfaButtonDrawableDown);
        alfaButton.setPosition(SCREEN_WIDTH/2, SCREEN_HEIGHT*1.15f/9, 1);
    }

    private void setUpBetaButton(){
        Texture betaButtonTextureUp = new Texture(Gdx.files.internal("betaButtonUp.png"));
        TextureRegion betaButtonTextureRegionUp = new TextureRegion(betaButtonTextureUp);
        setupTextureRegion(betaButtonTextureRegionUp, (int)(SCREEN_WIDTH*0.75), (int)(SCREEN_HEIGHT*0.15));
        TextureRegionDrawable betaButtonDrawableUp = new TextureRegionDrawable(betaButtonTextureRegionUp);

        Texture betaButtonTextureDown = new Texture(Gdx.files.internal("betaButtonDown.png"));
        TextureRegion betaButtonTextureRegionDown = new TextureRegion(betaButtonTextureDown);
        setupTextureRegion(betaButtonTextureRegionDown, (int)(SCREEN_WIDTH*0.75), (int)(SCREEN_HEIGHT*0.15));
        TextureRegionDrawable betaButtonDrawableDown = new TextureRegionDrawable(betaButtonTextureRegionDown);

        betaButton = new ImageButton(betaButtonDrawableUp, betaButtonDrawableDown);
        betaButton.setPosition(SCREEN_WIDTH/2, SCREEN_HEIGHT*1.15f/9, 1);
    }

    private void setUpChiButton(){
        Texture chiButtonTextureUp = new Texture(Gdx.files.internal("chiButtonUp.png"));
        TextureRegion chiButtonTextureRegionUp = new TextureRegion(chiButtonTextureUp);
        setupTextureRegion(chiButtonTextureRegionUp, (int)(SCREEN_WIDTH*0.75), (int)(SCREEN_HEIGHT*0.15));
        TextureRegionDrawable chiButtonDrawableUp = new TextureRegionDrawable(chiButtonTextureRegionUp);

        Texture chiButtonTextureDown = new Texture(Gdx.files.internal("chiButtonDown.png"));
        TextureRegion chiButtonTextureRegionDown = new TextureRegion(chiButtonTextureDown);
        setupTextureRegion(chiButtonTextureRegionDown, (int)(SCREEN_WIDTH*0.75), (int)(SCREEN_HEIGHT*0.15));
        TextureRegionDrawable chiButtonDrawableDown = new TextureRegionDrawable(chiButtonTextureRegionDown);

        chiButton = new ImageButton(chiButtonDrawableUp, chiButtonDrawableDown);
        chiButton.setPosition(SCREEN_WIDTH/2, SCREEN_HEIGHT*1.15f/9, 1);
    }

    private void setUpDeltaButton(){
        Texture deltaButtonTextureUp = new Texture(Gdx.files.internal("deltaButtonUp.png"));
        TextureRegion deltaButtonTextureRegionUp = new TextureRegion(deltaButtonTextureUp);
        setupTextureRegion(deltaButtonTextureRegionUp, (int)(SCREEN_WIDTH*0.75), (int)(SCREEN_HEIGHT*0.15));
        TextureRegionDrawable deltaButtonDrawableUp = new TextureRegionDrawable(deltaButtonTextureRegionUp);

        Texture deltaButtonTextureDown = new Texture(Gdx.files.internal("deltaButtonDown.png"));
        TextureRegion deltaButtonTextureRegionDown = new TextureRegion(deltaButtonTextureDown);
        setupTextureRegion(deltaButtonTextureRegionDown, (int)(SCREEN_WIDTH*0.75), (int)(SCREEN_HEIGHT*0.15));
        TextureRegionDrawable deltaButtonDrawableDown = new TextureRegionDrawable(deltaButtonTextureRegionDown);

        deltaButton = new ImageButton(deltaButtonDrawableUp, deltaButtonDrawableDown);
        deltaButton.setPosition(SCREEN_WIDTH/2, SCREEN_HEIGHT*1.15f/9, 1);
    }

    private void setUpKeyboard(){
        setUpAlfaButton();
        setUpBetaButton();
        setUpChiButton();
        setUpDeltaButton();
    }

    private void addKeyboardToStage(){
        stage.addActor(alfaButton);
        stage.addActor(betaButton);
        stage.addActor(chiButton);
        stage.addActor(deltaButton);
    }

    private void setUpStage(){
        stage = new Stage();
        stage.addActor(backgroundImage);
        setUpKeyboard();
        addKeyboardToStage();
        //stage.addActor(textTableImage);
        stage.addActor(exitButton);
    }

}
