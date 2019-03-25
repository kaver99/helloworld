package com.mnwise.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;

public abstract class StringUtil {

	// �ӽú�й�ȣ����
	public static String shufflePasswd() {

		char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
				'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

		int idx = 0;
		StringBuffer sb = new StringBuffer();
		
		Random r = new Random();
        r.setSeed(new Date().getTime());
        for (int i = 0; i < 6; i++) {
            idx = (int) (charSet.length * r.nextDouble());
            sb.append(charSet[idx]);
        }

		return sb.toString();
	}

	public static boolean checkNull(String value) {
		if (value != null && !value.trim().equals("")) {
			return true;
		}
		else {
			return false;
		}
	}

	public static String getValueCheckNull(String value, String nullValue) {
		String returnValue = "";
		if (checkNull(value) && !value.equals(nullValue)) {
			returnValue = value;
		}
		else {
			returnValue = nullValue;
		}
		return returnValue;
	}

	public static int getValueCheckNull(String value, int nullValue) {
		int returnValue = 0;
		if (checkNull(value) && !value.equals(String.valueOf(nullValue))) {
			try {
				returnValue = Integer.parseInt(value);
			}
			catch (Exception e) {
				returnValue = nullValue;
			}
		}
		else {
			returnValue = nullValue;
		}
		return returnValue;
	}

	public static Hashtable<String, String> split(String sourceString, String token1, String token2) {
		Hashtable<String, String> htSplit = new Hashtable<String, String>();
		String[] strData = sourceString.split("[" + token1 + "]");

		for (int indexI = 0; indexI < strData.length; indexI++) {
			String[] tempData = strData[indexI].split("[" + token2 + "]");
			if (tempData.length == 2) {
				htSplit.put(tempData[0], tempData[1]);
			}
			else if (tempData.length == 1) {
				htSplit.put(tempData[0], "");
			}
		}
		return htSplit;
	}

	public static List<String> split(String sourceString, String token) {
		if (sourceString == null || sourceString.trim().equals(""))
			return null;
		List<String> lsSplit = new ArrayList<String>();
		String[] strData = sourceString.split("[" + token + "]");

		for (int indexI = 0; indexI < strData.length; indexI++) {
			lsSplit.add(strData[indexI]);
		}
		return lsSplit;
	}

	public static String[] getStringArrayBySplit(String sourceString, String token) {
		String[] strData = sourceString.split("[" + token + "]");
		return strData;
	}

	public static int[] getIntArrayBySplit(String sourceString, String token) {
		int[] returnValue;
		if (!checkNull(sourceString))
			return new int[0];
		String[] strData = sourceString.split("[" + token + "]");
		if (strData.length > 0) {
			returnValue = new int[strData.length];
			for (int indexI = 0; indexI < strData.length; indexI++) {
				returnValue[indexI] = Integer.parseInt(strData[indexI]);
			}
		}
		else {
			returnValue = new int[0];
		}
		return returnValue;
	}

	/**
	 * ���ڿ� ġȯ
	 * @param mainString ��� ���ڿ�
	 * @param oldString ġȯ�� ���ڿ�
	 * @param newString ��ġ�� ���ڿ�
	 * @return
	 */
	public static String replace(String mainString, String oldString, String newString) {
		if (mainString == null) {
			return null;
		}
		if (oldString == null || oldString.length() == 0) {
			return mainString;
		}
		if (newString == null) {
			newString = "";
		}

		int i = mainString.lastIndexOf(oldString);
		if (i < 0)
			return mainString;
		StringBuffer mainSb = new StringBuffer(mainString);
		while (i >= 0) {
			mainSb.replace(i, (i + oldString.length()), newString);
			i = mainString.lastIndexOf(oldString, i - 1);
		}
		return mainSb.toString();
	}

	/**
	 * ������ ���� ���� ��ŭ �߶� ��ȯ�մϴ�.
	 * @param value �ڸ����� �ϴ� ���ڿ�
	 * @param length �ڸ����� �ϴ� ����
	 * @return
	 */
	public static String right(String value, int length) {
		String returnValue = null;
		if (!checkNull(value))
			return returnValue;

		int valueLength = value.length();
		if (length < valueLength)
			return returnValue;

		return value.substring(valueLength - length, valueLength);
	}

