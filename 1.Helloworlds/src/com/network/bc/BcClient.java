package com.network.bc;

public class BcClient {

	public static void main(String[] args) {
		
		// ---------------------------------------------------------------------------
		// Local Variable
		// ---------------------------------------------------------------------------
		BcClientService bct = null;
		String serverIp = "127.0.0.1";
		int serverPort = 15000;
		
		try {
			bct = new BcClientService();
			bct.init(serverIp, serverPort);
			bct.run();
			
		} catch (Exception e) {
			e.printStackTrace();
			bct = null;
		}
	}
}
