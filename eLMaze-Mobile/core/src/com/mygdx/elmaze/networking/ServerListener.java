package com.mygdx.elmaze.networking;

import com.badlogic.gdx.Game;
import com.mygdx.elmaze.controller.GameController;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * Listens to server messages
 */
public class ServerListener implements Runnable {

    private final Socket socket;

    /**
     * @param socket
     */
    public ServerListener(Socket socket) {
        this.socket = socket;
    }

    /**
     * Server Listener running method (can be launched in a separate thread). Waits for message from the server (in
     * a blocking call) and, after receiving a message, communicates with the game controller, depending on its status.
     */
    @Override
    public void run() {
        try {
            ObjectInputStream stream = new ObjectInputStream(socket.getInputStream());
            MessageToClient msg = null;

            while(socket != null) {
                msg = (MessageToClient) stream.readObject();

                if (msg != null) {
                    switch (msg.getContent()) {
                    case GAME_START:
                        GameController.getInstance().startGame();
                        break;
                    case GAME_FINISH:
                        GameController.getInstance().stopGame();
                        break;
                    case SERVER_FULL:
                        GameController.getInstance().triggerServerFull();
                        break;
                    }
                }
            }
        }
        catch (Exception e) {
            switch (GameController.getInstance().getStatus()) {
                case SV_FULL:
                    GameController.getInstance().triggerServerFull();
                    break;
                case NOT_RUNNING:
                    GameController.getInstance().triggerServerDC();
                    GameController.getInstance().stopGame();
                    break;
                default:
                    GameController.getInstance().triggerServerDC();
                    break;
            }
        }
    }
}
