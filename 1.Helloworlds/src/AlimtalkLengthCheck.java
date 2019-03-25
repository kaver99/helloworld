import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class AlimtalkLengthCheck {

	public static void main(String[] args) {
		String file = "C:/mnwise/Lms_Text.txt";
	    
		if (file.length() == 0) {
			System.err.println("Input Filename...");
			System.exit(1);
		}
		
		String msg = null;
		try {
			msg = FileUtils.readFileToString(new File(file));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int alimTalk_Size = 0;
		
		alimTalk_Size = alimtalkLengthChecker(msg);
		System.out.println("msg Length : " + msg.length());
		System.out.println("msgChecker Length : " + alimTalk_Size);
	}
	
	public static int alimtalkLengthChecker(String msg){
		char tmp;
		char spacePattern = ' ';
		char enterPattern = '\n';
		int patternLength = 0;
		
		for(int i=0 ; i < msg.length() ; i++){
			tmp = msg.charAt(i);
		
			if(spacePattern == tmp){
				patternLength++;
			}else if(enterPattern == tmp){
				patternLength++;
			}
		}
		return msg.length() - patternLength;
	}

}
