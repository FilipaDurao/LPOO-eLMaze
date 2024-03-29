package com.mygdx.elmaze.networking;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.elmaze.controller.GameController;

public class SocketListener implements Runnable {
	
	private final Socket socket;
	private ObjectOutputStream oStream;
	private final int connectionID;

	/**
	 * @param socket Socket to communicate with
	 * @param connectionID Client connection identification number
	 */
	public SocketListener(Socket socket, int connectionID) {
		this.socket = socket;
		this.connectionID = connectionID;
	}

	/**
	 * Socket Listener running method (can be launched in a separate thread). Waits for message from the client (in
	 * a blocking call) and, after receiving a message, communicates with the game controller, depending on its status.
	 */
	@Override
	public void run() {
		try {
			System.out.println("Thread running with ID: " + connectionID);
			oStream = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream iStream = new ObjectInputStream(socket.getInputStream());
			MessageToServer msg = null;
			
			while(socket != null) {
				msg = (MessageToServer) iStream.readObject();
				
				if (msg != null) {
					// Update force to ball's center
					GameController.getInstance().updateBall(connectionID, new Vector2(
							msg.getAccelerometerX()/2,
							msg.getAccelerometerY()/2),
							true
					);
				}
			}
		} 
		catch (EOFException e) {
			System.out.println("Client " + connectionID + " disconnected.");
			if (GameController.getInstance().getStatus() == GameController.STATUS.RUNNING) {
				GameController.getInstance().triggerClientDC();
			} else {
				NetworkManager.getInstance().getSocketManager().removeConnection(connectionID);
			}
		}
		catch (IOException e) { } 
		catch (ClassNotFoundException e) {
			System.out.println("Tried to read to an invalid class object ...");
			System.exit(4);
		}
	}
	
	/**
	 * Broadcasts a message to the client 
	 * 
	 * @param msg Message to be sent
	 */
	public void broadcastMessage(MessageToClient msg) {
		if (socket != null) {
            try {
	            oStream.writeObject(msg);
	            oStream.reset();	
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Failed to broadcast message ...");
			}
		}
	}
	
	/**
	 * Closes the client's socket and respective object output stream
	 */
	public void closeSocket() {
		try {
			socket.close();
			oStream.close();
		} catch (IOException e1) {
			System.out.println("Failed to close socket from client " + connectionID + " ...");
		}
	}

}
