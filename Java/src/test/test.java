package test;

public class test {

	public static void main(String[] args) {
		int[][] arr = new int[3][3];
		int cnt = 1;
		int max = 0;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = cnt++;
			}
		}
		
		for (int[] is : arr) {
			for (int is2 : is) {
				max = Math.max(max, is2);
			}
		}
		
		System.out.println(max);

//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < arr.length; j++) {
//				System.out.print(arr[i][j]);
//			}
//			System.out.println();
//		}
	}

}
