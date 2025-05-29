import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] require_money_list = new int[N];
        st = new StringTokenizer(br.readLine());

        int max_require_money = -1;
        for (int i = 0; i < N; i++) {
            require_money_list[i] = Integer.parseInt(st.nextToken());
            if (require_money_list[i] > max_require_money) {
                max_require_money = require_money_list[i];
            }
        }

        int M = Integer.parseInt(br.readLine());

        int max = -1;
        int left = 0;
        int right = M;

        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;

            for (int i = 0; i < N; i++) {
                if (require_money_list[i] > mid) {
                    sum += mid;
                } else {
                    sum += require_money_list[i];
                }
            }

            if (sum == M) {
                max = mid;
                break;
            } else if (sum > M) {
                right = mid - 1;
            } else {
                max = mid;
                left = mid + 1;
            }
        }

        System.out.println(Math.min(max, max_require_money));
    }
}
