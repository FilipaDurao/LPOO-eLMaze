package com.mygdx.elmaze.networking;

import com.mygdx.elmaze.controller.GameController;

import java.io.EOFException;
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
            for (int i=0 ; i<10 ; i++) {
                System.out.println("Thread created.");
            }

            ObjectInputStream stream = new ObjectInputStream(socket.getInputStream());

            for (int i=0 ; i<10 ; i++) {
                System.out.println("Stream created.");
            }

            MessageToClient msg = null;



            while(socket != null) {

                for (int i=0 ; i<10 ; i++) {
                    System.out.println("Waiting message.");
                }

                msg = (MessageToClient) stream.readObject();

                for (int i=0 ; i<10 ; i++) {
                    System.out.println("Receiveddddd message ...");
                }

                if (msg != null) {
                    for (int i=0 ; i<10 ; i++) {
                        System.out.println("     ... it's not null!");
                    }
                    switch (msg.getContent()) {
                    case GAME_START:
                        GameController.getInstance().startGame();
                        for (int i=0 ; i<10 ; i++) {
                            System.out.println("GAME_START Message");
                        }
                        break;
                    case GAME_FINISH:
                        GameController.getInstance().stopGame();
                        for (int i=0 ; i<10 ; i++) {
                            System.out.println("GAME_FINISH Message");
                        }
                        break;
                    case SERVER_FULL:
                        GameController.getInstance().triggerServerFull();
                        for (int i=0 ; i<10 ; i++) {
                            System.out.println("SV_FULL Message");
                        }
                        break;
                    }
                }
            }
        }
        catch (EOFException e) {
            GameController.getInstance().triggerServerDC();
        }
        catch (Exception e) {
            e.printStackTrace();
            NetworkManager.getInstance().closeConnection();
            GameController.getInstance().stopGame();
        }
    }
}
