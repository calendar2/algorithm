import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] table = new int[N][N];
        int[] indexes = new int[N];
        for (int i = 0; i < N; i++) {
            indexes[i] = N - 1;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            int max = -1000000001;
            int max_idx = -1;
            for (int j = 0; j < N; j++) {
                if (table[indexes[j]][j] > max) {
                    max = table[indexes[j]][j];
                    max_idx = j;
                }
            }

            indexes[max_idx] -= 1;

            if (i == N - 1) {
                ans = max;
            }
        }

        System.out.println(ans);
    }
}
