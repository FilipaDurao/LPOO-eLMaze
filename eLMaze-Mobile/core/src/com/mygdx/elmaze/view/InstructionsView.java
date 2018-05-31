package com.mygdx.elmaze.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.elmaze.ELMaze;

/**
 * Represents the Instructions pages view
 */
public class InstructionsView extends MenuView {

    private Image instructionsTable;
    private Button exitButton;

    /**
     * Creates the Instructions menu
     *
     * @param game Reference to the Game object
     */
    public InstructionsView(ELMaze game) {
        super(game, TYPE.INSTRUCTIONS);

        loadAssets();
        setupExitButton();
        setupStage();
    }

    /**
     * Renders the menu on the screen
     *
     * @param delta Time since last render
     */
    @Override
    public void render(float delta) {
        stage.act(delta);
        stage.draw();
    }

    /**
     * Sets up the characteristics of the Exit Button
     */
    private void setupExitButton() {
        exitButton = ButtonFactory.makeButton(game,"backButtonUp.png","backButtonDown.png",SCREEN_WIDTH/2,
                SCREEN_HEIGHT*1.15f/9, (int)(SCREEN_WIDTH*0.75), (int)(SCREEN_HEIGHT*0.13));

        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                playButtonSound();
                game.activateMenu(MenuFactory.makeMenu(game, TYPE.MAIN));
            }
        });
    }

    /**
     * Sets up the Stage
     */
    private void setupStage(){
        instructionsTable = ImageFactory.makeImage(game,"instructionsTable.png", SCREEN_WIDTH/2, SCREEN_HEIGHT*6/10,SCREEN_WIDTH*90/100);

        stage.addActor(instructionsTable);
        stage.addActor(exitButton);
    }

    /**
     * Loads all assets needed for the menu
     */
    protected void loadAssets() {
        this.game.getAssetManager().load("instructionsTable.png", Texture.class);
        this.game.getAssetManager().load("backButtonUp.png" , Texture.class);
        this.game.getAssetManager().load("backButtonDown.png" , Texture.class);
        this.game.getAssetManager().finishLoading();
    }

}
