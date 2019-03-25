package com.mnwise.common.jeonmun;

public class JeonmunGroup {
	public String strName = null;
	public char cType = '*';
	public int iRecords = -1;
	public int iFields = -1;
	public int iFieldStartIndex = -1;
	
	public JeonmunGroup(String strName, char cType, int iRecords, int iFields, int iFieldStartIndex) {
		this.strName = strName;
		this.cType = cType;
		this.iRecords = iRecords;
		this.iFields = iFields;
		this.iFieldStartIndex = iFieldStartIndex;
	}
	
	public int getIndex(int iField) {
		return iFieldStartIndex + iField;
	}
	
	public String toString() {
		StringBuffer sbOut = new StringBuffer();
		
		sbOut.append("GroupName:");
		sbOut.append(strName);
		sbOut.append(", ");
		sbOut.append("GroupType:");
		sbOut.append(cType);
		sbOut.append(", ");
		sbOut.append("Fields:");
		sbOut.append(iFields);		
		sbOut.append(", ");
		sbOut.append("StartIndex:");
		sbOut.append(iFieldStartIndex);
		sbOut.append(", ");
		sbOut.append("Records:");
		sbOut.append(iRecords);
		
		return sbOut.toString();
	}
}

