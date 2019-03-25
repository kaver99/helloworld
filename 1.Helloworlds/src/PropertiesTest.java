import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

public class PropertiesTest {
	private static PropertiesTest propTest = new PropertiesTest();
		
	public static void main(String[] args) {
		try{
//			prop = new Properties();
//			// ȯ������ �ε��� ����
//			prop.load( propTest.getClass().getResourceAsStream("/smsFilter.proprties") );
//			
//			String filterList[] = prop.getProperty("filter-value", "").trim().split(",");
			
			String filterList[] = propertiesLoad();
			
			
			// file load
			String file = "C:/mnwise/msg_Test_lt_gt.txt";
			
			if (file.length() == 0) {
				System.err.println("Input Filename...");
				System.exit(1);
			}
			String msg = "";
//			String jonmun = "@s@|f|1|<object�ؾȳ��ϼ���. ��LMS���� �Դϴ�" + System.getProperty("line.separator");
//				   jonmun+= "�ڼ��� ǰ�� ����� ���� ���� ��Ź�帳�ϴ�." + System.getProperty("line.separator");
//				   jonmun+= "��1��" + System.getProperty("line.separator");
//				   jonmun+= "��2��<applet,<embedTest" + System.getProperty("line.separator");
//				   jonmun+= "<img dynsrc=\"javascript:" + System.getProperty("line.separator");
//				   jonmun+= "�����մϴ�.onunload=" + System.getProperty("line.separator");
			
			String jonmun = "";
			
			jonmun = FileUtils.readFileToString(new File(file));
//			System.out.println("jonmun : \r\n" + jonmun);
			System.out.println("-------------------------------------------");
			msg = smsXSSFilter(filterList, jonmun);	  
			
			msg = StringUtils.isBlank(msg) ? "" :  msg.replaceAll("&amp;", "&").replaceAll("&quot;", "\"").replaceAll("&lt;", "<").replaceAll("&gt;", ">");
			// ������ ���� ó��
			System.out.println("msg : " + msg);
			System.out.println("-------------------------------------------");
				   
//			BufferedReader br = new BufferedReader(new FileReader(file));
//			BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(jonmun.getBytes())));
//			
//			while ((line = br.readLine()) != null ){
//				for(int key=0; key < filterList.length; key++) {
//					if (line.contains(filterList[key])) {
////						System.out.print("XSSFilter Policy-" + key + " : " + line + " [" + i + " line ");
//						System.out.print("XSSFilter Policy-" + key + " [" + i + " line ");
//						line = line.replace(filterList[key], "");
//						System.out.println(filterList[key] + " -Include security violations in message content.]" );
//					}
//				}
//				
//				line += System.getProperty("line.separator");
//				
//				i++;
//				msg = msg + line;
//			}
//			
//			System.out.println("msg : " + msg);
//			br.close(); 
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static String[] propertiesLoad() {
		String filterList[] = null;
		
		try{
			Properties prop = new Properties();
			// ȯ������ �ε��� ����
			prop.load( propTest.getClass().getResourceAsStream("/smsFilter.proprties") );
			filterList = prop.getProperty("keyword", "").trim().split(",");
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return filterList;
	}
	
	public static String smsXSSFilter(String[] filterList, String jonmun) {
		int i = 1;
		String line = "";
		String msg = "";
		
		try {
			// byteStream���� �޽��� ����(����)�� ����
			BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(jonmun.getBytes())));
			
			// �޽��� ����(����)�� ���δ����� �о XSS���� üũ 
			while ((line = br.readLine()) != null ){
				for(int key=0; key < filterList.length; key++) {
					if(line.matches("(?i).*"+filterList[key]+".*")) {
	//					System.out.print("XSSFilter Policy-" + key + " : " + line + " [" + i + " line ");
						System.out.print("XSSFilter Policy-"+key+" [" + i + " line ");
						line = line.replaceAll("(?i)"+filterList[key], "*");
						System.out.println("("+filterList[key]+")"+" : Message content security policy violation.]" );
					}
				}
				line += System.getProperty("line.separator");
				msg = msg + line;
				i++;
			}
//			System.out.println("msg : " + msg);
			br.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return msg.trim();
	}
	
	
	
}
