import java.io.*;
import java.util.*;

public class Main {
    static int M;
    static int N;
    static int[][] farm;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            // 배추밭
            farm = new int[N][M];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                farm[y][x] = 1;
            }

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (farm[i][j] == 1) {
                        cnt++;
                        bfs(i, j);
                    }
                }
            }

            sb.append(cnt).append("\n");
        } // tc for

        System.out.println(sb);
    }

    static void bfs(int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {row, col});
        farm[row][col] = 2;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (farm[nr][nc] == 1) {
                        q.add(new int[] {nr, nc});
                        farm[nr][nc] = 2;
                    }
                }
            }
        }
    }
}
