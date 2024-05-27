import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] bug_dp = new int[21];
        int[] baby_dp = new int[21];
        bug_dp[1] = 1;
        bug_dp[2] = 2;
        baby_dp[1] = baby_dp[2] = 1;

        for (int i = 3; i <= N; i++) {
            bug_dp[i] = bug_dp[i-1] * 2;
            baby_dp[i] = bug_dp[i-1];

            if (i % 2 == 0) {
                bug_dp[i] -= (baby_dp[i-3] + baby_dp[i-4]);
            }
        }

        System.out.println(bug_dp[N]);
    }
}
