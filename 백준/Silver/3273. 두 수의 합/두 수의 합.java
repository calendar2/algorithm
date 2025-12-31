import java.io.*;
import java.util.*;

public class Main {
	public static int n;
	public static int[] arr;
	public static int x;
	public static int count = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		x = Integer.parseInt(br.readLine());

		Arrays.sort(arr);
		for (int i = 0; i < n-1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (arr[i] + arr[j] == x) {
					count++;
				} else if (arr[i] + arr[j] > x) {
					break;
				}
			}
		}

		System.out.println(count);
	}
}
