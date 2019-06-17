package com.mnwise.common.jeonmun;

/**
 *전문(멀티행)
 *
 *1. 전문 포맷
 *1) 그룹명
 *- 그룹명은 반드시 @s@로 시작
 *- @s@ 이후의 그룹명은 @g로 시작 
 *2) 그룹 타입
 *- 고정(f): 고정 그룹의 끝은 개행문자로 끝남
 *- 반복(r): 각 레코드의 끝은 개행문자로 끝남
 *3) 필드 갯수
 *- 고정(f): 총 필드 갯수
 *- 반복(r): 한 레코드를 구성하는 필드 갯수
 *4) 샘플
 * @s@,f,3,id,name,email,slot1,slot2\r\n
 * @s@,f,3,id,name,email\r\n
 * @g1,f,5,ff1,ff2,ff3,f4,f5\r\n
 * @g2,r,3,rf1,rf2,rf3\r\n
 * rf1,rf2,rf3\r\n
 * rf1,rf2,rf3\r\n
 *
 *2. 구분자
 *1) 전문에서 1바이트 구분자 하나를 사용할 수 있다.
 *2) 개행문자(\r\n, \n)를 구분자로 사용할 수 있다.
 *- 가독성을 높이기 위해 그룹의 끝과 반복 레코드의 끝에 개행문자(\r\n, \n)를 사용
 *
 *3. 반복 레코드 수를 지정하지 않아도 됨
 *1) 반복 레코드의 끝은 다음 그룹 전까지 또는 전문의 끝을 반복 레코드의 끝으로 인식
 *
 *4. 구분자 다음에는 값이 있어야 한다
 *1) 전문 생성의 편의를 위해 전문끝의 개행문자(\r\n, \n)는 붙여도 되지만 파싱시 무시한다.
 *2) 전문 끝이 구분자로 끝나면 마지막 필드의 값은 공백으로 저장됨
 *- 그룹 헤더의 필드 갯수보다 많으면 파싱시 에러 리턴
 */

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Vector;

public class Jeonmun {
	private static final String GROUP_PREFIX = "@g";
	private static final String GROUP_START = "@s@";
	
	/**
	 * 개행문자(\r\n, \n)를 구분자로 사용할지 설정
	 * 
	 * @param bUse
	 */
	private boolean bUseDelimiterCRLF = true;	// 개행문자(\r\n, \n)를 구분자로 사용함
	public void setUseDelimiterCRLF(boolean bUse) {
		this.bUseDelimiterCRLF = bUse;
	}
	
	public boolean parsing(String strJeonmun, String strDelimeter) {
		return parsing(strJeonmun, strDelimeter.charAt(0));
	}
	
