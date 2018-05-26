package com.mygdx.elmaze.networking;

import com.mygdx.elmaze.controller.GameController;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ServerListener implements Runnable {

    private final Socket socket;

    public ServerListener(Socket socket) {
        this.socket = socket;
    }

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
                        GameController.getInstance().disconnectGame();
                        break;
                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            NetworkManager.getInstance().closeConnection();
            GameController.getInstance().disconnectGame();
        }
    }
}
