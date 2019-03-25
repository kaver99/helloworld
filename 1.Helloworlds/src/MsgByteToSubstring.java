import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.apache.commons.io.FileUtils;
import com.mnwise.util.StringUtil;

public class MsgByteToSubstring {
	public static void main(String[] args) throws IOException {
	    String file = "C:/mnwise/ARM_REJECT.txt";
	    
		if (file.length() == 0) {
			System.err.println("Input Filename...");
			System.exit(1);
		}
		
		String msg = null;
		String msgs = null;
//		msg = getFileString(file);
		msg = FileUtils.readFileToString(new File(file));
//		msgs = "";
		msgs = msg;
//		msgs = StringUtil.subStringNicely(msgs, 4010);
//		byte[] msgsByte = msgs.getBytes();
//		msg = msgsByte.toString();
		//msgs = JeonmunSubString(msgs, 4001);
		System.out.println("-------------------------------------------");
		System.out.println("Start msgs : " + msgs);
		System.out.println("-------------------------------------------");
		System.out.println("Start msgs Length : " + msgs.getBytes().length);
		System.out.println("-------------------------------------------");
		
//		msg = "@s@|f|1|"+ msgs;
		msg = msgs;
//		msg = msg+"^"+msg;
//		msg = "@s@|f|1|" + msgs;
//		msg = "�׽�Ʈsms�Դϴ�1.^�׽�Ʈsms�Դϴ�2.";
//		msg = msg+msg+msg+"^"+msg+msg+msg;
		
		String urlEncoderMsg = URLEncoder.encode(msg, "EUC-KR");
		String urlDecoderMsg = URLDecoder.decode(urlEncoderMsg, "EUC-KR");
		
		byte[] msgByte = urlDecoderMsg.getBytes();
		int msgByteLength = msgByte.length;
		
		// ���ؿ����� ���� ���� ��� ����(������� ���ؿ����� ���� ����, �ƴҰ�� ���鰪)
		//String sJeonmunPrefix = MnwiseJeonmunPrefixCheck(urlDecoderMsg);
		// ���ؿ����� ������ ������ �޽��� �κ� ���� �� 4000Byte �̻� ���� ����
		//String msgCut = JeonmunSizeValidation(urlDecoderMsg, sJeonmunPrefix);
//		msgCut = sJeonmunPrefix + msgCut;
		//byte[] msgCutByte = msgCut.getBytes();
		//int msgCutByteLength = msgCutByte.length; 
		
		
		
		System.out.println("-------------------------------------------");
		System.out.println("URLEncoder : " + urlEncoderMsg);
		System.out.println("-------------------------------------------");
		System.out.println("URLDecoder : " + urlDecoderMsg);
		System.out.println("-------------------------------------------");
//		System.out.println("msg : " + msg);
//		System.out.println("-------------------------------------------");
		System.out.println("msgByteLength : " + msgByteLength);
		System.out.println("-------------------------------------------");
		//System.out.println("msgCut : " + msgCut);
		System.out.println("-------------------------------------------");
		//System.out.println("msgCutByteLength : " + msgCutByteLength);
		System.out.println("-------------------------------------------");
	
		
		
		
/*		String msg = "������123abc";
		int maxsize = 10;
		byte[] msgbyte = msg.getBytes("EUC-KR");
		int msgbyteLenth = msgbyte.length;
		
		String msgcut = getMaxByteString(msg, maxsize);
		byte[] msgcutbyte = msgcut.getBytes("EUC-KR");
		int msgcutbyteLenth = msgcutbyte.length;
		
		System.out.println("----------------------------------------");
		System.out.println("msg : " + msg);
		System.out.println("maxsize : " + maxsize);
		System.out.println("msgbyteLenth : " + msgbyteLenth);
		System.out.println("----------------------------------------");		
		System.out.println("msgcut : " + msgcut);
		System.out.println("msgcutbyteLenth : " + msgcutbyteLenth);
		System.out.println("----------------------------------------");*/
	}
	
//	/**
//	 * maxByte�̻��� �޼���(���ڿ�) �� ���� ����
//	 * �޼���(���ڿ�)�� maxByte ũ�⺸�� Ŭ ��� �ش� ���� ���� ���ڸ� ���� ����
//	 * @param msg : �޽��� ����
//	 * @param maxByte : �ִ� ����Ʈ
//	 * @return StringBuffer sb : �� ���� ���ŵ� �޼���
//	 */
//   public static StringBuffer getMaxByteString(String msg, int maxByte) {
//    	StringBuffer sb = new StringBuffer();
//    	int curSize = 0; // ����1���� ���� byte��ȯ �� ���� ����
//    	String curMsg;  // ����
//        
//        // maxByte ũ�⺸�� Ŭ ��� �ش� ���� ���� ���ڸ� ���� ����(���� ����:msg.length())
//        for (int i = 0; i < msg.length(); i++) {
//        	curMsg = msg.substring(i, i + 1);
//            curSize += curMsg.getBytes().length; 
//            
//            if (curSize > maxByte) {
//            	break;
//            } else {
//            	sb.append(curMsg);
//            	System.out.println("curMsg:" + curMsg);
//            }
//        }
//        return sb;
//   }
      
