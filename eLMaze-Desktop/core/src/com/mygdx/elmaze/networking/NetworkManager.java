package com.mygdx.elmaze.networking;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class NetworkManager {
	
	private static NetworkManager instance;
	
	private final int PORT = 8500;
	
	private ServerSocket serverSocket;
	private SocketManager socketManager;
	private String IPAddress;
	
	public static NetworkManager getInstance() {
		if (instance == null) {
			instance = new NetworkManager();
		}
		
		return instance;
	}
	
	private NetworkManager() {
		serverSocket = null;
	}
	
	public String getIPAddress() {
		return IPAddress;
	}
	
	private String findLocalAddress() {
		try {
			Socket s = new Socket("google.com", 80);
			String ipAddress = s.getLocalAddress().getHostAddress();
			System.out.println(ipAddress);
			s.close();
			return ipAddress;
		} 
		catch (IOException e) {
			return "";
		}
	}
	
	public boolean startServer(int maxNumClients) {
		if (serverSocket == null) {
			// Find IP address
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
	
	public void closeServer() {
		try {
			serverSocket.close();
		} catch (IOException e) {
			System.out.println("Failed to close server socket.");
			System.exit(2);
		}
	}
	
	// TODO: This is temporary!!
	public LinkedList<Integer> parse() {
		LinkedList<Integer> parsedIP = new LinkedList<Integer>();
		
		int num;
		for (String tok : IPAddress.split("\\.")) {
			num = Integer.parseInt(tok);
			parsedIP.add(num/16);
			parsedIP.add(num%16);
		}
		
		return parsedIP;
    }
	
	public SocketManager getSocketManager() {
		return socketManager;
	}

}
