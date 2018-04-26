package com.mygdx.elmaze.networking;

import com.badlogic.gdx.Gdx;
import com.mygdx.elmaze.view.MenuFactory;
import com.mygdx.elmaze.view.MenuView;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class NetworkManager {

    private static NetworkManager instance;

    private ObjectOutputStream oStream;
    private Socket socket;

    public static NetworkManager getInstance() {
        if (instance == null) {
            instance = new NetworkManager();
        }

        return instance;
    }

    private NetworkManager() {
        socket = null;
    }

    public boolean establishConnection(String serverAddress) {
        try {
            socket = new Socket(serverAddress, 8500);
            createOutputStream();
            return true;
        }
        catch(IOException e) {
            return false;
        }
    }

    public boolean broadcastMessage(MessageToServer msg) {
        try {
            oStream.writeObject(msg);
            return true;
        }
        catch (IOException e){
            return false;
        }
    }

    private void createOutputStream() {
        try {
            oStream = new ObjectOutputStream(socket.getOutputStream());
        }
        catch(IOException e) {
            System.out.println("Failed to create stream...");
            System.exit(2);
        }
    }

}