package com.network.bc;

public class BcServerThreadPoolTask {
	
	// ---------------------------------------------------------------------------
	// Global Variable
	// ---------------------------------------------------------------------------
	static String status 		= null;
	static String threadName 	= null;
	
	public static String threadStatus() {
		
		
		return status;
	}
	
	public static String getThreadNames() {
		threadName = Thread.currentThread().getName();
		return threadName;
	}
	

}
