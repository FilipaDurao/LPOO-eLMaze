package com.mygdx.elmaze.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.elmaze.ELMaze;
import com.mygdx.elmaze.networking.MessageToServer;
import com.mygdx.elmaze.networking.NetworkManager;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class PlayGameView extends MenuView {

    // Networking
    private Socket socket;
    private ObjectOutputStream o;

    public PlayGameView(ELMaze game) {
        super(game, TYPE.PLAY);
        setupStage();
    }

    @Override
    public void render(float delta) {
        handleInputs();

        stage.act(delta); //Perform ui logic
        stage.draw(); //Draw the UI
    }

    private void setupStage(){

    }

    protected void handleInputs(){
        boolean broadcastSuccess = NetworkManager.getInstance().broadcastMessage( new MessageToServer(
                Gdx.input.getAccelerometerY(),
                -Gdx.input.getAccelerometerX())
        );

        if(!broadcastSuccess) {
            game.activateMenu(MenuFactory.makeMenu(game, MenuView.TYPE.MAIN));
        }
    }

}
