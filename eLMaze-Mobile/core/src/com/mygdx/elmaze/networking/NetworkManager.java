package com.mygdx.elmaze.networking;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class NetworkManager {

    private static NetworkManager instance;
    private static final int SERVER_PORT = 8500;

    private ObjectOutputStream oStream;
    private Socket socket;

    public static NetworkManager getInstance() {
        if (instance == null) {
            instance = new NetworkManager();
        }

        return instance;
    }

    private NetworkManager() {
        socket = new Socket();
    }

    public boolean establishConnection(String serverAddress, int timeout)  {
        try {
            socket.connect(new InetSocketAddress(serverAddress, SERVER_PORT), timeout);
            createOutputStream();
            return true;
        }
        catch(Exception e) {
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