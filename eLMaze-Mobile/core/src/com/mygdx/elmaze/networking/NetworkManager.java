package com.mygdx.elmaze.networking;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

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

    private NetworkManager() {}

    public boolean establishConnection(String serverAddress, int timeout)  {
        try {
            // Connect to server
            for (int i=0 ; i<10 ; i++) {
                System.out.println("Creating socket.");
            }
            createSocket();
            socket.connect(new InetSocketAddress(serverAddress, SERVER_PORT), timeout);


            for (int i=0 ; i<10 ; i++) {
                System.out.println("Connected to server.");
            }

            // Write to server
            createOutputStream();

            for (int i=0 ; i<10 ; i++) {
                System.out.println("Created OUTPUT stream.");
            }


            // Listen from server
            Thread thread = new Thread(new ServerListener(socket));
            thread.start();


            for (int i=0 ; i<10 ; i++) {
                System.out.println("Started Listener.");
            }

            return true;
        }
        catch(Exception e) {
            return false;
        }
    }

    public void closeConnection() {
        try {
            socket.close();
            oStream.close();
        } catch (Exception e) { }
    }

    public boolean broadcastMessage(MessageToServer msg) {
        try {
            oStream.writeObject(msg);
            oStream.reset();
            return true;
        }
        catch (IOException e){
            return false;
        }
    }

    private void createSocket() throws Exception {
        try {
            socket = new Socket();
            socket.setTcpNoDelay(true);
        } catch (SocketException e) {
            throw new Exception();
        }
    }

    private void createOutputStream() throws IOException {
        try {
            oStream = new ObjectOutputStream(socket.getOutputStream());
        }
        catch(IOException e) {
            throw e;
        }
    }

}