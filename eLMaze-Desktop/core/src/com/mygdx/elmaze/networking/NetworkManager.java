package com.mygdx.elmaze.networking;

import java.io.IOException;
import java.net.ServerSocket;

public class NetworkManager {
	
	private static NetworkManager instance;
	
	private final int PORT = 8500;
	
	private ServerSocket serverSocket;
	
	public static NetworkManager getInstance() {
		if (instance == null) {
			instance = new NetworkManager();
		}
		
		return instance;
	}
	
	private NetworkManager() {
		serverSocket = null;
	}
	
	public void startServer() {
		if (serverSocket == null) {
			try {
				serverSocket = new ServerSocket(PORT);
				Thread thread = new Thread(new SocketManager(serverSocket));
				thread.start();
			} catch (IOException e) {
				System.out.println("Failed to create server socket.");
				System.exit(1);
			}
		}
	}

}
