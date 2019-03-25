package com.io.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

	public static void main(String[] args) {
		String file_path = "/Users/minsungkim/eclipse-workspace/1.Helloworlds/test/testfile_201903251226659.txt";
		File file = new File(file_path);
		FileReader fr = null;
		int idx = 0;
		
		if(file.exists()) {
			try {
				fr = new FileReader(file);
				while((idx = fr.read()) != -1) {
					System.out.println((char)idx);
				}
				fr.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
	}
	
}
