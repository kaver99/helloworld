
public class testArray {

	public static void main(String[] args) {
		
		/**
		 * 입출력 예 #1
		 * 입력이 [4, 1, 3, 2]가 주어진 경우, 배열의 길이가 4이므로 배열에는 1부터 4까지 숫자가 모두 들어 있어야 합니다. 
		 * [4, 1, 3, 2]에는 1부터 4까지의 숫자가 모두 들어 있으므로 true를 반환하면 됩니다.
		 * 
		 * 입출력 예 #2
		 * [4, 1, 3]이 주어진 경우, 배열의 길이가 3이므로 배열에는 1부터 3까지 숫자가 모두 들어 있어야 합니다. 
		 * [4, 1, 3]에는 2가 없고 4가 있으므로 false를 반환하면 됩니다.
		 */
		
		int[] arr = {4,1,2};
		int maxNum = arr[0];
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] >= maxNum) {
				maxNum = arr[i];
			}
			
			for (int j = 1; j <= maxNum; j++) {
				if(arr[i] == j) {
					System.out.println("arr["+i+"] : "+arr[i]+"-같음");
				} else {
					System.out.println("arr["+i+"] : "+arr[i]+"-다름");
				}
			}
        }
		
	}
}
