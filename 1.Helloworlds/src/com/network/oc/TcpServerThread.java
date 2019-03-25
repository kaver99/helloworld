package com.network.oc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class TcpServerThread extends Thread {
	
	private Socket socket = null;
	private BufferedReader br = null;
	private PrintWriter writer = null;
	
	public TcpServerThread(Socket sct) {
		super(sct.getInetAddress().toString());
		socket = sct;
		
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void run() {
		String str = "";
		try {
			while(true) {
				str = br.readLine();
				if(str != null) {
					if(str.equals("stop")) break;
					writer.println(str);
					writer.flush();
				} else {
					break;
				}
			}
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
