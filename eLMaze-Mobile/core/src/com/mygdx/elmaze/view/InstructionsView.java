package com.mygdx.elmaze.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.elmaze.ELMaze;

public class InstructionsView extends MenuView {

    // Background
    private Image instructionsTable;
    private Button exitButton;

    public InstructionsView(ELMaze game) {
        super(game, TYPE.INSTRUCTIONS);

        loadAssets();
        setupExitButton();
        setupStage();
    }

    @Override
    public void render(float delta) {
        stage.act(delta); //Perform ui logic
        stage.draw(); //Draw the UI
    }

    private void setupExitButton() {
        exitButton = ButtonFactory.makeButton(game,"backButtonUp.png","backButtonDown.png",SCREEN_WIDTH/2,
                SCREEN_HEIGHT*1.15f/9, (int)(SCREEN_WIDTH*0.75), (int)(SCREEN_HEIGHT*0.13));

        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.activateMenu(MenuFactory.makeMenu(game, TYPE.MAIN));
            }
        });
    }

    private void setupStage(){
        instructionsTable = ImageFactory.makeImage(game,"instructionsTable.png", SCREEN_WIDTH/2, SCREEN_HEIGHT*6/10,SCREEN_WIDTH*90/100);

        stage.addActor(instructionsTable);
        stage.addActor(exitButton);
    }

    protected void loadAssets() {
        this.game.getAssetManager().load("instructionsTable.png", Texture.class);
        this.game.getAssetManager().load("backButtonUp.png" , Texture.class);
        this.game.getAssetManager().load("backButtonDown.png" , Texture.class);
        this.game.getAssetManager().finishLoading();
    }

}
