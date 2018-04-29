package com.mygdx.elmaze.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.elmaze.ELMaze;

public class CreditsView extends MenuView {

    // Text Table
    private Image textTableImage;
    private Button exitButton;

    public CreditsView(ELMaze game) {
        super(game, TYPE.CREDITS);
        setupTextTable();

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

    private void setupTextTable(){
        Texture texture = ImageFactory.makeSizedTexture("creditsTable.png", SCREEN_WIDTH*82/100);
        textTableImage = new Image(texture);
        textTableImage.setDrawable(new TextureRegionDrawable(new TextureRegion(texture)));
        textTableImage.setPosition(SCREEN_WIDTH/2, SCREEN_HEIGHT*8f/9, 1);
    }

    private void setupStage(){
        stage.addActor(textTableImage);
        stage.addActor(exitButton);
    }

}
