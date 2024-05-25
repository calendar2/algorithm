import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] dp = new long[n+1];
        dp[1] = 1L;

        if (n >= 2) {
            dp[2] = 3L;
            for (int i = 3; i <= n; i++) {
                dp[i] = ((dp[i-2] * 2) + dp[i-1]) % 10007L;
            }
        }

        System.out.println(dp[n]);
    }
}
