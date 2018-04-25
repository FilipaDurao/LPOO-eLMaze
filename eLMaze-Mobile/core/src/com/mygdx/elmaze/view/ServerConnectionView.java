package com.mygdx.elmaze.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.elmaze.ELMaze;

import java.util.ArrayList;

public class ServerConnectionView extends MenuView {

    // Background
    private ImageButton startButton;
    private ImageButton exitButton;

    // Symbol Buttons
    private ArrayList<ImageButton> keypadButtons = new ArrayList<ImageButton>();

    public ServerConnectionView(ELMaze game) {
        super(game, TYPE.CONNECTION);
        //setUpTextTable();   // To show the code the user is writing

        setupButtons();
        setupStage();
    }

    @Override
    public void render(float delta) {
        stage.act(delta); //Perform ui logic
        stage.draw(); //Draw the UI

        handleInputs();
    }

    private void setupButtons(){
        int buttonSize = (int)(SCREEN_WIDTH*0.15);
        exitButton = ButtonFactory.makeImageButton( "genericButtonUp.png","genericButtonDown.png",SCREEN_WIDTH*1/4,SCREEN_HEIGHT*1/9, (int)(SCREEN_WIDTH*0.4), (int)(SCREEN_WIDTH*0.18));
        startButton = ButtonFactory.makeImageButton( "genericButtonUp.png","genericButtonDown.png",SCREEN_WIDTH*3/4,SCREEN_HEIGHT*1/9, (int)(SCREEN_WIDTH*0.4), (int)(SCREEN_WIDTH*0.18));
        keypadButtons.add(ButtonFactory.makeImageButton( "alphaButtonUp.png","alphaButtonDown.png",SCREEN_WIDTH*1/5,SCREEN_HEIGHT*6/8, buttonSize, buttonSize));
        keypadButtons.add(ButtonFactory.makeImageButton( "betaButtonUp.png","betaButtonDown.png",SCREEN_WIDTH*2/5,SCREEN_HEIGHT*6/8, buttonSize, buttonSize));
        keypadButtons.add(ButtonFactory.makeImageButton( "chiButtonUp.png","chiButtonDown.png",SCREEN_WIDTH*3/5,SCREEN_HEIGHT*6/8, buttonSize, buttonSize));
        keypadButtons.add(ButtonFactory.makeImageButton( "deltaButtonUp.png","deltaButtonDown.png",SCREEN_WIDTH*4/5,SCREEN_HEIGHT*6/8, buttonSize, buttonSize));
        keypadButtons.add(ButtonFactory.makeImageButton( "epsilonButtonUp.png","epsilonButtonDown.png",SCREEN_WIDTH*1/5,SCREEN_HEIGHT*5/8, buttonSize, buttonSize));
        keypadButtons.add(ButtonFactory.makeImageButton( "etaButtonUp.png","etaButtonDown.png",SCREEN_WIDTH*2/5,SCREEN_HEIGHT*5/8, buttonSize, buttonSize));
        keypadButtons.add(ButtonFactory.makeImageButton( "gamaButtonUp.png","gamaButtonDown.png",SCREEN_WIDTH*3/5,SCREEN_HEIGHT*5/8, buttonSize, buttonSize));
        keypadButtons.add(ButtonFactory.makeImageButton( "lambdaButtonUp.png","lambdaButtonDown.png",SCREEN_WIDTH*4/5,SCREEN_HEIGHT*5/8, buttonSize, buttonSize));
        keypadButtons.add(ButtonFactory.makeImageButton( "muButtonUp.png","muButtonDown.png",SCREEN_WIDTH*1/5,SCREEN_HEIGHT*4/8, buttonSize, buttonSize));
        keypadButtons.add(ButtonFactory.makeImageButton( "omegaButtonUp.png","omegaButtonDown.png",SCREEN_WIDTH*2/5,SCREEN_HEIGHT*4/8, buttonSize, buttonSize));
        keypadButtons.add(ButtonFactory.makeImageButton( "phiButtonUp.png","phiButtonDown.png",SCREEN_WIDTH*3/5,SCREEN_HEIGHT*4/8, buttonSize, buttonSize));
        keypadButtons.add(ButtonFactory.makeImageButton( "piButtonUp.png","piButtonDown.png",SCREEN_WIDTH*4/5,SCREEN_HEIGHT*4/8, buttonSize, buttonSize));
        keypadButtons.add(ButtonFactory.makeImageButton( "psiButtonUp.png","psiButtonDown.png",SCREEN_WIDTH*1/5,SCREEN_HEIGHT*3/8, buttonSize, buttonSize));
        keypadButtons.add(ButtonFactory.makeImageButton( "rhoButtonUp.png","rhoButtonDown.png",SCREEN_WIDTH*2/5,SCREEN_HEIGHT*3/8, buttonSize, buttonSize));
        keypadButtons.add(ButtonFactory.makeImageButton( "sigmaButtonUp.png","sigmaButtonDown.png",SCREEN_WIDTH*3/5,SCREEN_HEIGHT*3/8, buttonSize, buttonSize));
        keypadButtons.add(ButtonFactory.makeImageButton( "tauButtonUp.png","tauButtonDown.png",SCREEN_WIDTH*4/5,SCREEN_HEIGHT*3/8, buttonSize, buttonSize));
    }

    private void setupStage(){
        stage.addActor(exitButton);
        stage.addActor(startButton);

        // Add Keypad Buttons
        for (ImageButton button : keypadButtons) {
            stage.addActor(button);
        }
    }

    public void handleInputs(){
        if (exitButton.isChecked()) {
            game.activateMenu(MenuFactory.makeMenu(game, TYPE.MAIN));
        }
        if (startButton.isChecked()) {
            game.activateMenu(MenuFactory.makeMenu(game, TYPE.PLAY));
        }

        // Keypad Buttons
        for (int i=0 ; i<keypadButtons.size() ; i++) {
            if (keypadButtons.get(i).isOver()) {
                System.out.println(i);
            }
        }
    }

}
