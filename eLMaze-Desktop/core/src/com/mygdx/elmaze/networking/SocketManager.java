package com.mygdx.elmaze.networking;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketManager implements Runnable {
	
	private final ServerSocket serverSocket;
	private final int maxNumConnections;
	private static int numConnections = 0;
	private final Socket[] sockets;
	private final SocketListener[] socketListeners;
	
	
	public SocketManager (ServerSocket serverSocket, int maxNumConnections) {
		this.maxNumConnections = maxNumConnections;
		this.serverSocket = serverSocket;
		this.sockets = new Socket[maxNumConnections];
		this.socketListeners = new SocketListener[maxNumConnections];
	}

	@Override
	public void run() {
		while(true) {
			if (numConnections < maxNumConnections) {
				try {
					int connectionID = numConnections;
					Socket clientSocket = serverSocket.accept();
					SocketListener clientSocketListener = new SocketListener(clientSocket, connectionID);
					addConnection(clientSocket, clientSocketListener);
					Thread thread = new Thread(clientSocketListener);
					thread.start();
				} catch (IOException e) {
					System.out.println("Failed to attend client socket...");
					System.exit(2);
				}
			}
		}
	}
	
	public void addConnection(Socket socket, SocketListener socketListener) {
		sockets[numConnections] = socket;
		socketListeners[numConnections] = socketListener;
		numConnections++;
	}
	
	public void removeConnection(int connectionID) {
		numConnections--;
		sockets[numConnections] = null;
		socketListeners[numConnections] = null;
	}
	
	public int getNumConnections() {
		return numConnections;
	}
	
	public void broadcastMessage(MessageToClient msg) {
		for (SocketListener socketListener : socketListeners) {
			if (socketListener != null) {
				socketListener.broadcastMessage(msg);
			}
		}
	}
	
}
