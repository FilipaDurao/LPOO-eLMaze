package com.mygdx.elmaze.controller;

import com.badlogic.gdx.Gdx;
import com.mygdx.elmaze.ELMaze;
import com.mygdx.elmaze.networking.MessageToServer;
import com.mygdx.elmaze.networking.NetworkManager;
import com.mygdx.elmaze.view.MenuFactory;
import com.mygdx.elmaze.view.MenuView;

public class GameController {

    private static GameController instance;
    private ELMaze game;
    private boolean isGameRunning = false;

    public static GameController getInstance() {
        if (instance == null) {
            instance = new GameController();
        }

        return instance;
    }

    private GameController() {}

    public void setGameReference(ELMaze game) {
        this.game = game;
    }

    public void startGame() {
        isGameRunning = true;
    }

    public void disconnectGame() {
        isGameRunning = false;
    }

    public void moveBall(float accelerometerX, float accelerometerY) {
        boolean broadcastSuccess = NetworkManager.getInstance().broadcastMessage( new MessageToServer(
                accelerometerX,
                accelerometerY
        ));

        if(!broadcastSuccess) {
            NetworkManager.getInstance().closeConnection();
            game.activateMenu(MenuFactory.makeMenu(game, MenuView.TYPE.MAIN));
        }
    }

    public boolean isGameRunning() {
        return isGameRunning;
    }

}
