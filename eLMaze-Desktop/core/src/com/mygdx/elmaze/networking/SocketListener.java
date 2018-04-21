package com.mygdx.elmaze.networking;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.elmaze.controller.GameController;

public class SocketListener implements Runnable {
	
	private final Socket socket;

	public SocketListener(Socket socket) {
		this.socket = socket;
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
					GameController.getInstance().getBallBody().applyForceToCenter(new Vector2(
							msg.getAccelerometerX(),
							msg.getAccelerometerY()),
							true
					);
				}
			}
		} 
		catch (IOException e) {
			System.out.println("Failed to parse message...");
			System.exit(3);
		} 
		catch (ClassNotFoundException e) {
			System.out.println("Tried to read to an invalid class...");
			System.exit(4);
		}
	}

}
