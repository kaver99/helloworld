import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.mnwise.common.jeonmun.Jeonmun;

public class jeonmunTest {

	public static void main(String[] args) throws IOException {
		String file = "C:/mnwise/msgTest.txt";
	    
		if (file.length() == 0) {
			System.err.println("Input Filename...");
			System.exit(1);
		}
		
		String msg = null;
		msg = FileUtils.readFileToString(new File(file));
		
		Jeonmun jm = new Jeonmun();
		jm.parsing(msg, '|');
		System.out.println("=========================== Jeonmun RESULT ===========================");
		System.out.println(jm.get("@s@",1));
		System.out.println("----------------------------------------------------------------------");
		System.out.println(jm.get("@s@",2));
		System.out.println("----------------------------------------------------------------------");
		System.out.println(jm.get("@s@",3));
		System.out.println("----------------------------------------------------------------------");
		System.out.println(jm.get("@s@",4));
		System.out.println("----------------------------------------------------------------------");
		System.out.println(jm.get("@s@",5));
		System.out.println("----------------------------------------------------------------------");
		System.out.println(jm.get("@s@",6));
		System.out.println("----------------------------------------------------------------------");
		
	}
	
}
