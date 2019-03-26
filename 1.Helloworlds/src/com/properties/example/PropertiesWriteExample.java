package com.properties.example;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesWriteExample {

	public static void main(String[] args) {
		// Write Test
		Properties p = new Properties();
		p.put("driver", "oracle.jdbc.driver.OracleDriver");
		p.setProperty("url", "jdbc:oracle:thin:@localhost:51521:xe");
		p.setProperty("maxconn", "10");
		p.setProperty("username", "violet");
		p.setProperty("password", "violet");
		
		String filePath = "/Users/minsungkim/git/helloworld/1.Helloworlds/test/databaseex.properties";
		
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream(filePath);
			p.store(fout, "JDBC Config Setting");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			if(fout != null)
				try {
					fout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
		
	}
}
