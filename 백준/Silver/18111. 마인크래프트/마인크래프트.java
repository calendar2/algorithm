import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] ground = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int min_time = Integer.MAX_VALUE;
        int height = -1;
        for (int i = 0; i <= 256; i++) {
            int time = 0;
            int B_clone = B;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (ground[j][k] > i) {
                        B_clone += (ground[j][k] - i);
                        time += 2 * (ground[j][k]-i);
                    } else if (ground[j][k] < i) {
                        B_clone -= (i - ground[j][k]);
                        time += (i - ground[j][k]);
                    }
                }
            }

            if (B_clone >= 0 && min_time >= time) {
                min_time = time;
                height = i;
            }
        }

        System.out.println(min_time + " " + height);
    }
}
