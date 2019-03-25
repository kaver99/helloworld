import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

/**
 * ���� String Util org.apache.commons.lang.StringUtils ����� �ʿ� �޼ҵ� �߰� �ڼ��� ��Ÿ �ڼ���
 * ������ org.apache.commons.lang.StringUtils ���� (url :
 * http://jakarta.apache.org/commons/lang/api-release/org/apache/commons/lang/StringUtils.html)
 */
public class ApacheCommonLangTest extends StringUtils {

	public static String nullToZero(String value) {
		if (value == null || value.equals("")) {
			value = "0";
		}
		return value;
	}

	/**
	 * ���ڿ� ������ ������ �����ϴ� �޼ҵ�
	 * 
	 * @param str
	 *            ��� ���ڿ�
	 * @return trimed string with white space removed from the front.
	 */
	public static String ltrim(String str) {
		int len = str.length();
		int idx = 0;
		while ((idx < len) && (str.charAt(idx) <= ' ')) {
			idx++;
		}
		return str.substring(idx, len);
	}

	/**
	 * ���ڿ� ������ ������ �����ϴ� �޼ҵ�
	 * 
	 * @param str
	 *            ��� ���ڿ�
	 * @return trimed string with white space removed from the end.
	 */
	public static String rtrim(String str) {
		int len = str.length();
		while ((0 < len) && (str.charAt(len - 1) <= ' ')) {
			len--;
		}
		return str.substring(0, len);
	}

	/**
	 * String��
	 * 
	 * @param str
	 * @return
	 */
	public static String changeMoney(String str) {
		DecimalFormat df = new DecimalFormat("###,###");
		return df.format(parseInt(str));
	}

	/**
	 * �Ķ���ͷ� �Ѿ���� String�� , �� �������ش�.
	 *
	 * @param s
	 *            java.lang.String
	 * @return java.lang.String
	 */
	public static String removeComma(String str) {
		String rtnValue = str;
		if (isNull(str)) {
			return "";
		}
		rtnValue = replace(rtnValue, ",", "");
		return rtnValue;
	}

	/**
	 * ���� 0�� �Ѿ���� ""�� ��ġ
	 * 
	 * @param int
	 *            ��� ����
	 * @return java.lang.String
	 */
	public static String isOneNull(int num) {
		if (num == 0)
			return "";
		else
			return Integer.toString(num);
	}

