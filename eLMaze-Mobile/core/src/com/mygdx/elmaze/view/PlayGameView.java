package com.mygdx.elmaze.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.elmaze.ELMaze;
import com.mygdx.elmaze.networking.MessageToServer;
import com.mygdx.elmaze.networking.NetworkManager;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class PlayGameView extends MenuView {

    private Image textImage;
    private Image ballImage;

    public PlayGameView(ELMaze game) {
        super(game, TYPE.PLAY);
        setupTextImage();
        setupBallImage();
        setupStage();
    }

    @Override
    public void render(float delta) {
        //handleInputs();

        stage.act(delta); //Perform ui logic
        stage.draw(); //Draw the UI
    }

    private void setupStage() {
        stage.addActor(textImage);
        stage.addActor(ballImage);
    }

    private void setupTextImage() {
        //Texture texture = ImageFactory.makeSizedTexture("playText.png", SCREEN_WIDTH*90/100);
        //textImage.rotateBy(90);
        //textImage = new Image(texture);
        //textImage.setPosition(SCREEN_WIDTH/2, SCREEN_HEIGHT*8/10);
        //textImage.setDrawable(new TextureRegionDrawable(new TextureRegion(texture)));


        //Texture texture = ImageFactory.makeSizedTexture("eLMazeTitle.png", SCREEN_WIDTH*82/100);
        //textImage = new Image(texture);
        //textImage.setPosition(SCREEN_WIDTH/2, SCREEN_HEIGHT*7.7f/9, 1);
        //textImage.setDrawable(new TextureRegionDrawable(new TextureRegion(texture)));
    }

    private void setupBallImage() {

    }

    private void handleInputs(){
        boolean broadcastSuccess = NetworkManager.getInstance().broadcastMessage( new MessageToServer(
                Gdx.input.getAccelerometerY(),
                -Gdx.input.getAccelerometerX())
        );

        if(!broadcastSuccess) {
            NetworkManager.getInstance().closeConnection();
            game.activateMenu(MenuFactory.makeMenu(game, MenuView.TYPE.MAIN));
        }
    }

}
