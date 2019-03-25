import java.io.UnsupportedEncodingException;


public class Getbyte_test {

	public static void main(String[] args) {
			
		String value = "�����ٶ󸶹ٻ������ī�ĸ���";
		
		System.out.println("value_no : " + value);
		try {
			System.out.println("value_EUC-KR : " + value.getBytes("EUC-KR"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("value_UTF-8 : " + value.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}
	
}
