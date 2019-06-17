package com.collection.example;

import java.util.ArrayList;
import java.util.Hashtable;

public class JeonmunData {

	private Hashtable<Integer, String> htColum = new Hashtable<Integer, String>();
	private static Hashtable<String, String> htRecord = new Hashtable<String, String>();
	
	private static ArrayList<String> arrHeadList = new ArrayList<String>();
	private static ArrayList<String> arrLoopList = new ArrayList<String>();
	private static ArrayList<String> arrayTotalRowList = new ArrayList<String>();
	
	/**
	 * jeonmun을 구분자에 맞춰 조각내어 배열로 담음
	 * @param jeonmun(전문)
	 * @param separator(구분자)
	 * @return arrayValue(전문 배열 데이터)
	 */
	public static String[] jeonmunSplit(String jeonmun, String separator) {
		int jLength = jeonmun.length();
		int startPoint = 0;
		int endPoint = 0;
		String jeonmunValue = null;
		
		ArrayList<String> arrayList = new ArrayList<String>();
		
		// 전문끝의 개행문자는 제거
		if('\n' == jeonmun.charAt(jLength-1)) {
			--jLength;
		if('\r' == jeonmun.charAt(jLength-1))
			--jLength;
		}
		
		int i = 0;
		for(i=0; i< jLength; i++) {
			// 구분자 일 경우
			if(jeonmun.matches(separator)) {
				endPoint = i;
				jeonmunValue = jeonmun.substring(startPoint, endPoint);
				arrayList.add(jeonmunValue);
				startPoint = i + 1;
			// 개행문자 일 경우	
			} else if(jeonmun.matches("\n")) {
				if(i > 0 && jeonmun.matches("\r")) {
					endPoint = i -1;
					jeonmunValue = jeonmun.substring(startPoint, endPoint);
					arrayList.add(jeonmunValue);
					startPoint = i + 1;
				} else {
					endPoint = i;
					jeonmunValue = jeonmun.substring(startPoint, endPoint);
					arrayList.add(jeonmunValue);
					startPoint = i + 1;
				}
			} 
		}
		endPoint = i;
		jeonmunValue = jeonmun.substring(startPoint, endPoint);
		arrayList.add(jeonmunValue);
		
		String[] arrayValue = new String[arrayList.size()];
		for(i = 0; i < arrayList.size(); i++) {
			arrayValue[i] = arrayList.get(i);
		}
		arrayList.clear();
		arrayList = null;
		
		return arrayValue;
	}
	
	
	public static String[] split(String strJeonmun, char cDelimeter) {
		int iLen = strJeonmun.length();
		int iBegin = 0;
		int iEnd = 0;
		int i = 0;
		String strValue = null;
//		System.out.println("iLen="+iLen);
		ArrayList<String> arToken = new ArrayList<String>();

		// 전문끝의 개행문자는 제거
		if('\n' == strJeonmun.charAt(iLen-1)) {
			--iLen;
			if('\r' == strJeonmun.charAt(iLen-1))
				--iLen;
		}
		
		for(i = 0; i < iLen; i++) {
			if( cDelimeter == strJeonmun.charAt(i) ) {
				iEnd = i;
				strValue = strJeonmun.substring(iBegin, iEnd);
				arToken.add(strValue);
//				System.out.println("iStart="+iBegin+", iEnd="+iEnd + "|" + strValue +"|");
				iBegin = i + 1;
			} else if('\n' == strJeonmun.charAt(i) ) {
				if(i > 0 && '\r' == strJeonmun.charAt(i-1)) {
					iEnd = i - 1;
					strValue = strJeonmun.substring(iBegin, iEnd);
					arToken.add(strValue);
//					System.out.println("iStart="+iBegin+", iEnd="+iEnd + "|" + strValue +"|");					
					iBegin = i + 1;
				} else {
					iEnd = i;
					strValue = strJeonmun.substring(iBegin, iEnd);
					arToken.add(strValue);
//					System.out.println("iStart="+iBegin+", iEnd="+iEnd + "|" + strValue +"|");							
					iBegin = i + 1;
				}
			}
		}
		iEnd = i;
		strValue = strJeonmun.substring(iBegin, iEnd);
		arToken.add(strValue);
//		System.out.println("iStart="+iBegin+", iEnd="+iEnd + "|" + strValue +"|");		
		
		String[] astrValue = new String[arToken.size()];
		for(i = 0; i < arToken.size(); i++) {
			astrValue[i] = arToken.get(i);
		}
		arToken.clear();
		arToken = null;

		return astrValue;
	}	
	
	
	public static String getRow(String headerName, int num) {
		String data = "";
		if(headerName == "H") {
			data = arrHeadList.get(num);
		} else if(headerName == "R") {
			data = arrLoopList.get(num);
		} 
		return data;
	}
	
