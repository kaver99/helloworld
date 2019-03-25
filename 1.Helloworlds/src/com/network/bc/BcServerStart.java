package com.network.bc;

public class BcServerStart {
	// ---------------------------------------------------------------------------
	// Global Variable
	// ---------------------------------------------------------------------------
	
	public static void main(String[] args) {
		// ---------------------------------------------------------------------------
		// Local Variable
		// ---------------------------------------------------------------------------
		Thread thread = null;
		Runnable bsl = null;
		
		try {
			// ---------------------------------------------------------------------------
			// Config Print
			// ---------------------------------------------------------------------------
			printConfig();
			
			// ---------------------------------------------------------------------------
			// ServerSocket Listener Start
			// ---------------------------------------------------------------------------
			bsl = new BcServerListener();
			thread = new Thread(bsl);
			System.out.println("[BcServerMain][" + BcServerThreadPoolTask.getThreadNames() + "] Run BcServerListener Thread.");
			thread.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			thread = null;
			bsl = null;
		}
	}
	
	// ---------------------------------------------------------------------------
	// Config Init
	// ---------------------------------------------------------------------------	
	private static void printConfig() {
		
	}
	


}