	public static String truncateNicely(String s, int len, String tail) {
		if (s == null) {
			return null;
		}

		int srcLen = realLength(s);

		if (srcLen < len) {
			return s;
		}
		String tmpTail = tail;
		if (tail == null) {
			tmpTail = "";
		}
		int tailLen = realLength(tmpTail);
		if (tailLen > len) {
			return "";
		}
		char a;
		int i = 0;
		int realLen = 0;
		for (i = 0; i < len - tailLen && realLen < len - tailLen; i++) {
			a = s.charAt(i);
			if ((a & 0xFF00) == 0) {
				realLen += 1;
			}
			else {
				realLen += 2;
			}
		}

		while (realLength(s.substring(0, i)) > len - tailLen) {
			i--;
		}

		return s.substring(0, i) + tmpTail;
	}

	public static String subStringNicely(String s, int len) {
		if (s == null) {
			return null;
		}

		int srcLen = realLength(s);

		if (srcLen < len) {
			return s;
		}
		char a;
		int i = 0;
		int realLen = 0;
		for (i = 0; i < len && realLen < len; i++) {
			a = s.charAt(i);
			if ((a & 0xFF00) == 0) {
				realLen += 1;
			}
			else {
				realLen += 2;
			}
		}

		while (realLength(s.substring(0, i)) > len) {
			i--;
		}

		return s.substring(0, i);
	}

	public static int realLength(String s) {
		return s.getBytes().length;
	}

	public static String getDateStr(String str) {
		String temp = str;
		if (str.length() == 1) {
			temp = "0" + str;
		}
		return temp;
	}
	
	public static String getErrorCodeListForDB(String str) {
		//��߼� �� ���ܵǴ� �����ڵ� ������ �����. 250�� �ݵ�� �����ϵ��� �߰��� - �ѱ���
		if(str.indexOf("250") == -1) {
			str = "250," + str;
		}
		String s = StringUtils.deleteWhitespace(str).replaceAll("[\'\"]", "").replaceAll(",", "','");
		return "'" + s + "'";
	}
	
	/**
     * HTML Ư������ 4�� ó�� : [&]&amp; ["]&quot; [<]&lt; [>]&gt;
     * @param str
     * @return
     */
    public static String escapeXss(String str) {
        return StringUtils.isBlank(str) ? "" : str.replaceAll("&", "&amp;").replaceAll("\"", "&quot;").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
    }

    /**
     * HTML Ư������ 4�� ó�� : [&]&amp; ["]&quot; [<]&lt; [>]&gt;
     * @param str
     * @return
     */
    public static String escapeXss(String str, String defaultStr) {
        return StringUtils.isBlank(str) ? defaultStr : str.replaceAll("&", "&amp;").replaceAll("\"", "&quot;").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
    }

    /**
     * HTML Ư������ 4�� ó�� : [&]&amp; ["]&quot; [<]&lt; [>]&gt;
     * @param str
     * @return
     */
    public static String[] escapeXss(String[] strArray) {
        String[] escapeArray = null;
        if(strArray != null) {
            escapeArray = new String[strArray.length];
            for(int i = 0; i < strArray.length; i++) {
                escapeArray[i] = escapeXss(strArray[i]);
            }
        }

        return escapeArray;
    }

    /**
     * HTML Ư������ 4�� ó�� : [&]&amp; ["]&quot; [<]&lt; [>]&gt;
     * @param str
     * @return
     */
    public static Map<Object, Object> escapeXss(Map<Object, Object> paramMap) {
        Map<Object, Object> escapeMap = null;

        if(paramMap != null) {
            escapeMap = new HashMap<Object, Object>();

            for(Iterator<Object> i = paramMap.keySet().iterator(); i.hasNext();) {
                Object key = i.next();
                Object value = paramMap.get(key);

                if(value instanceof String) {
                    escapeMap.put(key, escapeXss((String) value));
                } else {
                    escapeMap.put(key, value);
                }
            }

        }

        return escapeMap;
    }

