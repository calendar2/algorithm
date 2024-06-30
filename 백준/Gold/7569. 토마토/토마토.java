import java.io.*;
import java.util.*;

public class Main {
    static int M;
    static int N;
    static int H;
    static int[][][] box;
    static int[][][] days;
    static int[] dr = {-1, 0, 1, 0, 0, 0};
    static int[] dc = {0, 1, 0, -1, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[H][N][M];
        days = new int[H][N][M];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        bfs();
        boolean isFail = false;
        int max = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (box[i][j][k] == 0) {
                        isFail = true;
                        break;
                    }
                    max = Math.max(max, days[i][j][k]);
                }

                if (isFail) {
                    max = -1;
                    break;
                }
            }

            if (isFail) break;
        }

        System.out.println(max);
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (box[i][j][k] == 1) {
                        q.add(new int[] {i, j, k});
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            int[] current = q.poll();
            for (int i = 0; i < 6; i++) {
                int nr = current[1] + dr[i];
                int nc = current[2] + dc[i];
                int nh = current[0] + dh[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M && nh >= 0 && nh < H) {
                    if (box[nh][nr][nc] == 0) {
                        q.add(new int[] {nh, nr, nc});
                        days[nh][nr][nc] = days[current[0]][current[1]][current[2]] + 1;
                        box[nh][nr][nc] = 1;
                    }
                }
            }
        }
    }
}
