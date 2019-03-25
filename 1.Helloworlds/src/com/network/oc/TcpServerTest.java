package com.network.oc;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServerTest {
	public static void main(String[] args) {
		int iPort = 15000;
		try {
			@SuppressWarnings("resource")
			ServerSocket server = new ServerSocket(iPort);
			Socket client = null;
			TcpServerThread tTcpServerThread = null;
			
			while(true) {
				client = server.accept();
				System.out.println("client : " + client);
				tTcpServerThread = new TcpServerThread(client);
				tTcpServerThread.start();
				System.out.println("ThreadName : " + tTcpServerThread.getName() + " Connect.");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
