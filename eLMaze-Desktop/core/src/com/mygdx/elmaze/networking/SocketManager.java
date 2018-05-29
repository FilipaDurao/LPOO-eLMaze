package com.mygdx.elmaze.networking;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Waits for the sockets to connect to the server and manages them
 */
public class SocketManager implements Runnable {
	
	private final ServerSocket serverSocket;
	private final int maxNumConnections;
	private static int numConnections = 0;
	private final SocketListener[] socketListeners;
	private final Thread[] threads;
	
	/**
	 * @param serverSocket Server Socket that attends server clients
	 * @param maxNumConnections Maximum number of clients the server can attend
	 */
	public SocketManager (ServerSocket serverSocket, int maxNumConnections) {
		this.maxNumConnections = maxNumConnections;
		this.serverSocket = serverSocket;
		this.socketListeners = new SocketListener[maxNumConnections];
		this.threads = new Thread[maxNumConnections];
	}

	/**
	 * Socket Manager running method (can be launched in a separate thread). Waits for new server connections (in
	 * a blocking call) and, after receiving a connection, creates a SocketListener class instance to listen and 
	 * communicate with the new client
	 */
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
			} catch (IOException e) { }
		}
	}
	
	/**
	 * Computes the lowest server free socket slot index for saving a new client
	 * 
	 * @return Returns server's lowest free socket slot index, or -1 if there is no free slot.
	 */
	private int getEmptySocketSlotIndex() {
		for (int index=0 ; index<socketListeners.length ; index++) {
			if (socketListeners[index] == null) {
				return index;
			}
		}
		
		return -1;
	}
	
	/**
	 * Adds a new connection to the server
	 * 
	 * @param socketListener SocketListener instance responsible to communicate with the new client
	 * @param thread Thread in which the SocketListener instance is running
	 * @param connectionID The identification number of the new client
	 */
	public void addConnection(SocketListener socketListener, Thread thread, int connectionID) {
		socketListeners[connectionID] = socketListener;
		threads[connectionID] = thread;
		numConnections++;
	}
	
	/**
	 * Removes a connection from the server
	 * 
	 * @param connectionID The identification number of the client to be removed
	 */
	public void removeConnection(int connectionID) {
		numConnections--;
		socketListeners[connectionID].closeSocket();
		threads[connectionID].interrupt();
		threads[connectionID] = null;
		socketListeners[connectionID] = null;
	}
	
	/**
	 * @return Returns the current number of clients connected to the server
	 */
	public int getNumConnections() {
		return numConnections;
	}
	
	/**
	 * Broadcasts a message to all clients connected to the server
	 * 
	 * @param msg Message to be sent to all clients
	 */
	public void broadcastMessage(MessageToClient msg) {
		for (SocketListener socketListener : socketListeners) {
			if (socketListener != null) {
				socketListener.broadcastMessage(msg);
			}
		}
	}
	
	/**
	 * Closes connection with all currently connected clients
	 */
	public void closeConnections() {
		for (int i=0 ; i<numConnections ; i++) {
			if (socketListeners[i] != null && threads[i] != null) {
				removeConnection(i);
			}
		}
	}
	
	/**
	 * Communicates to a specific socket client that the server is currently full
	 * 
	 * @param clientSocket Socket to communicate with
	 */
	private void communicateServerFull(Socket clientSocket) {
		try {
			ObjectOutputStream oStream = new ObjectOutputStream(clientSocket.getOutputStream());
			MessageToClient msg = new MessageToClient(MessageToClient.CONTENT.SERVER_FULL);
            oStream.writeObject(msg);
            oStream.close();
		} catch (IOException e) {
			System.out.println("Failed to communicate to client that the server is full.");
		}
	}
	
}
