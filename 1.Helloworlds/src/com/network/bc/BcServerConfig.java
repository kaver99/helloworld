package com.network.bc;

import java.io.IOException;
import java.util.Properties;

public class BcServerConfig {
	// ---------------------------------------------------------------------------
	// Global Variable
	// ---------------------------------------------------------------------------
	private static BcServerConfig propLoad = new BcServerConfig();
	
	// ---------------------------------------------------------------------------
	// Prop Load
	// ---------------------------------------------------------------------------
	public static String propertiesLoad() {
		String settingList = null;
		String sServerPath = null;
		
		try{
			Properties prop = new Properties();
			// Config Load
			prop.load( propLoad.getClass().getResourceAsStream("/BcServerConf.proprties") );
			
			sServerPath = prop.getProperty("server.path", "").trim();
			if(sServerPath.isEmpty()){
				new Exception("BcServer Config - ���� ��� ������ �Ǿ� ���� �ʽ��ϴ�.");
			}
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return settingList;
	}
}
