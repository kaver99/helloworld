package com.network.bc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class BcClientService implements Runnable {
	// ---------------------------------------------------------------------------
	// Global Variable
	// ---------------------------------------------------------------------------
	Socket socket = null;
	InputStream inputStream = null;
	BufferedReader bufferdReader = null;
	String str = null;
	String serverIp = "127.0.0.1";
	int serverPort = 15000;
	String responseMsg = null;
	
	// ---------------------------------------------------------------------------
	// Init
	// ---------------------------------------------------------------------------
	public void init(String ip, int port) {
		this.serverIp = ip;
		this.serverPort = port;
	}

	// ---------------------------------------------------------------------------
	// Run
	// ---------------------------------------------------------------------------
	@Override
	public void run() {
		try {
			while(true) {
				socket = new Socket(serverIp, serverPort);
				inputStream = socket.getInputStream();
				bufferdReader = new BufferedReader(new InputStreamReader(inputStream));
				
				responseMsg = bufferdReader.readLine();
				System.out.println("ResponseMsg : " + responseMsg);
				
				socket.close();
			}
		} catch (Exception e) {
			if(!socket.isClosed()) {
				try {
					socket.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}