	/**
	 * str�� null �̰ų� "", " " �ϰ�� return true
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNull(String str) {
		return (str == null || (str.trim().length()) == 0);
	}

	public static boolean isNull(Object obj) {
		String str = null;
		if (obj instanceof String) {
			str = (String) obj;
		} else {
			return true;
		}
		return isNull(str);
	}

	/**
	 * null�� �ƴҶ�.
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotNull(String str) {
		/**
		 * isNull�� true�̸� false false�̸� true
		 */
		if (isNull(str)) {
			return false;
		} else {
			return true;
		}
	}

	/***
	 * ��üũ
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isNotNull(Object obj) {
		String str = null;
		if (obj instanceof String) {
			str = (String) obj;
		} else {
			return false;
		}
		return isNotNull(str);
	}

	/**
	 * �Ķ���Ͱ� null �̰ų� ������ ������� "" �� return
	 * 
	 * @param value
	 * @return
	 */
	public static String replaceNull(String value) {
		return replaceNull(value, "");
	}

	/**
	 * Object�� �޾Ƽ� String ���� �ƴϰų� NULL�̸� ""�� return String ���̸� �� ��ȯ�ؼ� �Ѱ��ش�.
	 * 
	 * @param value
	 * @return
	 */
	public static String replaceNull(Object value) {
		Object rtnValue = value;
		if (rtnValue == null || !"java.lang.String".equals(rtnValue.getClass().getName())) {
			rtnValue = "";
		}
		return replaceNull((String) rtnValue, "");
	}

	/**
	 * �Ķ���ͷ� �Ѿ�� ���� null �̰ų� ������ ���Ե� ���ڶ�� defaultValue�� return �ƴϸ� ���� trim�ؼ�
	 * �Ѱ��ش�.
	 * 
	 * @param value
	 * @param repStr
	 * @return
	 */
	public static String replaceNull(String value, String defaultValue) {
		if (isNull(value)) {
			return defaultValue;
		}
		return value.trim();
	}

	/**
	 * Object�� �޾Ƽ� String ���� �ƴϰų� NULL�̸� defaultValue�� return String ���̸� �� ��ȯ�ؼ�
	 * �Ѱ��ش�.
	 * 
	 * @param value
	 * @param repStr
	 * @return
	 */
	public static String replaceNull(Object value, String defaultValue) {
		String valueStr = replaceNull(value);
		if (isNull(valueStr)) {
			return defaultValue;
		}
		return valueStr.trim();
	}

	/**
	 * Method ksc2asc. 8859-1�� euc-kr�� ���ڵ��ϴ� �Լ�
	 * 
	 * @param str
	 *            - String
	 * @return String
	 */
	public static String ksc2asc(String str) {
		String result = "";
		if (isNull(str)) {
			result = "";
		} else {
			try {
				result = new String(str.getBytes("euc-kr"), "8859_1");
			} catch (Exception e) {
				result = "";
			}
		}
		return result;
	}

	/**
	 * Method asc2ksc. euc-kr�� 8859-1�� ���ڵ��ϴ� �Լ�
	 * 
	 * @param str
	 *            - String
	 * @return String
	 */
	public static String asc2ksc(String str) {
		String result = "";
		if (isNull(str)) {
			result = "";
		} else {
			try {
				result = new String(str.getBytes("8859_1"), "euc-kr");
			} catch (Exception e) {
				result = "";
			}
		}
		return result;
	}
	/**************************************************************************************/
	/* parse method start */

	/**
	 * String�� int������
	 * 
	 * @param value
	 * @return
	 */
	public static int parseInt(String value) {
		return parseInt(value, 0);
	}

	/**
	 * Object�� int������ defaultValue�� 0�̴�.
	 * 
	 * @param value
	 * @return
	 */
	public static int parseInt(Object value) {
		String valueStr = replaceNull(value);
		return parseInt(valueStr, 0);
	}

	/**
	 * Object�� int������ Object�� null�̸� defaultValue return
	 * 
	 * @param value
	 * @param defaultValue
	 * @return
	 */
	public static int parseInt(Object value, int defaultValue) {
		String valueStr = replaceNull(value);
		return parseInt(valueStr, defaultValue);
	}

	/**
	 * String�� int������ String�� ���� ������ �ƴϸ� defaultValue return
	 * 
	 * @param value
	 * @param defaultValue
	 * @return
	 */
	public static int parseInt(String value, int defaultValue) {
		int returnValue = 0;
		if (isNull(value)) {
			returnValue = defaultValue;
		} else if (!isNumeric(value)) {
			returnValue = defaultValue;
		} else {
			returnValue = Integer.parseInt(value);
		}
		return returnValue;
	}

	/**
	 * String�� long������ defaultValue�� 0�̴�.
	 * 
	 * @param value
	 * @return
	 */
	public static long parseLong(String value) {
		return parseLong(value, 0);
	}

	/**
	 * String�� long������ �߸��� ����Ÿ �Ͻ� return�� defaultValue
	 * 
	 * @param value
	 * @return
	 */
	public static long parseLong(String value, long defaultValue) {
		long returnValue = 0;
		if (isNull(value)) {
			returnValue = defaultValue;
		} else if (!isNumeric(value)) {
			returnValue = defaultValue;
		} else {
			returnValue = Long.parseLong(value);
		}
		return returnValue;
	}

	/**
	 * Exception�� String���� �̾��ش�.
	 * 
	 * @param ex
	 * @return
	 */
	public static String stackTraceToString(Throwable e) {
		try {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			return "------\r\n" + sw.toString() + "------\r\n";
		} catch (Exception e2) {
			return ApacheCommonLangTest.stackTraceToString2(e);
		}
	}

	/**
	 * Exception�� String���� �̾��ش�.
	 * 
	 * @param ex
	 * @return
	 */
	public static String stackTraceToString2(Throwable e) {
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		PrintStream p = new PrintStream(b);
		e.printStackTrace(p);
		p.close();
		String stackTrace = b.toString();
		try {
			b.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		// return convertHtmlBr(stackTrace);
		return stackTrace;
	}

	/**
	 * Html �ڵ忡�� &#60;br&#62; ��ũ ����
	 * 
	 * @param comment
	 * @return
	 */
	public static String convertHtmlBr(String comment) {
		String rtnValue = "";
		if (isNull(comment)) {
			return "";
		}
		rtnValue = replace(comment, "\r\n", "<br>");
		return rtnValue;
	}

	/**
	 * String �迭�� List�� ��ȯ�Ѵ�.
	 * 
	 * @param values
	 * @return
	 */
	public static List<String> changeList(String[] values) {
		List<String> list = new ArrayList<String>();
		if (values == null) {
			return list;
		}
		for (int i = 0, n = values.length; i < n; i++) {
			list.add(values[i]);
		}
		return list;
	}

	public static String[] toTokenArray(String str, String sep) {
		String[] temp = null;
		try {
			StringTokenizer st = new StringTokenizer(str, sep);
			temp = new String[st.countTokens()];
			int index = 0;
			while (st.hasMoreTokens()) {
				temp[index++] = st.nextToken();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}

	public static String strip(String str, String str1) {
		if (str == null || "".equals(str.trim()))
			return "";
		String temp = str;
		int pos = -1;
		while ((pos = temp.indexOf(str1, pos)) != -1) {
			String left = temp.substring(0, pos);
			String right = temp.substring(pos + 1, temp.length());
			temp = left + "" + right;
			pos += 1;
		}
		return temp;
	}

	/**
	 * Method ksc2asc. euc-kr�� euc-kr�� ���ڵ��ϴ� �Լ�
	 * 
	 * @param str
	 *            - String
	 * @return String
	 */
	public static String ksc2utf8(String str) {
		String result = "";
		if (isNull(str)) {
			result = "";
		} else {
			try {
				result = new String(str.getBytes("euc-kr"), "utf-8");
			} catch (Exception e) {
				result = "";
			}
		}
		return result;
	}

	/**
	 * string�� �ִ� ', ", \r\n �� HTML �ڵ�� ��ȯ�Ѵ�.
	 * 
	 * @param str
	 * @return
	 */
	public static String changeQuotation(String str) {
		String rtnValue = str;
		rtnValue = replaceNull(rtnValue);
		rtnValue = replace(replace(replace(rtnValue, "'", "&#39;"), "\"", "&#34;"), "\r\n", "<br>");
		return rtnValue;
	}

	public static String changeQuotation(Object obj) {
		if (isStringInteger(obj)) {
			return changeQuotation(String.valueOf(obj));
		}
		return "";
	}

	/**
	 * �ش� Object�� String or Integer �̸� true �ƴϸ� false
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isStringInteger(Object obj) {
		boolean flag = false;
		if (obj instanceof String || obj instanceof Integer) {
			flag = true;
		}
		return flag;
	}

	/**
	 * ������� ���Ѵ�. %�� ���� ���� ����
	 * 
	 * @param value
	 * @param total
	 * @return
	 */
	public static String percentValue(int value, int total) {
		double val = Double.parseDouble(String.valueOf(value)) / Double.parseDouble(String.valueOf(total)) * 100;
		DecimalFormat df = new DecimalFormat("##0.0");
		return df.format(val);
	}

	/**
	 * XSS(Cross Site Scripting) ����� �ذ��� ���� ó��
	 *
	 * @param sourceString
	 *            String �������ڿ�
	 * @return String ��ȯ���ڿ�
	 */
	public static String replaceXSS(String sourceString) {
		String rtnValue = null;
		if (sourceString != null) {
			rtnValue = sourceString;
			if (rtnValue.indexOf("<x-") == -1) {
				rtnValue = rtnValue.replaceAll("< *(j|J)(a|A)(v|V)(a|A)(s|S)(c|C)(r|R)(i|I)(p|P)(t|T)",
						"<x-javascript");
				rtnValue = rtnValue.replaceAll("< *(v|V)(b|B)(s|S)(c|C)(r|R)(i|I)(p|P)(t|T)", "<x-vbscript");
				rtnValue = rtnValue.replaceAll("< *(s|S)(c|C)(r|R)(i|I)(p|P)(t|T)", "<x-script");
				rtnValue = rtnValue.replaceAll("< *(i|I)(f|F)(r|R)(a|A)(m|M)(e|E)", "<x-iframe");
				rtnValue = rtnValue.replaceAll("< *(f|F)(r|R)(a|A)(m|M)(e|E)", "<x-frame");
				rtnValue = rtnValue.replaceAll("(e|E)(x|X)(p|P)(r|R)(e|E)(s|S)(s|S)(i|I)(o|O)(n|N)", "x-expression");
				rtnValue = rtnValue.replaceAll("(a|A)(l|L)(e|E)(r|R)(t|T)", "x-alert");
				rtnValue = rtnValue.replaceAll(".(o|O)(p|P)(e|E)(n|N)", ".x-open");
				rtnValue = rtnValue.replaceAll("< *(m|M)(a|A)(r|R)(q|Q)(u|U)(e|E)(e|E)", "<x-marquee");
				rtnValue = rtnValue.replaceAll("&#", "&amp;#");
			}
		}
		return rtnValue;
	}

	/**
	 * Ư�����ڸ� HTML TAG�������� �����ϴ� �޼ҵ�.
	 *
	 * <xmp> & --> &amp; < --> &lt; > --> &gt; " --> &quot; ' --> &#039;
	 * -----------------------------------------------------------------
	 * <option type=radio name=r value="xxxxxxxx"> yyyyyyy
	 * <input type=hidden name=h value="xxxxxxxx">
	 * <input type=text name=t value="xxxxxxxx">
	 * <textarea name=msg rows=20 cols=53>xxxxxxx</textarea> - ���� ���� HTML �ҽ���
	 * ������ ��, xxxxxxx �κ��� ���ڿ� �߿��� �Ʒ��� �ִ� ��� Ư���� ���ڵ��� ��ȯ�Ͽ��� �մϴ�. ���� JSP ��� �̸�
	 * ��ȯ�Ͽ� HTML ��ü TAG�� ����ų�, Ȥ�� �Ʒ�ó�� ����ϼ���. -
	 * <option type=radio name=r value="<%= StringUtil.translate(s) %>"> yyyyyyy
	 * <input type=hidden name=n value="<%= StringUtil.translate(s) %>">
	 * <input type=text name=n value="<%= StringUtil.translate(s) %>">
	 * <textarea name=body rows=20 cols=53><%= StringUtil.translate(s)
	 * %></textarea> - �� �ʿ��ϴٸ� yyyyyyy �κе� translate(s)�� �� �ʿ䰡 ���� �̴ϴ�. �ʿ��� �� ����
	 * ����ϼ���. - </xmp>
	 *
	 * @return the translated string.
	 * @param str
	 *            java.lang.String
	 */
	public static String translate(String str) {
		if (str == null)
			return null;
		StringBuffer buf = new StringBuffer();
		char[] c = str.toCharArray();
		int len = c.length;
		for (int i = 0; i < len; i++) {
			if (c[i] == '&')
				buf.append("&amp;");
			else if (c[i] == '<')
				buf.append("&lt;");
			else if (c[i] == '>')
				buf.append("&gt;");
			else if (c[i] == '"')
				buf.append("&quot;"); // (char)34
			else if (c[i] == '\'')
				buf.append("&#039;"); // (char)39
			else
				buf.append(c[i]);
		}
		return buf.toString();
	}

	/**
	 * String �� �Ǵ� �ڸ� Ư�����ڷ� ������ ���̸�ŭ ä���ִ� �Լ� <BR>
	 * (��) pad("1234","0", 6, 1) --> "123400" <BR>
	 *
	 * @param src
	 *            Source string
	 * @param pad
	 *            pad string
	 * @param totLen
	 *            total length
	 * @param mode
	 *            ��/�� ���� (-1:front, 1:back)
	 * @return String
	 */
	public static String pad(String src, String pad, int totLen, int mode) {
		String paddedString = "";
		if (src == null)
			return "";
		int srcLen = src.length();
		if ((totLen < 1) || (srcLen >= totLen))
			return src;
		for (int i = 0; i < (totLen - srcLen); i++) {
			paddedString += pad;
		}
		if (mode == -1)
			paddedString += src; // front padding
		else
			paddedString = src + paddedString; // back padding
		return paddedString;
	}

	/**
	 * �־��� ����(iLength)��ŭ �־��� ����(cPadder)�� strSource�� ���ʿ� ������ �����ش�. ex)
	 * lpad("abc", 5, '^') ==> "^^abc" lpad("abcdefghi", 5, '^') ==> "abcde"
	 * lpad(null, 5, '^') ==> "^^^^^"
	 *
	 * @param strSource
	 * @param iLength
	 * @param cPadder
	 */
	public static String lpad(String strSource, int iLength, char cPadder) {
		StringBuffer sbBuffer = null;
		if (!isEmpty(strSource)) {
			int iByteSize = getByteSize(strSource);
			if (iByteSize > iLength) {
				return strSource.substring(0, iLength);
			} else if (iByteSize == iLength) {
				return strSource;
			} else {
				int iPadLength = iLength - iByteSize;
				sbBuffer = new StringBuffer();
				for (int j = 0; j < iPadLength; j++) {
					sbBuffer.append(cPadder);
				}
				sbBuffer.append(strSource);
				return sbBuffer.toString();
			}
		}
		// int iPadLength = iLength;
		sbBuffer = new StringBuffer();
		for (int j = 0; j < iLength; j++) {
			sbBuffer.append(cPadder);
		}
		return sbBuffer.toString();
	}

	/**
	 * �־��� ����(iLength)��ŭ �־��� ����(cPadder)�� strSource�� �����ʿ� ������ �����ش�. ex)
	 * lpad("abc", 5, '^') ==> "abc^^" lpad("abcdefghi", 5, '^') ==> "abcde"
	 * lpad(null, 5, '^') ==> "^^^^^"
	 *
	 * @param strSource
	 * @param iLength
	 * @param cPadder
	 */
	public static String rpad(String strSource, int iLength, char cPadder) {
		StringBuffer sbBuffer = null;
		if (!isEmpty(strSource)) {
			int iByteSize = getByteSize(strSource);
			if (iByteSize > iLength) {
				return strSource.substring(0, iLength);
			} else if (iByteSize == iLength) {
				return strSource;
			} else {
				int iPadLength = iLength - iByteSize;
				sbBuffer = new StringBuffer(strSource);
				for (int j = 0; j < iPadLength; j++) {
					sbBuffer.append(cPadder);
				}
				return sbBuffer.toString();
			}
		}
		sbBuffer = new StringBuffer();
		for (int j = 0; j < iLength; j++) {
			sbBuffer.append(cPadder);
		}
		return sbBuffer.toString();
	}

	/**
	 * byte size�� �����´�.
	 *
	 * @param str
	 *            String target
	 * @return int bytelength
	 */
	public static int getByteSize(String str) {
		if (str == null || str.length() == 0)
			return 0;
		byte[] byteArray = null;
		try {
			byteArray = str.getBytes("UTF-8");
		} catch (UnsupportedEncodingException ex) {
		}
		if (byteArray == null)
			return 0;
		return byteArray.length;
	}

	/**
	 * �� ���ڿ� �ڸ���
	 * 
	 * @param srcString
	 *            ����ڿ�
	 * @param nLength
	 *            ����
	 * @param isNoTag
	 *            �ױ� ���� ����
	 * @param isAddDot
	 *            "..."���߰� ����
	 * @return
	 */
	public static String strCut(String srcString, int nLength, boolean isNoTag, boolean isAddDot) { // ���ڿ�
																									// �ڸ���
		String rtnVal = srcString;
		int oF = 0, oL = 0, rF = 0, rL = 0;
		int nLengthPrev = 0;
		// �±� ����
		if (isNoTag) {
			Pattern p = Pattern.compile("<(/?)([^<>]*)?>", Pattern.CASE_INSENSITIVE); // �±�����
																						// ����
			rtnVal = p.matcher(rtnVal).replaceAll("");
		}
		rtnVal = rtnVal.replaceAll("&amp;", "&");
		rtnVal = rtnVal.replaceAll("(!/|\r|\n|&nbsp;)", ""); // ��������
		try {
			byte[] bytes = rtnVal.getBytes("UTF-8"); // ����Ʈ�� ����
			// x���� y���̸�ŭ �߶󳽴�. �ѱ۾ȱ�����.
			int j = 0;
			if (nLengthPrev > 0)
				while (j < bytes.length) {
					if ((bytes[j] & 0x80) != 0) {
						oF += 2;
						rF += 3;
						if (oF + 2 > nLengthPrev) {
							break;
						}
						j += 3;
					} else {
						if (oF + 1 > nLengthPrev) {
							break;
						}
						++oF;
						++rF;
						++j;
					}
				}
			j = rF;
			while (j < bytes.length) {
				if ((bytes[j] & 0x80) != 0) {
					if (oL + 2 > nLength) {
						break;
					}
					oL += 2;
					rL += 3;
					j += 3;
				} else {
					if (oL + 1 > nLength) {
						break;
					}
					++oL;
					++rL;
					++j;
				}
			}
			rtnVal = new String(bytes, rF, rL, "UTF-8"); // charset �ɼ�
			if (isAddDot && rF + rL + 3 <= bytes.length) {
				rtnVal += "...";
			} // ...�� ���������� �ɼ�
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return srcString;
		}
		return rtnVal;
	}

	/**
	 * total�� success �� % ���ϰ� �Ҽ��� 1�ڸ����� ���
	 * 
	 * @param int
	 *            success
	 * @param int
	 *            total
	 * @return String %
	 */
	public static String calculatePercent(int success, int total) {
		String result = "0";

		if (total == 0) {

		} else {

			Double tempSuccess = new Double(success + ".0");
			Double tempTotal = new Double(total + ".0");
			Double tempPercent = new Double(100 + ".0");

			double cal = tempSuccess.doubleValue() * tempPercent.doubleValue() / tempTotal.doubleValue();

			result = new java.text.DecimalFormat("#.#").format(cal);

		}

		return result;
	}
}