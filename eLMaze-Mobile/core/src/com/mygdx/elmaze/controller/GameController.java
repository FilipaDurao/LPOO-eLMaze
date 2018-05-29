package com.mygdx.elmaze.controller;

import com.mygdx.elmaze.ELMaze;
import com.mygdx.elmaze.networking.MessageToServer;
import com.mygdx.elmaze.networking.NetworkManager;
import com.mygdx.elmaze.view.MenuFactory;
import com.mygdx.elmaze.view.MenuView;

/**
 * Game Controller Singleton class
 */
public class GameController {

    private static GameController instance;

    /** Game Controller Status */
    public enum STATUS { NOT_RUNNING , RUNNING , DISCONNECT , SV_FULL };

    private ELMaze game;
    private STATUS status = STATUS.NOT_RUNNING;

    /**
     * @return Singleton's class instance
     */
    public static GameController getInstance() {
        if (instance == null) {
            instance = new GameController();
        }

        return instance;
    }

    private GameController() {}

    /**
     * Sets the controller game class object reference
     *
     * @param game Game class object reference
     */
    public void setGameReference(ELMaze game) {
        this.game = game;
    }

    /**
     * @return Returns the Controller current status
     */
    public STATUS getStatus() {
        return status;
    }

    /**
     * Triggers a game start event, thus setting the Controller status to RUNNING
     */
    public void startGame() {
        status = STATUS.RUNNING;
    }

    /**
     * Triggers a game stop event, thus setting the Controller status to NOT_RUNNING
     */
    public void stopGame() {
        status = STATUS.NOT_RUNNING;
    }

    /**
     * Triggers a server full event, thus setting the Controller status to SV_FULL
     */
    public void triggerServerFull() {
        status = STATUS.SV_FULL;
    }

    /**
     * Triggers the client disconnect from server event, thus setting the Controller status to DISCONNECT
     */
    public void triggerServerDC() {
        status = STATUS.DISCONNECT;
    }

    /**
     * Moves the ball on the server, based on the mobile device accelerometer's values
     *
     * @param accelerometerX Accelerometer X axis value
     * @param accelerometerY Accelerometer Y axis value
     */
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