    //[20160610] [sch8310] [unescapeXss �Լ� ���� �����Լ��� StringEscapeUtils.unescapeHtml ����ϸ� �������� ��ȯ�Ǿ ������.]
    public static String unescapeXss(String str, String defaultStr) {
        return StringUtils.isBlank(str) ? defaultStr : str.replaceAll("&amp;", "&").replaceAll("&quot;", "\"").replaceAll("&lt;", "<").replaceAll("&gt;", ">");        
    }

    public static String unescapeXss(String str) {
        return StringUtils.isBlank(str) ? "" :  str.replaceAll("&amp;", "&").replaceAll("&quot;", "\"").replaceAll("&lt;", "<").replaceAll("&gt;", ">");
    }
    
    /*public static String unescapeXss(String str, String defaultStr) {
        return StringUtils.isBlank(str) ? defaultStr : StringEscapeUtils.unescapeHtml(str);
    }

    public static String unescapeXss(String str) {
        return StringUtils.isBlank(str) ? "" : StringEscapeUtils.unescapeHtml(str);
    }*/

    public static String escapeHeader(String str) {
        return escapeXss(str).replaceAll("\\r\\n", "");
    }

    public static String escapeHeader(String str, String defaultStr) {
        return StringUtils.isBlank(str) ? defaultStr : escapeXss(str).replaceAll("\\r\\n", "");
    }

    public static String escapeSql(String str, String defaultStr) {
        return StringUtils.isBlank(str) ? defaultStr : str.replaceAll("--", "");
    }

    public static String escapeSql(String str) {
        return StringUtils.isBlank(str) ? "" : str.replaceAll("--", "");
    }

    public static String escapeCommand(String str) {
        return StringUtils.isBlank(str) ? "" : str.replaceAll("&", "").replaceAll("&&", "").replaceAll("|", "").replaceAll("||", "").replaceAll(";", "").replaceAll("\\.\\.", "");
    }
    
    // ��� ���� �� �ڿ� ���� ���
    public static String escapeFilePath(String filePath) throws RuntimeException {
        if(StringUtils.isBlank(filePath)) {
            return "";
        }
        String escapePath = FilenameUtils.separatorsToUnix(filePath).replaceAll("\\.\\.", "").replaceAll("\\r", "").replaceAll("\\n", "");
        return escapePath;
    }

    public static File escapeFilePath(File file) throws RuntimeException {
        if(file == null) {
            return null;
        }
        escapeFilePath(file.getAbsolutePath());
        return file;
    }

//    /**
//     * HTML, HTM ���Ͽ� Ư�� ��ũ��Ʈ ����
//     * @param htmlFile
//     * @return
//     * @throws Exception
//     */
//    public static String findXssScriptForHtmlFile(File htmlFile) throws Exception {
//		StringBuffer conts = new StringBuffer();
//		InputStream fis = new FileInputStream(htmlFile);
//		try{
//			return findXssScriptForHtmlFile(fis);
//		} finally{
//			fis.close();
//			fis=null;
//		}
//    }

//    /**
//     * HTML, HTM ���Ͽ� Ư�� ��ũ��Ʈ ����
//     * @param is
//     * @return
//     * @throws Exception
//     */
//    public static String findXssScriptForHtmlFile(InputStream is) throws Exception {
//		StringBuffer conts = new StringBuffer();
//		int i = -1;
//		
//		//charsetName = is.getEncoding().displayName();
//		byte[] b = new byte[4096];
//		while((i = is.read(b)) != -1) {
//			conts.append(new String(b, 0, i));
//			
//		}
//		//��ũ��Ʈ Ű���尡 ������ �����߻�. 
//		String xssScript[] = PropertyUtil.getProperty("xssScript.keyWord", "").toUpperCase().split(",");
//		String temp = conts.toString().toUpperCase();
//		for(int j=0;j<xssScript.length;j++){
//			if(temp.contains((xssScript[j]))){
//				String errorKeyWord;
//				if(xssScript[j].startsWith("<")){
//					errorKeyWord = xssScript[j].substring(1); 
//				}else{
//					errorKeyWord = xssScript[j];
//				}
//				return errorKeyWord;
//			}
//		}
//		
//		conts.setLength(0);
//		conts = null;
//		
//		return "";
//	}
    /*public static void main(String ar[]){
    	String path="c:/test/mnwise/test.jpg/r/ntest";
    	System.out.println(escapeCommand(path));
    }*/
}