	/**
	 * 고정부 가져오기
	 * @param headerName
	 * @param rowNum
	 * @param colNum
	 * @return
	 */
	public static String getColum(String headerName, int rowNum, int colNum) {
		String rowData = "";
		String[] colData = null;
		rowData = arrHeadList.get(rowNum - 1);
		colData = rowData.split("\\|");
		return colData[colNum + 1];
	}
	
	
	public static void main(String[] args) {
		// db에서 가져온 데이터로 가정
		StringBuffer sb = new StringBuffer();
//		sb.append("H|1|data1|data2|data3|data4|data5|data6" + "\r\n");
//		sb.append("H|2|data1|data2|data3|data4|data5|data6" + "\r\n");
//		sb.append("H|3|data1|data2|data3|data4|data5|data6" + "\r\n");
//		sb.append("R|1|Rdata1|Rdata2|Rdata3|Rdata4|Rdata5|Rdata6" + "\r\n");
//		sb.append("R|2|Rdata7|Rdata8|Rdata9|Rdata10|Rdata11|Rdata12");
		sb.append("H|1|data1|data2|data3|data4|data5|data6" + "\r\n");
		sb.append("H|2|data21|data22|data23|data24|data25|data26" + "\r\n");
		sb.append("H|3|data31|data32|data33|data34|data35|data36" + "\r\n");
		sb.append("R|1|1|Rdata1|Rdata2|Rdata3|Rdata4|Rdata5|Rdata6" + "\r\n");
		sb.append("R|1|2|Rdata11|Rdata12|Rdata13|Rdata14|Rdata15|Rdata16" + "\r\n");
		sb.append("R|2|1|Rdata21|Rdata22|Rdata23|Rdata24|Rdata25|Rdata26");
		
//		System.out.println(sb.toString());
		
		String jeonmun = sb.toString();
		System.out.println("============================================================");
		htRecord.clear();
		// | 처리 시 앞에 특수문자 인식을 위해 "\\" 적용해야 정상 작동
		//String[] jeonmunValue = JeonmunData.split(jeonmun, '|');
		String[] jeonmunValue = jeonmun.split("\r\n");
//		String[] rowValue = null;
		String header = "";
		// row단위로 개행(\r\n)에 맞춰서 나눔
		for(int rowIdx = 0; rowIdx < jeonmunValue.length; rowIdx++) {
//			rowValue = jeonmunValue[rowIdx].split("\\|");
			header = jeonmunValue[rowIdx].trim();
			if(header.startsWith("H")) {
				arrHeadList.add(header);
			} else if(header.startsWith("R")) {
				
				arrLoopList.add(header);
			} else {
				System.out.println("Data Header Error.");
			}
		}
//			arrayTotalRowList.add(jeonmunValue[rowIdx].trim());
			
			// 컬럼별로 구분자(|)에 맞춰서 나눔
//			for(int columnIdx = 0; columnIdx < rowValue.length; columnIdx++) {
//				System.out.println(rowValue[columnIdx].trim());
//			}
			
		
//		System.out.println(JeonmunData.getRow("H", 1));
		
		// 헤더부 처리
//		java.util.Iterator<String> headIt = arrHeadList.iterator();
//		while(headIt.hasNext()) {
//			System.out.println("Head Row : " + headIt.next());
//		}
		
		// 반복부 처리
//		java.util.Iterator<String> loopIt = arrLoopList.iterator();
//		while(loopIt.hasNext()) {
//			System.out.println("Loop Row : " + loopIt.next());
//		}
		
		System.out.println("H1 getColum : " + JeonmunData.getColum("H", 1, 1));
		System.out.println("H2 getColum : " + JeonmunData.getColum("H", 2, 3));
		
//		
//		System.out.println("getColum : " + JeonmunData.getColum("R", 1, 1));
		// HEAD : [H|1|data1|data2|data3|data4|data5|data6, H|2|data1|data2|data3|data4|data5|data6, H|3|data1|data2|data3|data4|data5|data6]
		//LOOP : [R|1|1|Rdata1|Rdata2|Rdata3|Rdata4|Rdata5|Rdata6, R|1|2|Rdata11|Rdata12|Rdata13|Rdata14|Rdata15|Rdata16, R|2|1|Rdata21|Rdata22|Rdata23|Rdata24|Rdata25|Rdata26]
				
	}
}
