package com.mygdx.elmaze.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.elmaze.ELMaze;

public class CreditsView extends MenuView {

    // Text Table
    private Image textTableImage;
    private Button exitButton;

    public CreditsView(ELMaze game) {
        super(game, TYPE.CREDITS);

        setupTextTable();
        setupExitButton();
        setupStage();
    }

    @Override
    public void render(float delta) {
        stage.act(delta); //Perform ui logic
        stage.draw(); //Draw the UI
    }

    private void setupExitButton() {
        exitButton = ButtonFactory.makeButton( "exitButtonUp.png","exitButtonDown.png",SCREEN_WIDTH/2,
                SCREEN_HEIGHT*1.15f/9, (int)(SCREEN_WIDTH*0.75), (int)(SCREEN_HEIGHT*0.13));

        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.activateMenu(MenuFactory.makeMenu(game, TYPE.MAIN));
            }
        });
    }

    private void setupTextTable() {
        Texture texture = ImageFactory.makeSizedTexture("creditsTable.png", SCREEN_WIDTH*90/100);
        textTableImage = new Image(texture);
        textTableImage.setPosition(SCREEN_WIDTH*5/100, SCREEN_HEIGHT*25/100);
        textTableImage.setDrawable(new TextureRegionDrawable(new TextureRegion(texture)));
    }

    private void setupStage() {
        stage.addActor(textTableImage);
        stage.addActor(exitButton);
    }

}
