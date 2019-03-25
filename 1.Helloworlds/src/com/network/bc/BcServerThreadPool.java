package com.network.bc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BcServerThreadPool {
	// ---------------------------------------------------------------------------
	// Global Variable
	// ---------------------------------------------------------------------------
	Runnable threadTask				= null;
	static String status			= null;
	static String threadName 		= null;
	
	private static int THREAD_CNT = 5;
	private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_CNT);

	// ---------------------------------------------------------------------------
	// Init
	// ---------------------------------------------------------------------------
	@SuppressWarnings("static-access")
	public void Init(int cnt) {
		this.THREAD_CNT = cnt;
	}
	
	// ---------------------------------------------------------------------------
	// ThreadPool Assignment
	// ---------------------------------------------------------------------------
	public static String threadPoolAssignment(Runnable task) {
		
		try {
			//for(int i = 0 ; i < THREAD_CNT ; i++) {
				threadPool.submit(task);
			//}
			status = ThreadConst.STATUS_NEW;
		} catch(Exception e) {
			
		} finally {
			threadPool.shutdown();
			status = ThreadConst.STATUS_TERMINATED;
		}
		
		return status;
	}
	
	
}
