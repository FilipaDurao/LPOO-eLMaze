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
				Socket clientSocket = serverSocket.accept();
				Thread thread = new Thread(new SocketListener(clientSocket));
				thread.start();
			} catch (IOException e) {
				System.out.println("Failed to attend client socket...");
				System.exit(2);
			}
		}
	}

	
	
}
