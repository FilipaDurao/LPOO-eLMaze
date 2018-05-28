package com.mygdx.elmaze.networking;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketManager implements Runnable {
	
	private final ServerSocket serverSocket;
	private final int maxNumConnections;
	private static int numConnections = 0;
	private final SocketListener[] socketListeners;
	private final Thread[] threads;
	
	
	public SocketManager (ServerSocket serverSocket, int maxNumConnections) {
		this.maxNumConnections = maxNumConnections;
		this.serverSocket = serverSocket;
		this.socketListeners = new SocketListener[maxNumConnections];
		this.threads = new Thread[maxNumConnections];
	}

	@Override
	public void run() {
		while(true) {
			try {
				Socket clientSocket = serverSocket.accept();

				if (numConnections >= maxNumConnections) {
					System.out.println("New client cannot be attended - Server is Full");
					communicateServerFull(clientSocket);
					continue;
				}

				int connectionID = getEmptySocketSlotIndex();
				System.out.println("New client with id " + connectionID + " connected.");
				
				SocketListener clientSocketListener = new SocketListener(clientSocket, connectionID);
				Thread thread = new Thread(clientSocketListener);
				addConnection(clientSocketListener, thread, connectionID);
				thread.start();
			} catch (IOException e) {
				System.out.println("Failed to attend client socket...");
				System.exit(2);
			}
		}
	}
	
	private int getEmptySocketSlotIndex() {
		for (int index=0 ; index<socketListeners.length ; index++) {
			if (socketListeners[index] == null) {
				return index;
			}
		}
		
		return -1;
	}
	
	public void addConnection(SocketListener socketListener, Thread thread, int connectionID) {
		socketListeners[connectionID] = socketListener;
		threads[connectionID] = thread;
		numConnections++;
	}
	
	public void removeConnection(int connectionID) {
		numConnections--;
		threads[connectionID].interrupt();
		threads[connectionID] = null;
		socketListeners[connectionID] = null;
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
	
	public void closeConnections() {
		for (int i=0 ; i<numConnections ; i++) {
			if (socketListeners[i] != null && threads[i] != null) {
				removeConnection(i);
			}
		}
	}
	
	private void communicateServerFull(Socket clientSocket) {
		try {
			ObjectOutputStream oStream = new ObjectOutputStream(clientSocket.getOutputStream());
			MessageToClient msg = new MessageToClient(MessageToClient.CONTENT.SERVER_FULL);
            oStream.writeObject(msg);
            oStream.close();
		} catch (IOException e) {
			System.out.println("Failed to communicate to client that the server is full.");
		}
		
		try {
			clientSocket.close();
		} catch (IOException e) {
			System.out.println("Failed to close client socket when communicating the server is full.");
		}
	}
	
}
