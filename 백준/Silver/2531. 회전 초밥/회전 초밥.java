import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi_table = new int[N];
        int[] counts = new int[d+1];

        for (int i = 0; i < N; i++) {
            sushi_table[i] = Integer.parseInt(br.readLine());
        }

        int left = 0;
        int right = k - 1;

        for (int i = left; i <= right; i++) {
            counts[sushi_table[i]] += 1;
        }

        int max = 0;
        for (int i = 1; i <= d; i++) {
            if (counts[i] > 0) {
                max += 1;
            }
        }

        if (counts[c] == 0) {
            max += 1;
        }
        // 여기까지 초기상태

        counts[sushi_table[left++]] -= 1;
        right += 1;
        counts[sushi_table[right % N]] += 1;
        while (left < N) {
            int count = 0;
            for (int i = 1; i <= d; i++) {
                if (counts[i] > 0) {
                    count += 1;
                }
            }

            if (counts[c] == 0) {
                count += 1;
            }

            if (count > max) {
                max = count;
            }

            if (max == k + 1) {
                break;
            }

            counts[sushi_table[left++]] -= 1;
            right += 1;
            counts[sushi_table[right % N]] += 1;
        }

        System.out.println(max);
    }
}
