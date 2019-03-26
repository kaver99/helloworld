package com.properties.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReadExample {
	
	public static void main(String[] args) {
		Properties p = new Properties();
		
		String filePath = "/Users/minsungkim/git/helloworld/1.Helloworlds/test/databaseex.properties";
		FileInputStream fin;
		try {
			fin = new FileInputStream(filePath);
			p.load(fin);
			fin.close();
			
			System.out.println("driver=" + p.getProperty("driver"));
			System.out.println("url=" + p.getProperty("url"));
			System.out.println("username=" + p.getProperty("username"));
			System.out.println("password=" + p.getProperty("password"));
			System.out.println("maxconn=" + p.getProperty("maxconn"));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
