package com.mygdx.elmaze.networking;

import java.io.IOException;
import java.net.ServerSocket;

public class NetworkManager {
	
	private final int PORT = 8500;
	
	public void startServer() {
		try {
			ServerSocket serverSocket = new ServerSocket(PORT);
			Thread thread = new Thread(new SocketManager(serverSocket));
			thread.start();
		} catch (IOException e) {
			System.out.println("Failed to create server socket.");
			System.exit(1);
		}
	}

}
