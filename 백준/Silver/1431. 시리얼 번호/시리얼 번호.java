import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] serial_numbers = new String[N];
        for (int i = 0; i < N; i++) {
            serial_numbers[i] = br.readLine();
        }

        // 3. 사전순 비교
        Arrays.sort(serial_numbers, (s1, s2) -> s1.compareTo(s2));

        // 2. 길이가 같으면 A, B의 각 자릿수 중 숫자인 것의 합 중 작은 거부터
        int[][] sum_result = new int[N][2];
        for (int i = 0; i < N; i++) {
            int result = sum(serial_numbers[i]);
            sum_result[i][0] = i;
            sum_result[i][1] = result;
        }
        Arrays.sort(sum_result, (o1, o2) -> o1[1] - o2[1]);

        String[] sorted_arr = new String[N];
        for (int i = 0; i < N; i++) {
            sorted_arr[i] = serial_numbers[sum_result[i][0]];
        }

        // 1. A와 B의 길이가 다르면 짧은 것 부터
        Arrays.sort(sorted_arr, (s1, s2) -> s1.length() - s2.length());

        for (int i = 0; i < N; i++) {
            sb.append(sorted_arr[i]).append("\n");
        }

        System.out.println(sb);
    }

    public static int sum(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                sum += Character.getNumericValue(c);
            }
        }

        return sum;
    }
}
