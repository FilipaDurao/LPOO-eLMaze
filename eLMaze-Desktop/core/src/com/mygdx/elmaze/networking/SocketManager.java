package com.mygdx.elmaze.networking;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketManager implements Runnable {
	
	private final ServerSocket serverSocket;
	private final int maxNumConnections;
	private static int numConnections = 0;
	
	
	public SocketManager (ServerSocket serverSocket, int maxNumConnections) {
		this.maxNumConnections = maxNumConnections;
		this.serverSocket = serverSocket;
	}

	@Override
	public void run() {
		while(true) {
			if (numConnections < maxNumConnections) {
				try {
					Socket clientSocket = serverSocket.accept();
					int connectionID = numConnections;
					addConnection();
					Thread thread = new Thread(new SocketListener(clientSocket, connectionID));
					thread.start();
				} catch (IOException e) {
					System.out.println("Failed to attend client socket...");
					System.exit(2);
				}
			}
		}
	}
	
	public static void addConnection() {
		numConnections++;
	}
	
	public static void removeConnection() {
		numConnections--;
	}
	
	public static int getNumConnections() {
		return numConnections;
	}
	
}
