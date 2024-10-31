import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] laboratory;
    static ArrayList<int[]> virus = new ArrayList<>();
    static int max = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        laboratory = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                laboratory[i][j] = Integer.parseInt(st.nextToken());
                if (laboratory[i][j] == 2) {
                    virus.add(new int[] {i, j});
                }
            }
        }
        // 여기까지 입력

        // 벽 3개 세우기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (laboratory[i][j] == 0) {
                    laboratory[i][j] = 1;
                    make_wall(i, j, 1);
                    laboratory[i][j] = 0;
                }
            }
        }

        System.out.println(max);
    }

    static void make_wall(int row, int col, int cnt) {
        if (cnt == 3) {
            // 벽 3개 구축, 바이러스 퍼뜨리기
            int safe_area = dfs();
            if (safe_area > max) {
                max = safe_area;
            }
            return;
        }

        for (int i = row; i < N; i++) {
            if (i == row) {
                for (int j = col; j < M; j++) {
                    if (laboratory[i][j] == 0) {
                        laboratory[i][j] = 1;
                        make_wall(i, j, cnt+1);
                        laboratory[i][j] = 0;
                    }
                }
            } else {
                for (int j = 0; j < M; j++) {
                    if (laboratory[i][j] == 0) {
                        laboratory[i][j] = 1;
                        make_wall(i, j, cnt+1);
                        laboratory[i][j] = 0;
                    }
                }
            }
        }
    }

    static int dfs() {
        int[][] virus_laboratory = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                virus_laboratory[i][j] = laboratory[i][j];
            }
        }

        Stack<int[]> stack = new Stack<>();
        for (int[] position: virus) {
            stack.push(new int[] {position[0], position[1]});
        }

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        while (!stack.isEmpty()) {
            int[] virus_position = stack.pop();
            for (int i = 0; i < 4; i++) {
                int nr = virus_position[0] + dr[i];
                int nc = virus_position[1] + dc[i];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (virus_laboratory[nr][nc] == 0) {
                        virus_laboratory[nr][nc] = 2;
                        stack.push(new int[] {nr, nc});
                    }
                }
            }
        }

        // 안전 영역 계산
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (virus_laboratory[i][j] == 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
