package com.mygdx.elmaze.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.elmaze.ELMaze;
import com.mygdx.elmaze.controller.GameController;

public class PlayGameView extends MenuView {

    private Image textImage;
    private Image ballImage;

    public PlayGameView(ELMaze game) {
        super(game, TYPE.PLAY);

        loadAssets();
        setupStage();
    }

    @Override
    public void render(float delta) {
        handleInputs();

        stage.act(delta); //Perform ui logic
        stage.draw(); //Draw the UI

        // Poll for server message for finished game
        if (!GameController.getInstance().isGameRunning()) {
            game.activateMenu(MenuFactory.makeMenu(game, MenuView.TYPE.SERVER_DC));
        }
    }

    private void setupStage() {
        textImage = ImageFactory.makeImage(game,"playText.png", SCREEN_WIDTH*5/7, SCREEN_HEIGHT/2,SCREEN_WIDTH*3/10);
        ballImage = ImageFactory.makeImage(game,"ball.png", SCREEN_WIDTH*7/28, SCREEN_HEIGHT/2,SCREEN_WIDTH*3/10);

        stage.addActor(textImage);
        stage.addActor(ballImage);
    }

    private void handleInputs(){
        GameController.getInstance().moveBall(
            Gdx.input.getAccelerometerY(),
            -Gdx.input.getAccelerometerX()
        );
    }

    protected void loadAssets() {
        this.game.getAssetManager().load("playText.png" , Texture.class);
        this.game.getAssetManager().load("ball.png" , Texture.class);
        this.game.getAssetManager().finishLoading();
    }

}
