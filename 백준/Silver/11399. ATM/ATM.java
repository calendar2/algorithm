import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] P = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(P);
        int[] cumulative_sum = new int[N];
        cumulative_sum[0] = P[0];
        for (int i = 1; i < N; i++) {
            cumulative_sum[i] = cumulative_sum[i-1] + P[i];
        }

        int time = 0;
        for (int i = 0; i < N; i++) {
            time += cumulative_sum[i];
        }
        System.out.println(time);
    }
}
