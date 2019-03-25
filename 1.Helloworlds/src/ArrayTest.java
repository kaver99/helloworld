import java.util.StringTokenizer;

public class ArrayTest {

	public static void main(String[] args) {
		String b = "ttttttttt,ttttttt";
		
		StringTokenizer st = new StringTokenizer(b,",");
		String[] test = new String [st.countTokens()];
		
		for(int i = 0; i < st.countTokens(); i++) {
			test[i] = st.nextToken();
			System.out.println(test[i]);
		}
		
	}
}
