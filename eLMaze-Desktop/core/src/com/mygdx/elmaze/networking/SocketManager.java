package com.mygdx.elmaze.networking;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketManager implements Runnable {
	
	private final ServerSocket serverSocket;
	
	public SocketManager (ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}

	@Override
	public void run() {
		while(true) {
			try {
				System.out.println("Waiting for a socket to connect...");
				Socket clientSocket = serverSocket.accept();
				System.out.println("Socket connected!");
				Thread thread = new Thread(new SocketListener(clientSocket));
				thread.start();
			} catch (IOException e) {
				System.out.println("Failed to attend client socket...");
				System.exit(2);
			}
		}
	}

	
	
}
