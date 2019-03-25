package com.network.bc.util;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class PropertiesUtil {
	static PropertiesUtil propLoad = new PropertiesUtil();
	static Properties prop = new Properties();
	
	public static void propertiesLoad() {
		
		try{
			// 환경파일 로드방식 변경
			prop.load( propLoad.getClass().getResourceAsStream("/config/BcServerConfig.proprties") );
			
			Enumeration<?> enums = prop.propertyNames();
			String key = null;
			String value = null;
			
			while(enums.hasMoreElements()) {
				key = (String) enums.nextElement();
				value = prop.getProperty(key);
				prop.setProperty(key, value);
			}
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 프로퍼티 값 가져오기 
	 * 
	 * @param key		프로퍼티 키 
	 * @return
	 */
	public String getProperty(String key) {
		String val = prop.getProperty(key);
		return val == null ? "" : val;
	}
	
	/**
	 * 프로퍼티 값 가져오기 
	 * 
	 * @param key			프로퍼티 키
	 * @param defaultValue	기본값
	 * @return
	 */
	public String getProperty(String key, String defaultValue) {
		String val = prop.getProperty(key);
		return val == null || val.equals("") ? defaultValue : val;
	}
	
	
	
}
