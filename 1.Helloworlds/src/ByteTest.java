import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class ByteTest {
	public static void main(String[] args) {
		String file = "C:/mnwise/bytechk.txt";
		if (file.length() == 0) {
			System.err.println("Input Filename...");
			System.exit(1);
		}

		String msg = null;
		try {
			msg = FileUtils.readFileToString(new File(file));
			msg = msg.trim();
			System.out.println("msg : " + msg);
			System.out.println("==========================================================");
			byte[] msgByte = msg.getBytes();
			int msgLength= msgByte.length;
			System.out.println("msgLength : " + msgLength);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 4680byte
		
//		try {
//			////////////////////////////////////////////////////////////////
//			BufferedReader in = new BufferedReader(new FileReader(filename));
//			String s;
//			StringBuffer sb = new StringBuffer();
//
//			while ((s = in.readLine()) != null) {
//				sb.append(s);
//			}
//
//			in.close();
//			////////////////////////////////////////////////////////////////
//			
//			byte[] FileByteData = sb.toString().getBytes("EUC-KR");
//			System.out.println("FileByteData Length : " + FileByteData.length);
//
//		} catch (IOException e) {
//		    System.err.println(e); // ������ �ִٸ� �޽��� ���
//		    System.exit(1);
//		}
	}
}
