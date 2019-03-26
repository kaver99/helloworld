package com.excel.example;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelFileWriteReadEx {

	public static void main(String[] args) {
		
		try {
			HSSFWorkbook workbook = new HSSFWorkbook();
			
			// sheet name setting
			HSSFSheet sheet = workbook.createSheet("sheetTest");
			HSSFRow row = sheet.createRow(0);
			HSSFCell cell = row.createCell((short) 0);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);  //한글 처리
			cell.setCellValue("1번셀제목");

			cell = row.createCell((short) 1);
			cell.setCellValue("2번셀제목");
			
			cell = row.createCell((short) 2);
			cell.setCellValue("3번셀제목");
			
			row = sheet.createRow(1);
			String[] cell_value = {"테스트셀","테스트입니다.","testd"};
			for (int i = 0 ; i < cell_value.length; i++){
	            cell = row.createCell((short)i);
	            cell.setEncoding(HSSFCell.ENCODING_UTF_16);
	            cell.setCellValue(cell_value[i]);
	        }

			String filePath = "/Users/minsungkim/git/helloworld/1.Helloworlds/test/excel.xls";
		    FileOutputStream bos = new FileOutputStream(filePath);
		    // excel file writer
		    workbook.write(bos);
		    byte[] barray = bos.toString().getBytes();
		    InputStream is = new ByteArrayInputStream(barray);
		    bos.close();
		    is.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}

		
	}
}
