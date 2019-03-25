package com.network.bc;

public class ThreadConst {

	// ----------------------------------------------------------------------
	// Thread Status
	/*
		객체 생성	NEW				스레드 객체가 생성되었으나 start() 메소드가 호출되지 않은 상태
		실행 대기	RUNNABLE		실행 상태로 언제든지 갈 수 있는 상태
		일시정지	WAITING			다른 스레드가 통지할 때까지 기다리는 상태
		일시정지	TIMED_WAITING	주어진 시간 동안 기다리는 상태
		일시정지	BLOCKED			사용하고자 하는 객체의 락이 풀릴 때까지 기다리는 상태
		종료		TERMINATED		실행을 마친 상태
	*/
	// ----------------------------------------------------------------------
	public static final String STATUS_NEW 				= "NEW";
	public static final String STATUS_RUNNABLE 			= "RUNNABLE";
	public static final String STATUS_WAITING 			= "WAITING";
	public static final String STATUS_TIMED_WAITING 	= "TIMED_WAITING";
	public static final String STATUS_BLOCKED 			= "BLOCKED";
	public static final String STATUS_TERMINATED 		= "TERMINATED";
	
	
	
}
