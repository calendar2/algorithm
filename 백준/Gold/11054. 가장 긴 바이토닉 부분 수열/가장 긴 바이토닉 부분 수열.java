import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] dp = new int[N];
        int[] r_dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (A[j] < A[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        for (int i = N-1; i >= 0; i--) {
            r_dp[i] = 1;

            for (int j = N-1; j > i; j--) {
                if (A[j] < A[i] && r_dp[i] < r_dp[j] + 1) {
                    r_dp[i] = r_dp[j] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            if (max < dp[i] + r_dp[i]) {
                max = dp[i] + r_dp[i];
            }
        }

        System.out.println(max-1);
    }
}
