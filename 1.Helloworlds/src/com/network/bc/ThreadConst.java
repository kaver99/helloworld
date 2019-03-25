package com.network.bc;

public class ThreadConst {

	// ----------------------------------------------------------------------
	// Thread Status
	/*
		��ü ����	NEW				������ ��ü�� �����Ǿ����� start() �޼ҵ尡 ȣ����� ���� ����
		���� ���	RUNNABLE		���� ���·� �������� �� �� �ִ� ����
		�Ͻ�����	WAITING			�ٸ� �����尡 ������ ������ ��ٸ��� ����
		�Ͻ�����	TIMED_WAITING	�־��� �ð� ���� ��ٸ��� ����
		�Ͻ�����	BLOCKED			����ϰ��� �ϴ� ��ü�� ���� Ǯ�� ������ ��ٸ��� ����
		����		TERMINATED		������ ��ģ ����
	*/
	// ----------------------------------------------------------------------
	public static final String STATUS_NEW 				= "NEW";
	public static final String STATUS_RUNNABLE 			= "RUNNABLE";
	public static final String STATUS_WAITING 			= "WAITING";
	public static final String STATUS_TIMED_WAITING 	= "TIMED_WAITING";
	public static final String STATUS_BLOCKED 			= "BLOCKED";
	public static final String STATUS_TERMINATED 		= "TERMINATED";
	
	
	
}
