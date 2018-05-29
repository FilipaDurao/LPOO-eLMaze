package com.mygdx.elmaze.networking;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

/**
 * Singleton Class that manages all the client's networking
 */
public class NetworkManager {

    private static NetworkManager instance;
    private static final int SERVER_PORT = 8500;

    private ObjectOutputStream oStream;
    private Socket socket;

    /**
     * @return Singleton's class instance
     */
    public static NetworkManager getInstance() {
        if (instance == null) {
            instance = new NetworkManager();
        }

        return instance;
    }

    private NetworkManager() {}

    /**
     * Connects to a server in a specific address
     *
     * @param serverAddress Server IP address
     * @param timeout Number of seconds before connection attempt timing out
     *
     * @return Returns whether the connection was successful or not
     */
    public boolean establishConnection(String serverAddress, int timeout)  {
        try {
            // Connect to server
            createSocket();
            socket.connect(new InetSocketAddress(serverAddress, SERVER_PORT), timeout);

            // Write to server
            createOutputStream();

            // Listen from server
            Thread thread = new Thread(new ServerListener(socket));
            thread.start();

            return true;
        }
        catch(Exception e) {
            return false;
        }
    }

    /**
     * Closes the connection the server
     */
    public void closeConnection() {
        try {
            socket.close();
            oStream.close();
        } catch (Exception e) { }
    }

    /**
     * Broadcasts a message to the server
     *
     * @param msg Message to send
     *
     * @return Returns whether the message was successfully sent or not
     */
    public boolean broadcastMessage(MessageToServer msg) {
        try {
            oStream.writeObject(msg);
            oStream.reset();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Creates a socket to connect to the server
     *
     * @throws Exception
     */
    private void createSocket() throws Exception {
        try {
            socket = new Socket();
            socket.setTcpNoDelay(true);
        } catch (SocketException e) {
            throw new Exception();
        }
    }

    /**
     * Crestes an ObjectOutputStream class instance to communicate with the server
     *
     * @throws IOException
     */
    private void createOutputStream() throws IOException {
        try {
            oStream = new ObjectOutputStream(socket.getOutputStream());
        }
        catch(IOException e) {
            throw e;
        }
    }

}