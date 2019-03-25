
public class StringTest {
	public static void main(String[] args) {
		
		/*---------------------------------------------*/
		/**
		 * trim�� Null�ϰ�� �׽�Ʈ
		 */
//		String msg = null;
//		String result = msg.trim();
//		System.out.println("result : " + result);
		
		/*---------------------------------------------*/

		/**
		 * replace �׽�Ʈ
		 */
		String msg2 = "testrestsdesesgafasfhttp://127.0.0.1:9000";
		String result2 = msg2.replace("http://127.0.0.1:9000","#?");
		System.out.println("result : " + result2);
		
		
		String msgUp = "HTTP://www.naver.com";
		if(msgUp.toLowerCase().startsWith("http")) {
			msgUp = msgUp.replaceAll("(?i)http", "https");
		}
		System.out.println("msgUp : " + msgUp);
		
		
		/*---------------------------------------------*/
		
		
		
		
		/*---------------------------------------------*/
		
	}
}
