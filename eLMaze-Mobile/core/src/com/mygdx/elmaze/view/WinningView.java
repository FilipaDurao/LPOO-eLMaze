package com.mygdx.elmaze.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.elmaze.ELMaze;
import com.mygdx.elmaze.controller.GameController;
import com.mygdx.elmaze.networking.NetworkManager;

public class WinningView extends MenuView {

    // Background
    private Button backButton;
    private Image textImage;

    public WinningView(ELMaze game) {
        super(game, TYPE.WIN);

        loadAssets();
        setupBackButton();
        setupStage();
    }

    @Override
    public void render(float delta) {
        stage.act(delta);   // Perform ui logic
        stage.draw();       // Draw the UI
    }

    private void setupBackButton() {
        backButton = ButtonFactory.makeButton(game,"backButtonUp.png","backButtonDown.png",SCREEN_WIDTH/2,
                SCREEN_HEIGHT*1.15f/9, (int)(SCREEN_WIDTH*0.75), (int)(SCREEN_HEIGHT*0.13));

        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.activateMenu(MenuFactory.makeMenu(game, TYPE.MAIN));
            }
        });
    }

    private void setupStage(){
        textImage = ImageFactory.makeImage(game,"youWon.png", SCREEN_WIDTH*50/100, SCREEN_HEIGHT*60/100,SCREEN_WIDTH*85/100);

        stage.addActor(textImage);
        stage.addActor(backButton);
    }

    protected void loadAssets() {
        this.game.getAssetManager().load("youWon.png" , Texture.class);
        this.game.getAssetManager().load("backButtonUp.png" , Texture.class);
        this.game.getAssetManager().load("backButtonDown.png" , Texture.class);
        this.game.getAssetManager().finishLoading();
    }
}
