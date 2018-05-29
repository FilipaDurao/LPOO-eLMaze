package com.mygdx.elmaze.controller;

import com.mygdx.elmaze.ELMaze;
import com.mygdx.elmaze.networking.MessageToServer;
import com.mygdx.elmaze.networking.NetworkManager;
import com.mygdx.elmaze.view.MenuFactory;
import com.mygdx.elmaze.view.MenuView;

public class GameController {

    public enum STATUS { NOT_RUNNING , RUNNING , DISCONNECT , SV_FULL };
    private static GameController instance;
    private ELMaze game;
    private STATUS status = STATUS.NOT_RUNNING;

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
        status = STATUS.RUNNING;
    }

    public void stopGame() {
        status = STATUS.NOT_RUNNING;
    }

    public void triggerServerFull() {
        status = STATUS.SV_FULL;
    }

    public void triggerServerDC() {
        status = STATUS.DISCONNECT;
    }

    public STATUS getStatus() {
        return status;
    }

    public void moveBall(float accelerometerX, float accelerometerY) {
        boolean broadcastSuccess = NetworkManager.getInstance().broadcastMessage( new MessageToServer(
                accelerometerX,
                accelerometerY
        ));

        if(!broadcastSuccess) {
            NetworkManager.getInstance().closeConnection();
            game.activateMenu(MenuFactory.makeMenu(game, MenuView.TYPE.SERVER_DC));
        }
    }

}