    /**
     * ������ �о� �� �������� ���� �� String ������ ����
     * @param file
     * @return
     */
    public static String getFileString(String file) {
    	StringBuffer sb = new StringBuffer();
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			String s;
			int idx = 0;
			while ((s = in.readLine()) != null) {
				idx = idx + 1;
				sb.append(s);
				System.out.println("idx : " + idx + " | s : " + s);
				sb.append(System.getProperty( "line.separator"));
			}
			in.close();

		} catch (IOException e) {
		    System.err.println(e); // ������ �ִٸ� �޽��� ���
		    System.exit(1);
		}
		return sb.toString();
    }

	
	/**
	 * LMS���� ���������� 4000byte üũ �� �޹��� ���� ��  String jeonmun�� ��� ����
	 * @param sJeonmun : String
	 * @return sJeonmun : String(4000Byte�̻� �޹��� ���� ������ ���� ������)
	 * @since 2016-10-31
	 */
	public static String JeonmunSizeValidation(String sJeonmun) {
		String sJeonmunPrefix = null;
		int iJeonmunPrefixLength = 0;
		String sJeonmunPrefix_cut = null;
		String sJonmun_Sub = null;
		String sJonmun_Cut = "";
		// �ִ� ���� ����Ʈ 4000byte ����
		int iMaxByte = 4000;
		// ���ؿ����� ���� ���� ��� ����(������� ���ؿ����� ���� ���� , �ƴҰ�� ���鰪)
		sJeonmunPrefix = MnwiseJeonmunPrefixCheck(sJeonmun);
		// ���ؿ����� ���� ���� ������("@s@|f|1|" �� ������)
		iJeonmunPrefixLength = sJeonmunPrefix.getBytes().length;
		// ���ؿ����� ���� ������ ������ ����
		sJeonmunPrefix_cut = sJeonmun.substring(iJeonmunPrefixLength);
		// ���ؿ����� ���� ���� ����� 0�� ���� ��� ? �Ϲ� ���� : ���ؿ����� ���� �����͸� ������ ����
		sJonmun_Sub = (iJeonmunPrefixLength == 0) ? sJeonmun : sJeonmunPrefix_cut;
		
		// ���ؿ����� ���� ������ ������ �޽��� �κ��� ������� �ִ� 4000Byte ��
		if (sJonmun_Sub.getBytes().length > iMaxByte) {
//			sJonmun_Cut = com.mnwise.wiseu.web.base.util.StringUtil.subStringNicely(sJonmun_Sub, iMaxByte);
			sJonmun_Cut = StringUtil.subStringNicely(sJonmun_Sub, iMaxByte);
			// 4000Byte�̻� �޹��� ���� ������ ���� ������ �տ�  ���ؿ����� ���� ������ �߰�(���ؿ����� ������ �ƴҰ�� ����("") ������ �߰�)
			sJeonmun = sJeonmunPrefix + sJonmun_Cut;
			
			System.out.println("[jonmun 4000Byte Orver.. After Character Cut][Real : " + sJonmun_Sub.getBytes().length + "Byte][Cut : " + sJonmun_Cut.getBytes().length + "Byte]");
//			log.info("[jonmun 4000Byte Orver.. After Character Cut][Real : " + sJonmun_Sub.getBytes().length + "Byte][Cut : " + sJonmun_Cut.getBytes().length + "Byte]");
		}
		return sJeonmun;
	}
	
	
	/**
	 * LMS���� ���������� 4000byte üũ �� �޹��� ���� ��  String jeonmun�� ��� ����
	 * @param sJeonmun : String(�޽�������)
	 * @param sJeonmunPrefix : String (���� ������-��/���� ����)
	 * @return sJeonmun : String(4000Byte�̻� �޹��� ���� ������ ���� ������)
	 * @since 2016-10-31
	 */
	public static String JeonmunSizeValidation(String sJeonmun, String sJeonmunPrefix) {
		int iJeonmunPrefixLength = 0;
		String sJeonmunPrefix_cut = null;
		String sJonmun_Sub = null;
		String sJonmun_Cut = "";
		// �ִ� ���� ����Ʈ 4000byte ����
		int iMaxByte = 4000;
		// ���ؿ����� ���� ���� ������("@s@|f|1|" �� ������)
		iJeonmunPrefixLength = sJeonmunPrefix.getBytes().length;
		// ���ؿ����� ���� ������ ������ ����
		sJeonmunPrefix_cut = sJeonmun.substring(iJeonmunPrefixLength);
		// ���ؿ����� ���� ���� ����� 0�� ���� ��� ? �Ϲ� ���� : ���ؿ����� ���� �����͸� ������ ����
		sJonmun_Sub = (iJeonmunPrefixLength == 0) ? sJeonmun : sJeonmunPrefix_cut;
		
		// ���ؿ����� ���� ������ ������ �޽��� �κ��� ������� �ִ� 4000Byte ��
		if (sJonmun_Sub.getBytes().length > iMaxByte) {
//			sJonmun_Cut = com.mnwise.wiseu.web.base.util.StringUtil.subStringNicely(sJonmun_Sub, iMaxByte);
			sJonmun_Cut = StringUtil.subStringNicely(sJonmun_Sub, iMaxByte);
			// 4000Byte�̻� �޹��� ���� ������ ���� ������ �տ�  ���ؿ����� ���� ������ �߰�(���ؿ����� ������ �ƴҰ�� ����("") ������ �߰�)
			sJeonmun = sJonmun_Cut;
			
			System.out.println("[jonmun 4000Byte Orver.. After Character Cut][Real : " + sJonmun_Sub.getBytes().length + "Byte][Cut : " + sJonmun_Cut.getBytes().length + "Byte]");
//			log.info("[jonmun 4000Byte Orver.. After Character Cut][Real : " + sJonmun_Sub.getBytes().length + "Byte][Cut : " + sJonmun_Cut.getBytes().length + "Byte]");
		}
		return sJeonmun;
	}
	
	
	/**
	 * ���ؿ����� ���� ���� ��� ����(������� ���ؿ����� ���� ���� , �ƴҰ�� ���鰪)
	 * @param sJeonmun : String
	 * @return sJeonmunPrefix : String(���ؿ����� ���� ���� �κ� : "@s@|f|1|")
	 * @since 2016-10-31
	 */
	public static String MnwiseJeonmunPrefixCheck(String sJeonmun) {
		// ���ؿ����� ���� ���� ����
		String sFixdJeonmunFomat = "@s@";
		int iPreFixLength = 0; 
		String sJeonmunPrefix = "";
		
		// jeonmun ���� �κ��� ���ؿ����� ���� ���� ����� ������ ����
		if(sJeonmun.startsWith(sFixdJeonmunFomat) == true){
			// jeonmun ������ ������ ������("|") �ձ����� ����
			iPreFixLength = org.apache.commons.lang.StringUtils.lastIndexOf(sJeonmun, "|");
			// ���ؿ����� ���� ���� �κ� ����(0, '|' ����� �߰��� ������)
			sJeonmunPrefix = sJeonmun.substring(0, iPreFixLength+1);
//			System.out.println("sJeonmunPrefix : " + sJeonmunPrefix);
		}
		return sJeonmunPrefix;
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
			} else {
				realLen += 2;
			}
		}

		while (realLength(s.substring(0, i)) > len) {
			i--;
		}

		return s.substring(0, i);
	}
	
	/**
	 * s�� ���� ����
	 * @param s : String
	 * @return s.getBytes().length
	 * @sinse 2016-12-01
	 */
	public static int realLength(String s) {
		return s.getBytes().length;
	}
}
