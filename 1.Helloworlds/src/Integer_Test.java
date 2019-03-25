public class Integer_Test {
	public static void main(String[] args) {
		String value = "1111";
		
		Integer values = Integer.parseInt(value);
				System.out.println(values.intValue());
				
		Long result = (long) (1024 * 1024);
		System.out.println(result);
		
		int[] valued = new int [] {100,80,60,40,20};
		for (int i = 0; i < valued.length; i++ ) {
			System.out.println("valued : " + valued[i]);
			if(valued[0] == 110){
				if(valued[1] == 80) {
					valued[2] = 400;
				}else{
					valued[3] = 200;
				}
				break;
			}
		}
		
		int num1 = 8001;
		int num2 = 4000;
		System.out.println("result : " + (num1%num2));
		
	}
}
