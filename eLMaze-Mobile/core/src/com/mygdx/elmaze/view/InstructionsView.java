package com.mygdx.elmaze.view;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.mygdx.elmaze.ELMaze;

public class InstructionsView extends MenuView {

    // Background
    private Button exitButton;

    public InstructionsView(ELMaze game) {
        super(game, TYPE.INSTRUCTIONS);

        exitButton = ButtonFactory.makeButton( "exitButtonUp.png","exitButtonDown.png",SCREEN_WIDTH/2,
                SCREEN_HEIGHT*1.15f/9, (int)(SCREEN_WIDTH*0.75), (int)(SCREEN_HEIGHT*0.13));

        setupStage();
    }

    @Override
    public void render(float delta) {
        stage.act(delta); //Perform ui logic
        stage.draw(); //Draw the UI

        handleInputs();
    }

    protected void handleInputs(){
        if (exitButton.isChecked()) {
            game.activateMenu(MenuFactory.makeMenu(game, TYPE.MAIN));
        }
    }

    private void setupStage(){
        stage.addActor(exitButton);
    }

}
