import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] stair_point = new int[n+1];
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            stair_point[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = stair_point[1];

        // 계단이 두 개 이상일 때는 dp[2]까지 만들어둔다.
        if (n >= 2) {
            dp[2] = stair_point[1] + stair_point[2];
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i-2], dp[i-3] + stair_point[i-1]) + stair_point[i];
        }

        System.out.println(dp[n]);
    }
}
