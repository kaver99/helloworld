import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

public class MsgByteToSubstring2 {
	public static void main(String[] args) throws IOException {
//	    String file = "C:/mnwise/testLMS.txt";
	    String file = "C:/mnwise/hanwhagi_template_alimtalk.txt";
	    
		if (file.length() == 0) {
			System.err.println("Input Filename...");
			System.exit(1);
		}
		
		String msg = null;
		String msgs = null;
		msg = FileUtils.readFileToString(new File(file));
//		byte[] msgByte = msg.getBytes();
//		System.out.println("-------------------------------------------");
//		System.out.println("* msg : ");
//		for(int i = 0; i < msgByte.length; i++) {
//			System.out.println(Integer.toHexString(msgByte[i]));
//		}
		
//		msg = msg+"^"+msg;
		String urlEncoderMsg = URLEncoder.encode(msg, "EUC-KR");
		String urlDecoderMsg = URLDecoder.decode(urlEncoderMsg, "EUC-KR");
		System.out.println("-------------------------------------------");
		System.out.println("urlEncoderMsg : " + urlEncoderMsg);
		System.out.println("-------------------------------------------");
		System.out.println("urlDecoderMsg : " + urlDecoderMsg);
		System.out.println("-------------------------------------------");
		System.out.println("* msg Length : " + msg.getBytes().length);
		System.out.println("-------------------------------------------");
//		msg = msg.replace("\r\n", System.getProperty("line.separator"));
		//msg = msg.replace(System.getProperty("line.separator"), "\\r\\n");
		
		msg = StringReadLine(msg);
		System.out.println("msg : " + msg);
		
		msgs = JeonmunSubString(msg.trim(), 4000);
		System.out.println("-------------------------------------------");
		System.out.println("* msgs : ");
		System.out.println(msgs);
		System.out.println("-------------------------------------------");
		System.out.println("* msgs Length : " + msgs.getBytes().length);
		System.out.println("-------------------------------------------");
	}
	
	/**
	 * ���ڿ��� ����Ʈ�� ���̸� ���Ѵ��� ���̸� �����Ѵ�.
	 * @param str
	 * @return int
	 * @throws UnsupportedEncodingException 
	 */
	public static int getStringBytesLength(String str) {
		if (str == null) return 0;
		return str.getBytes().length;
	}

	/**
	 * LMS �޽��� ������ len���̺��� Ŭ ��� len���̿� ���� �� ���� ���� 
	 * @param s : String
	 * @param len : int
	 * @return s.substring(0, i)
	 * @sinse 2016-12-01
	 */
	public static String JeonmunSubString(String s, int len) {
		if (s == null) {
			return null;
		}

		int srcLen = getStringBytesLength(s);

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
			} else {
				realLen += 2;
			}
		}

		while (getStringBytesLength(s.substring(0, i)) > len) {
			i--;
		}

		return s.substring(0, i);
	}
	
	/**
	 * String �������� ���� ġȯ
	 * @param s
	 */
	public static String StringReadLine2(String s) {
        StringBuffer sb = new StringBuffer();
        try {
        	BufferedReader reader = new BufferedReader(new StringReader(s));
            while (reader.readLine() != null) {
            	String line = reader.readLine();
            	sb.append(line);
            	String CR = "\r";
                if(line.endsWith(CR)){
                	line = StringUtils.chomp(line);
                	line = line+System.getProperty("line.seperator");
                }
//                line.replace("\n", System.getProperty("line.seperator"));
            }
        } catch (IOException e) {
            // quit
        }
		return sb.toString();
	}
	
    /**
     * String ���ڿ��� �о� �� �������� ���� �� String ������ ����
     * @param file
     * @return
     */
    public static String StringReadLine(String sMsg) {
    	StringBuffer sb = new StringBuffer();
		try {
			BufferedReader in = new BufferedReader(new StringReader(sMsg));
			String s;
			while ((s = in.readLine()) != null) {
				//sb.append(s);
				s = StringUtils.chomp(s);
				sb.append(s+ System.getProperty("line.seperator"));
//                if(s.startsWith(CR) || s.startsWith(LF) || s.startsWith(CR+LF)){
//                	schomp = StringUtils.chomp(s);
//                	s = schomp + System.getProperty("line.seperator");
//    				System.out.println("| s : " + s);
//                }
			}
			in.close();

		} catch (IOException e) {
		    System.err.println(e); // ������ �ִٸ� �޽��� ���
		    System.exit(1);
		}
		return sb.toString();
    }
	
}
