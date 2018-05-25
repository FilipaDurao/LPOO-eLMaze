package com.mygdx.elmaze.networking;

import com.mygdx.elmaze.controller.GameController;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ServerListener implements Runnable {

    private final Socket socket;

    public ServerListener(Socket socket) {
        for (int i=0 ; i<10 ; i++) {
            System.out.println("Started Listener.");
        }
        this.socket = socket;
    }

    @Override
    public void run() {
        for (int i=0 ; i<5 ; i++) {
            System.out.println("Running Listener");
        }
        try {

            if (socket == null) {
                for (int i=0 ; i<5 ; i++) {
                    System.out.println("Socket is null...!!!");
                }
            } else {
                for (int i=0 ; i<5 ; i++) {
                 System.out.println("Socket is not null :)");
                }
            }

            for (int i=0 ; i<5 ; i++) {
                System.out.println("Creating stream...");
            }

            ObjectInputStream stream = new ObjectInputStream(socket.getInputStream());

            for (int i=0 ; i<5 ; i++) {
                System.out.println("Created the Stream...!!!");
            }

            MessageToClient msg = null;


            while(socket != null) {

                System.out.println("Waiting for a Message");
                msg = (MessageToClient) stream.readObject();
                System.out.println("Read a message!");

                if (msg != null) {
                    for (int i=0 ; i<5 ; i++) {
                        System.out.println("Received a Message");
                    }
                    switch (msg.getContent()) {
                    case GAME_START:
                        GameController.getInstance().startGame();
                        break;
                    case GAME_FINISH:
                        GameController.getInstance().disconnectGame();
                        break;
                    }
                } else {
                    System.out.println("Message is null");
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            for (int i=0 ; i<5 ; i++) {
                System.out.println("Failed to start server listener");
            }
            NetworkManager.getInstance().closeConnection();
        }
    }
}
