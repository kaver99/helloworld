
public class AlimtalkTemplateVerification {
	
	public static void main(String[] args) {
		
		String msg = "test<img";
		int imgSIndex = msg.indexOf("<img");
		if(imgSIndex > -1){
			System.out.println("OK");
		}else{
			System.out.println("FAIL");
		}
	}
}
