package com.network.bc;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BcServerListener implements Runnable {
	// ---------------------------------------------------------------------------
	// Global Variable
	// ---------------------------------------------------------------------------
	ServerSocket serverSocket 		= null;
	Socket clientSocket				= null;
	BcServerParser bsp 				= null;
	int serverPort					= 15000;
	BcServerThreadPool bstp			= null;
	private final int THREAD_CNT	= 2;
	ExecutorService ececutorService	= Executors.newFixedThreadPool(THREAD_CNT);
	
	// ---------------------------------------------------------------------------
	// Init
	// ---------------------------------------------------------------------------
	public BcServerListener() {
		
	}
	
	// ---------------------------------------------------------------------------
	// Run
	// ---------------------------------------------------------------------------
	@Override
	public void run() {
		try {
			serverSocket = new ServerSocket(serverPort);
			System.out.println("[BcServerListener][" + BcServerThreadPoolTask.getThreadNames() + "] TCP/IP " + serverPort + " Port Open.");
			
			// Listener Thread Start
			while(true) {
				clientSocket = serverSocket.accept();
				clientSocket.setSoTimeout(5000);
				ececutorService.submit(new BcServerParser(clientSocket));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{ 
				serverSocket.close();
				clientSocket.close();
				ececutorService.shutdown();
				serverSocket	= null;
				clientSocket	= null;
				bsp 			= null;
				ececutorService = null;
			} catch(Exception e) {}
		}
	}
}
