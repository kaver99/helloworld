package com.io.test;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FileWriterTest {
	
	public static void main(String[] args) {
		
		long time = System.currentTimeMillis(); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmSS", Locale.KOREA);
		String currentTime = sdf.format(new Date(time));
		String toDay = currentTime.toString();
		
		System.out.println(toDay);
		
		String filePath = "/Users/minsungkim/eclipse-workspace/1.Helloworlds/test/testfile_" + toDay +".txt";
		FileOutputStream out = null;
		String line = System.getProperty("line.separator");
		
		// File 내용
		StringBuffer fileContents = new StringBuffer();
		fileContents.append("가나다라마바사아자차카파");
		fileContents.append(line);
		fileContents.append("abcdefghijklmnopqrstuvwxyz");
		
		byte[] bFileContents = fileContents.toString().getBytes();
		
		try {
			// 해당 파일 경로로 내용출력
			out = new FileOutputStream(filePath);
			out.write(bFileContents);
			out.close();
			fileContents = null;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
