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
        setupButtons();
        setupStage();
    }

    @Override
    public void render(float delta) {
        stage.act(delta); //Perform ui logic
        stage.draw(); //Draw the UI

        handleInputs();
    }

    private void setupButtons() {
        exitButton = ButtonFactory.makeImageButton( "genericButtonUp.png","genericButtonDown.png",SCREEN_WIDTH/2,
                SCREEN_HEIGHT*1.15f/9, (int)(SCREEN_WIDTH*0.75), (int)(SCREEN_HEIGHT*0.15));
        creditsButton = ButtonFactory.makeImageButton( "genericButtonUp.png","genericButtonDown.png",SCREEN_WIDTH/2,
                SCREEN_HEIGHT*2.85f/9, (int)(SCREEN_WIDTH*0.75), (int)(SCREEN_HEIGHT*0.15));
        instructionsButton = ButtonFactory.makeImageButton( "genericButtonUp.png","genericButtonDown.png",SCREEN_WIDTH/2,
                SCREEN_HEIGHT*4.55f/9, (int)(SCREEN_WIDTH*0.75), (int)(SCREEN_HEIGHT*0.15));
        playButton = ButtonFactory.makeImageButton( "genericButtonUp.png","genericButtonDown.png",SCREEN_WIDTH/2,
                SCREEN_HEIGHT*6.25f/9, (int)(SCREEN_WIDTH*0.75), (int)(SCREEN_HEIGHT*0.15));
    }

    private void setupStage() {
        stage.addActor(playButton);
        stage.addActor(instructionsButton);
        stage.addActor(creditsButton);
        stage.addActor(exitButton);
    }

    public void handleInputs() {
        if (playButton.isChecked()) {
            game.activateMenu(MenuFactory.makeMenu(game, TYPE.CONNECTION));
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