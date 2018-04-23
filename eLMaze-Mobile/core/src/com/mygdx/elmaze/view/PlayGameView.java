package com.mygdx.elmaze.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.elmaze.ELMaze;
import com.mygdx.elmaze.networking.MessageToServer;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class PlayGameView extends ScreenAdapter {
    private final int SCREEN_WIDTH = Gdx.graphics.getWidth();
    private final int SCREEN_HEIGHT = Gdx.graphics.getHeight();

    // Networking
    private Socket socket;
    private ObjectOutputStream o;

    private final ELMaze game;
    private Stage stage;

    // Background
    private Image backgroundImage;

    public PlayGameView(ELMaze game) {
        this.game = game;
        setUpBackground();
        setUpStage();
        connectToHostSocket();
    }

    @Override
    public void render(float delta) {
        handleInput();

        stage.act(delta); //Perform ui logic
        stage.draw(); //Draw the UI
    }

    private void setUpBackground(){
        Texture backgroundTexture = new Texture("background.png");
        backgroundImage = new Image(backgroundTexture);
        backgroundImage.setDrawable(new TextureRegionDrawable(new TextureRegion(backgroundTexture)));
        backgroundImage.setSize(backgroundTexture.getWidth(), backgroundTexture.getHeight());
    }

    private void setUpStage(){
        stage = new Stage();
        stage.addActor(backgroundImage);
        Gdx.input.setInputProcessor(stage);
    }

    public void connectToHostSocket(){
        while (true) {
            try {
                socket = new Socket("192.168.2.118", 8500);
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

    public void handleInput(){
        try {
            o.writeObject(new MessageToServer(
                    Gdx.input.getAccelerometerY(),
                    -Gdx.input.getAccelerometerX())
            );
        }
        catch (IOException e){
            System.out.println("Failed to write message...");
            System.exit(2);
        }
    }

}
