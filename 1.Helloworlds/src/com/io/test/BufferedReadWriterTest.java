package com.io.test;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class BufferedReadWriterTest {

	public static void main(String[] args) {
		
		long time = System.currentTimeMillis(); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmSS", Locale.KOREA);
		String currentTime = sdf.format(new Date(time));
		String toDay = currentTime.toString();
		
		String filePath = "/Users/minsungkim/eclipse-workspace/1.Helloworlds/test/testfile_201903251226659.txt";
		String copyFilePath = "/Users/minsungkim/eclipse-workspace/1.Helloworlds/test/testCopyfile_" + toDay +".txt";
		File file = new File(filePath);
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			String line = System.getProperty("line.separator");
			br = new BufferedReader(new FileReader(file));
			bw = new BufferedWriter(new java.io.FileWriter(copyFilePath));
			
			String contents = "";
			int idx = 0;
			int totalLine = totalFileLine(filePath);
			while((contents = br.readLine()) != null) {
				idx++;
				bw.write(contents);
				if(totalLine != idx) {
					bw.write(line);
				}
				bw.flush();
			}
			
			bw.close();
			br.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			
		}
	}
	
	/**
	 * Total File Line Method 
	 * @param filePath
	 * @return line
	 */
	public static int totalFileLine(String filePath) {
		int line = 0;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filePath));
			while(br.readLine() != null) {
				line++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return line;
	}
}
