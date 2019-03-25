package com.network.bc.util;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class PropertiesUtil {
	static PropertiesUtil propLoad = new PropertiesUtil();
	static Properties prop = new Properties();
	
	public static void propertiesLoad() {
		
		try{
			// ȯ������ �ε��� ����
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
	 * ������Ƽ �� �������� 
	 * 
	 * @param key		������Ƽ Ű 
	 * @return
	 */
	public String getProperty(String key) {
		String val = prop.getProperty(key);
		return val == null ? "" : val;
	}
	
	/**
	 * ������Ƽ �� �������� 
	 * 
	 * @param key			������Ƽ Ű
	 * @param defaultValue	�⺻��
	 * @return
	 */
	public String getProperty(String key, String defaultValue) {
		String val = prop.getProperty(key);
		return val == null || val.equals("") ? defaultValue : val;
	}
	
	
	
}