	/**
	 * 전문의 문법이 맞는지 분석한다.
	 * 
	 *  @param strJeonmun	전문
	 *  @param cDelimeter	구분자
	 *  @return true면 분석성공
	 */
	String[] astrAllField = null;	// 필드 구분자와 개행문자를 뺀 값을 배열에 저장 한다. 
	Hashtable<String, JeonmunGroup> htGroup = new Hashtable<String, JeonmunGroup>();
	StringBuffer sbErrMsg = new StringBuffer();
	public boolean parsing(String strJeonmun, char cDelimeter) {
		int iTokens = 0;
		String strGroupName = null;
		String strPrevGroupName = null;
		char cGroupType = '*';
		int iGroupFields = -1;	// 필드 갯수(고정부는 전체 필드 갯수, 반복부는 한 레코드의 필드 갯수)
		int iBegin = -1;
		int iRecordCount = -1;
		int iPos = 0;
		JeonmunGroup jgDup = null;
		Vector<String> vctGroup = new Vector<String>();	// 그룹명을 순서데로 저장하기 위해서 사용
		boolean bResult = true;
		
		this.astrAllField = split(strJeonmun, cDelimeter);
		iTokens = this.astrAllField.length;
		this.htGroup.clear();
		this.sbErrMsg.setLength(0);
		
		while(iPos < iTokens) {
			strGroupName = this.astrAllField[iPos];
			// 그룹명이 @s@나 @g로 시작하지 않으면 종료, 필드 갯수가 실제 데이터의 필드 갯수 보다 작은 경우 종료됨
			if(!strGroupName.equals(GROUP_START) && !strGroupName.startsWith(GROUP_PREFIX)) {
				this.sbErrMsg.append("[ERROR] ");
				this.sbErrMsg.append(iPos+1);
				this.sbErrMsg.append(" 번째 필드의 값이 \"");
				this.sbErrMsg.append(strGroupName);
				this.sbErrMsg.append("\"인데, 그룹명은 @s@이거나 @g로 시작해야 합니다. ");
				this.sbErrMsg.append(strPrevGroupName);
				this.sbErrMsg.append(" 그룹의 필드 갯수를 확인해주세요.");
				this.sbErrMsg.append("\r\n");
				bResult = false;
				break;
			}
			jgDup = this.htGroup.get(strGroupName);
			if(jgDup != null) {
				this.sbErrMsg.append("[WARNING] 동일한 그룹명이 존재합니다: ");
				this.sbErrMsg.append(strGroupName);
				this.sbErrMsg.append("\r\n");
				bResult = false;
				break;
			}
			
			cGroupType = this.astrAllField[++iPos].charAt(0);
			iGroupFields = Integer.parseInt(this.astrAllField[++iPos]);
			if(strGroupName.equals(GROUP_START)) {
				if(cGroupType != 'f') {
					this.sbErrMsg.append("[ERROR] @s@ 그룹의 타입은 f만 사용할 수 있습니다.");
					this.sbErrMsg.append("\r\n");
					bResult = false;
					break;
				}
				this.htGroup.put(strGroupName, new JeonmunGroup(strGroupName, cGroupType, 1, iGroupFields, ++iPos));
				vctGroup.add(strGroupName);
				iPos = iPos + iGroupFields;	// 다음 그룹의 시작으로 옮김
			} else if(strGroupName.startsWith(GROUP_PREFIX)) {
				if(cGroupType == 'f') {
					this.htGroup.put(strGroupName, new JeonmunGroup(strGroupName, cGroupType, 1, iGroupFields, ++iPos));
					vctGroup.add(strGroupName);
					iPos = iPos + iGroupFields;	// 다음 그룹의 시작으로 옮김
				} else if(cGroupType == 'r') {
					iBegin = ++iPos;	// 데이터 필드가 시작하는 위치로 이동
					iPos = iBegin;
					iRecordCount = 0;
					while(iPos < iTokens) {
						// 다음 그룹의 시작인지 검사
						if(this.astrAllField[iPos].startsWith(GROUP_PREFIX)) {
							break;
						}
						iRecordCount++;	// 반복 레코드 수
						iPos = iPos + iGroupFields;
					}
					if(iPos > iTokens) {
						iRecordCount--;
						iPos = iPos - iGroupFields;
						this.sbErrMsg.append("[ERROR] 반복 그룹 ");
						this.sbErrMsg.append(strGroupName);
						this.sbErrMsg.append("의 필드 갯수(");
						this.sbErrMsg.append(iGroupFields);
						this.sbErrMsg.append(")로 레코드를 계산했을때, 레코드의 끝이 다음 그룹의 시작이 아니거나 전문의 끝이 아닙니다.");
						this.sbErrMsg.append("\r\n");
						bResult = false;
						break;
					}					
					this.htGroup.put(strGroupName, new JeonmunGroup(strGroupName, cGroupType, iRecordCount, iGroupFields, iBegin));
					vctGroup.add(strGroupName);
				} else {
					this.sbErrMsg.append("[ERROR] 그룹타입은 f 또는 r 이어야 합니다.");
					this.sbErrMsg.append("\r\n");
					bResult = false;
					break;
				}
			} else {
				this.sbErrMsg.append("[ERROR] 그룹명은 반드시 @g로 시작해야 합니다.");
				this.sbErrMsg.append("\r\n");
				bResult = false;
				break;
			}
			
			// 다음 그룹의 시작점을 가리키는 인덱스(iPos)가 전문의 끝을 넘어갔는지 확인
			if(iPos > iTokens) {
				this.sbErrMsg.append("[ERROR] ");
				this.sbErrMsg.append(iPos);
				this.sbErrMsg.append(" 번째 필드의 데이터가 없습니다. ");
				this.sbErrMsg.append(strGroupName);
				this.sbErrMsg.append("그룹의 필드 갯수가 실제 데이터와 맞지 않습니다.");
				this.sbErrMsg.append("\r\n");
				bResult = false;
			}
			strPrevGroupName = strGroupName;
		}
		
		// 전문 파싱에 오류가 있으면 분석한 내용을 남김
		if(!bResult) {
			this.sbErrMsg.append(strJeonmun);
			this.sbErrMsg.append("\r\n");
			this.sbErrMsg.append("Total Tokens: ");
			this.sbErrMsg.append(this.astrAllField.length);
			this.sbErrMsg.append("\r\n");
			
			for(int i = 0; i < vctGroup.size(); i++) {
				strGroupName = vctGroup.get(i);
				jgDup = this.htGroup.get(strGroupName);
				this.sbErrMsg.append(jgDup.toString());
				this.sbErrMsg.append("\r\n");
			}
		}
		
		return bResult;
	}

