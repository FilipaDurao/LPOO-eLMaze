package com.mygdx.elmaze.networking;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketManager implements Runnable {
	
	private final ServerSocket serverSocket;
	private final int maxNumConnections;
	private static int numConnections = 0;
	private final Socket[] sockets;
	
	
	public SocketManager (ServerSocket serverSocket, int maxNumConnections) {
		this.maxNumConnections = maxNumConnections;
		this.serverSocket = serverSocket;
		this.sockets = new Socket[maxNumConnections];
	}

	@Override
	public void run() {
		while(true) {
			if (numConnections < maxNumConnections) {
				try {
					Socket clientSocket = serverSocket.accept();
					int connectionID = numConnections;
					addConnection(clientSocket);
					Thread thread = new Thread(new SocketListener(clientSocket, connectionID));
					thread.start();
				} catch (IOException e) {
					System.out.println("Failed to attend client socket...");
					System.exit(2);
				}
			}
		}
	}
	
	public void addConnection(Socket socket) {
		sockets[numConnections] = socket;
		numConnections++;
	}
	
	public void removeConnection(int connectionID) {
		numConnections--;
		sockets[numConnections] = null;
	}
	
	public int getNumConnections() {
		return numConnections;
	}
	
	public void broadcastMessage(MessageToClient msg) {
		for (Socket socket : sockets) {
			if (socket != null) {
	            try {
					ObjectOutputStream oStream = new ObjectOutputStream(socket.getOutputStream());
		            oStream.writeObject(msg);
		            oStream.reset();
		            oStream.close();				
				} catch (IOException e) {
					System.out.println("Failed to broadcast message ...");
					continue;
				}
			}
		}
	}
	
}
