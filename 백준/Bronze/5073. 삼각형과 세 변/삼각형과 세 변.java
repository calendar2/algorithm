import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			int l1 = Integer.parseInt(st.nextToken());
			int l2 = Integer.parseInt(st.nextToken());
			int l3 = Integer.parseInt(st.nextToken());

			if (l1 == 0 && l2 == 0 && l3 == 0) {
				break;
			}

			if (l1 + l2 <= l3 || l1 + l3 <= l2 && l2 + l3 <= l1) {
				sb.append("Invalid");
			} else {
				if (l1 == l2 && l2 == l3) {
					sb.append("Equilateral");
				} else if (l1 == l2 || l1 == l3 || l2 == l3) {
					sb.append("Isosceles");
				} else {
					sb.append("Scalene");
				}
			}

			sb.append("\n");
		}

		System.out.println(sb);
	}
}
