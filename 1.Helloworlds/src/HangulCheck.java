
public class HangulCheck {

	public static void main(String[] args) {
		
		String msg="@s@|f|1|1<<한글한글한글한글한글한글한글한글한글한글한글한글한글한글한글한글한글한글한글한글한글한글한글한글한글한글한글한글한글한글한글한글한글한글>>>>";
		boolean ex = existHangul(msg);
		System.out.println("ex : " + ex);
		
	}
	
	
	private static boolean existHangul(String str) {
		int length = (str == null) ? 0 : str.length();
		for (int i = 0; i < length; i++) {
			char c = str.charAt(i);
			if (c >= 0xac00 && c <= 0xd7a3) { // 유니코드 2.0 한글 영역
				return true;
			}
		}

		return false;
	}
}
