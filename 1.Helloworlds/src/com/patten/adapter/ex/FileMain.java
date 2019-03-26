package com.patten.adapter.ex;

import java.io.IOException;

public class FileMain {
	
	public static void main(String[] args) {
		FileIOTest f = new FileProperties();
		try {
			f.readFromFile("/Users/minsungkim/git/helloworld/1.Helloworlds/test/file.txt");
			f.setValue("year", "2004");
			f.setValue("month", "4");
			f.setValue("day", "21");
			f.writeToFile("/Users/minsungkim/git/helloworld/1.Helloworlds/test/newFile1.txt");
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