	public String getErrMsg() {
		return this.sbErrMsg.toString();
	}
	
	/**
	 * 전문을 구분자로 구분하여 값을 배열에 저장
	 * 전문 끝의 개행문자는 제거
	 * 
	 * @param strJeonmun	전문
	 * @param cDelimeter	구분자
	 * @return 값이 저장된 배열
	 */
	private String[] split(String strJeonmun, char cDelimeter) {
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
			} else if( this.bUseDelimiterCRLF && '\n' == strJeonmun.charAt(i) ) {
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
	
	/**
	 * 반복 그룹의 레코드 갯수
	 * 
	 * @param strGroupName	그룹명
	 * @return	-1(그룹이 없음)
	 */
	public int records(String strGroupName) {
		// this.htGroup.get = new JeonmunGroup(strGroupName, cGroupType, iRecordCount, iGroupFields, iBegin);
		// 생성자로 지정한 인스턴스를 JeonmunGroup 객체로 선언  
		JeonmunGroup gr = this.htGroup.get(strGroupName);
		int iRecords = -1;
		
		if(gr == null)
			iRecords = -1;
		else
			iRecords = gr.iRecords;
		
		return iRecords;
	}

	/**
	 * 고정 그룹의 필드 값을 꺼냄
	 * 
	 * @param strGroupName	그룹명
	 * @param iFieldIndex	필드 인덱스(1부터 시작)
	 * @return 필드 값
	 */
	public String get(String strGroupName, int iFieldIndex) {
		String strValue = null;
		JeonmunGroup gr = this.htGroup.get(strGroupName);
		
		strValue = this.astrAllField[gr.getIndex(iFieldIndex - 1)];
		
		return strValue;
	}
	
	/**
	 * 반복 그룹의 필드 값을 꺼냄
	 * 
	 * @param strGroupName	그룹명
	 * @param iRecordIndex	레코드 인덱스(1부터 시작)
	 * @param iFieldIndex	필드 인덱스(1부터 시작)
	 * @return	필드 값
	 */
	public Object get(String strGroupName, int iRecordIndex, int iFieldIndex) {
		String strValue = null;
		JeonmunGroup gr = this.htGroup.get(strGroupName);
		System.out.println("iRecordIndex - 1 : " + (iRecordIndex - 1));
		System.out.println("gr.iFields : " + gr.iFields);
		System.out.println("gr.getIndex(iFieldIndex-1 : " + gr.getIndex(iFieldIndex-1));
		System.out.println(((iRecordIndex - 1) * gr.iFields) + gr.getIndex(iFieldIndex-1));
		strValue = this.astrAllField[((iRecordIndex - 1) * gr.iFields) + gr.getIndex(iFieldIndex-1)];
		
		return strValue;		
	}
	
	public static void main(String[] args) {
		Jeonmun jeonmun = new Jeonmun();
//		jeonmun.parsing("@s@,f,3,id,name,email", ',');
		
		StringBuffer sb = new StringBuffer();
		sb.append("@g1@|r|5|data1|data2|data3|data4|data5\r\n");
		sb.append("data6|data7|data8|data9|data10");
		jeonmun.parsing(sb.toString(), '|');
		System.out.println(jeonmun.get("@g1@",1,1));
		System.out.println(jeonmun.records("@g1@"));
		
	}
}

