package com.mygdx.elmaze.networking;

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
                    // Processing
                }
            }
        }
        catch (Exception e) {
            NetworkManager.getInstance().closeConnection();
        }
    }
}
