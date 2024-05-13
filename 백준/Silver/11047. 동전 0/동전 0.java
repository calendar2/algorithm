import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        // 탐색
        int idx = N-1;
        int cnt = 0;
        while (K != 0) {
            if (K / coins[idx] > 0) {
                cnt += K / coins[idx];
                K -= (K/coins[idx]) * coins[idx];
            }
            idx--;
        }

        System.out.println(cnt);
    }
}
