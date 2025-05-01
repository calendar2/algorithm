import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            N = Math.min(N, M-N);
            boolean[] visited = new boolean[N];

            long cnt = 1;
            for (int i = M; i > M-N; i--) {
                cnt *= i;
                for (int j = 0; j < N; j++) {
                    if (visited[j]) {
                        continue;
                    }

                    if (cnt % (j+1) == 0) {
                        visited[j] = true;
                        cnt /= (j+1);
                    }
                }
            }

            System.out.println(cnt);
        } // tc for
    }
}
