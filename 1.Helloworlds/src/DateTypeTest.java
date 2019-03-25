import java.util.Date;


public class DateTypeTest {

	public static void main(String[] args) {
		
		Date curr_date = new Date();
		
		System.out.println("======================================");
		System.out.println("curr_date : " + curr_date);
		System.out.println("curr_date : " + curr_date.getTime());
		System.out.println("======================================");
		System.out.println("last_date : " + new Date());
		System.out.println("last_date : " + new Date().getTime());
		System.out.println("======================================");
		
		
		long dates2 = System.currentTimeMillis()-20000000; 
		System.out.println("dates-2 : " + dates2);
		
		long dates = System.currentTimeMillis(); 
		System.out.println("dates : " + dates);
		
		long a = 1432007658037L;
		long b = 1432007658053L;
		System.out.println(a-b);
		/*
			======================================
			curr_date : Tue May 19 12:54:18 KST 2015
			curr_date : 1432007658037
			======================================
			last_date : Tue May 19 12:54:18 KST 2015
			last_date : 1432007658053
			======================================
		 */
		
		
		int s = 400000;
		int e = 10000;
		int result = s / e;
		System.out.println("result : " + result);
		
	}
	
}
