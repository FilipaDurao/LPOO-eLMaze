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

	public SocketListener(Socket socket, int connectionID) {
		this.socket = socket;
		this.connectionID = connectionID;
	}

	@Override
	public void run() {
		try {
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
			closeSocket();
		}
		catch (IOException e) {
			System.out.println("Input/Output operation failed ...");
		} 
		catch (ClassNotFoundException e) {
			System.out.println("Tried to read to an invalid class object ...");
			System.exit(4);
		}
	}
	
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
	
	public void closeSocket() {
		if (GameController.getInstance().getStatus() == GameController.STATUS.RUNNING) {
			GameController.getInstance().triggedClientDC();
		}
		
		try {
			socket.close();
			oStream.close();
			NetworkManager.getInstance().getSocketManager().removeConnection(connectionID);
		} catch (IOException e1) {
			System.out.println("Failed to close socket ...");
			System.exit(3);
		}
	}

}
