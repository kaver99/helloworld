
public class Object_Test {
	private static DateTest dt;
	
	//dt1482535999
	public static void main(String[] args) {
		
		dt = new DateTest();
		System.out.println("dt1 : " + dt.hashCode());
		
		DateTest dt= new DateTest();
		System.out.println("dt2 : " + dt.hashCode());
	}
}