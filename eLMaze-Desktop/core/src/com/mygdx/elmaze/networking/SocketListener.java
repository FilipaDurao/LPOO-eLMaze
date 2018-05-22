package com.mygdx.elmaze.networking;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.elmaze.controller.GameController;

public class SocketListener implements Runnable {
	
	private final Socket socket;
	private final int connectionID;

	public SocketListener(Socket socket, int connectionID) {
		this.socket = socket;
		this.connectionID = connectionID;
	}

	@Override
	public void run() {
		try {
			ObjectInputStream stream = new ObjectInputStream(socket.getInputStream());
			MessageToServer msg = null;
			
			while(socket != null) {
				msg = (MessageToServer) stream.readObject();
				
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
		catch (IOException e) {
			try {
				socket.close();
				NetworkManager.getInstance().getSocketManager().removeConnection(connectionID);
			} catch (IOException e1) {
				System.out.println("Failed to close socket ...");
				System.exit(3);
			}
		} 
		catch (ClassNotFoundException e) {
			System.out.println("Tried to read to an invalid class object ...");
			System.exit(4);
		}
	}

}
