import org.apache.commons.lang.StringUtils;

public class phoneNumberCheck {

	
	public static void main(String[] args) {
		
		String phoneNoReceiver = "01010000000";
		
		String msg = null;
		int size = 7;
		String valid = ",0000000,1111111,";
		
		boolean result1 = StringUtils.contains(",010,011,013,016,017,018,019,", (StringUtils.left(phoneNoReceiver, 3)));
		
		if(phoneNoReceiver.length() > 7){
			valid = ",00000000,11111111,";
			size = 8;
		} 
		boolean result2 = StringUtils.contains(valid, StringUtils.right(phoneNoReceiver, size));
		
		if((StringUtils.contains(",010,011,013,016,017,018,019,", (StringUtils.left(phoneNoReceiver, 3))) == false) || (StringUtils.contains(",00000000,11111111,", StringUtils.right(phoneNoReceiver, size)))){
			msg = "수신번호 부적절";
		}else{
			msg = "정상";
		}
		
		System.out.println("===============================================");
		System.out.println("phoneNumber result1 : " + result1);
		System.out.println("phoneNumber result2 : " + result2);
		System.out.println("phoneNumber Check msg : " + msg);
		System.out.println("===============================================");
		
	}
}
