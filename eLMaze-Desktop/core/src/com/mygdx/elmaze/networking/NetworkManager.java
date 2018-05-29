package com.mygdx.elmaze.networking;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

/**
 * Singleton Class that manages all application server side networking
 */
public class NetworkManager {
	
	private static NetworkManager instance;
	private final int PORT = 8500;
	
	private ServerSocket serverSocket;
	private SocketManager socketManager;
	private String IPAddress;
	
	/**
	 * @return Singleton's class instance
	 */
	public static NetworkManager getInstance() {
		if (instance == null) {
			instance = new NetworkManager();
		}
		
		return instance;
	}
	
	/**
	 * Singleton's private constructor
	 */
	private NetworkManager() {
		serverSocket = null;
	}
	
	/**
	 * @return Server's running IP address
	 */
	public String getIPAddress() {
		return IPAddress;
	}
	
	/**
	 * Finds the the local address by connecting to another server and verifying which IP was used for the connection
	 * 
	 * @return Server's local IP address
	 */
	private String findLocalAddress() {
		try {
			Socket s = new Socket("google.com", 80);
			String ipAddress = s.getLocalAddress().getHostAddress();
			s.close();
			return ipAddress;
		} 
		catch (IOException e) {
			return "";
		}
	}
	
	/**
	 * Starts the server by creating a server socket. Launches a SocketManager class instance that
	 * waits and handles new connections in a separate thread.
	 * 
	 * @param maxNumClients Maximum number of clients the server can attend at a time
	 * 
	 * @return Returns true if the server creation is successful, false otherwise (no Internet connection)
	 */
	public boolean startServer(int maxNumClients) {
		if (serverSocket == null) {
			IPAddress = findLocalAddress();
			
			if (IPAddress == "") {
				return false;
			}
			
			try {
				serverSocket = new ServerSocket(PORT);
				socketManager = new SocketManager(serverSocket, maxNumClients);
				Thread thread = new Thread(socketManager);
				thread.start();
				return true;
			} catch (IOException e) {
				System.out.println("Failed to create server socket.");
				System.exit(1);
			}
		}
		
		return true;
	}
	
	/**
	 * Creates the running server
	 */
	public void closeServer() {
		try {
			serverSocket.close();
		} catch (IOException e) {
			System.out.println("Failed to close server socket.");
			System.exit(2);
		}
	}
	
	/**
	 * Parses the server's running IP address into an hexadecimal digit linked list
	 * 
	 * @return Returns parsed IP address
	 */
	public LinkedList<Integer> getParsedIP() {
		LinkedList<Integer> parsedIP = new LinkedList<Integer>();
		
		int num;
		for (String tok : IPAddress.split("\\.")) {
			num = Integer.parseInt(tok);
			parsedIP.add(num/16);
			parsedIP.add(num%16);
		}
		
		return parsedIP;
    }
	
	/**
	 * @return Returns server socket manager
	 */
	public SocketManager getSocketManager() {
		return socketManager;
	}

}
