package com.mygdx.elmaze.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.elmaze.ELMaze;
import com.mygdx.elmaze.networking.MessageToServer;

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
        connectToHostSocket();
    }

    @Override
    public void render(float delta) {
        handleInputs();

        stage.act(delta); //Perform ui logic
        stage.draw(); //Draw the UI
    }

    private void setupStage(){

    }

    public void connectToHostSocket(){
        while (true) {
            try {
                socket = new Socket("172.30.10.12", 8500);
                break;
            }
            catch(IOException e) {
                //System.out.println("Failed to connect...");
                //e.printStackTrace();
                //System.exit(1);
            }
        }

        o = null;

        try {
            o = new ObjectOutputStream(socket.getOutputStream());
        }
        catch(IOException e) {
            System.out.println("Failed to create stream...");
            System.exit(2);
        }
    }

    public void handleInputs(){
        try {
            o.writeObject(new MessageToServer(
                    Gdx.input.getAccelerometerY(),
                    -Gdx.input.getAccelerometerX())
            );
        }
        catch (IOException e){
            game.activateMenu(MenuFactory.makeMenu(game, TYPE.MAIN));
        }
    }

}
