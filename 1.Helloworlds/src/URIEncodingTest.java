import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.apache.commons.io.FileUtils;

public class URIEncodingTest {

	public static void main(String[] args) throws IOException {
		String file = "C:/mnwise/uriTest.txt";
	    
		if (file.length() == 0) {
			System.err.println("Input Filename...");
			System.exit(1);
		}
		
		String msg = null;
		msg = FileUtils.readFileToString(new File(file));
		
		String urlEncoderMsg = URLEncoder.encode(msg, "EUC-KR");
		String urlDecoderMsg = URLDecoder.decode(urlEncoderMsg, "EUC-KR");
		
		System.out.println("-------------------------------------------------------------");
		System.out.println("urlEncoderMsg : " + urlEncoderMsg);
		System.out.println("-------------------------------------------------------------");
		System.out.println("urlDecoderMsg : " + urlDecoderMsg);
		System.out.println("-------------------------------------------------------------");
	}
}
