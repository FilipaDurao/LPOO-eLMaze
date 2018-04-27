package com.mygdx.elmaze.networking;

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

    public boolean establishConnection(String serverAddress, int numRetries)  {
        System.out.println("Trying to connect to server in address " + serverAddress);
        for (int i=0 ; i<numRetries ; i++) {
            try {
                System.out.println("Trying to create socket.");
                socket = new Socket(serverAddress, 8500);
                System.out.println("Created socket!");
                System.out.println("Trying to create stream");
                createOutputStream();
                System.out.println("Created Stream!");
                System.out.println("Successfully connected to server!");
                return true;
            }
            catch(Exception e) {
                System.out.println("Failed to create socket. Let's retry.");
            }
        }
        System.out.println("Failed to connect to server.");

        return false;
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