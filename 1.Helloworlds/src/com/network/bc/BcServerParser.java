package com.network.bc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class BcServerParser implements Runnable {
	// ---------------------------------------------------------------------------
	// Global Variable
	// ---------------------------------------------------------------------------
	Socket clientSocket 		= null;
	OutputStream outputStream 	= null;
	InputStream inputStream 	= null;
	BufferedReader br 			= null;
	PrintWriter writer 			= null;
	String requestMsg 			= null;
	String responseMsg 			= null;
	String clientIp 			= null;
	int clientPort				= 0;
	
	// ---------------------------------------------------------------------------
	// Init
	// ---------------------------------------------------------------------------
	public BcServerParser(Socket socket) {
		this.clientSocket = socket;
	}
	
	// ---------------------------------------------------------------------------
	// Run
	// ---------------------------------------------------------------------------
	@Override
	public void run() {
		try {
			clientIp = (clientSocket.getInetAddress()).getHostAddress();
			clientPort = clientSocket.getPort();
			System.out.println("[BcServerParser][" + BcServerThreadPoolTask.getThreadNames() + "] Client Connected. [" + clientIp + ":" + clientPort + "]");
			
			outputStream = clientSocket.getOutputStream();
			inputStream = clientSocket.getInputStream();
			br = new BufferedReader(new InputStreamReader(inputStream));
			writer = new PrintWriter(new OutputStreamWriter(outputStream));
			
			responseMsg = new Date().toString() + " BcServer Connected.";
			writer.println(responseMsg);
			writer.flush();
			
			if(!clientSocket.isClosed()) {
				requestMsg = br.readLine();
			}
			while(requestMsg != null) {
				// Process Command Setting
				if(requestMsg.equalsIgnoreCase("stop")) {
					break;
				} else if(requestMsg.equalsIgnoreCase("pause")) {
					responseMsg = new Date().toString() + " BcServer PAUSE.";
					writer.println(responseMsg);
					writer.flush();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try { 
				System.out.println("[BcServerParser][" + BcServerThreadPoolTask.getThreadNames() + "] Client Disconnected. [" + clientIp + ":" + clientPort + "]");
				responseMsg =  new Date().toString() + " BcServer Connect Close.";
				writer.println(responseMsg);
				writer.flush();
				
				clientSocket.close();
				clientSocket	= null;
				outputStream	= null;
				inputStream 	= null;
				br 			 	= null;
				writer 		 	= null;
			} catch(Exception e) {}
		}
		
	}
	
	
}
