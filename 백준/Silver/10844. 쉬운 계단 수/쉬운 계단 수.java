import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[][] dp = new long[N+1][10];
        final int mod = 1000000000;

        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j-1 >= 0) {
                    dp[i][j] += dp[i-1][j-1] % mod;
                }

                if (j+1 <= 9) {
                    dp[i][j] += dp[i-1][j+1] % mod;
                }
            }
        }

        long ans = 0;
        for (int i = 0; i <= 9; i++) {
            ans += dp[N][i] % mod;
        }
        System.out.println(ans % mod);
    }
}
