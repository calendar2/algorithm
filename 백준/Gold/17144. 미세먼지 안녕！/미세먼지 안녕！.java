import java.io.*;
import java.util.*;

public class Main {
    static int R;
    static int C;
    static int T;
    static int[][] room;
    static ArrayList<int[]> cleaner = new ArrayList<>();
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        room = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if (room[i][j] == -1) {
                    cleaner.add(new int[] {i, j});
                }
            }
        }

        while (T > 0) {
            // 1. 미세먼지 확산
            diffusion();

            // 2. 공기청정기 순환
            if (!cleaner.isEmpty()) {
                for (int i = 0; i < 2; i++) {
                    circulate(i);
                }
            };

            T--;
        }

        int dust = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                dust += room[i][j];
            }
        }

        System.out.println(dust + cleaner.size());
    }

    static void diffusion() {
        int[][] diffusion_arr = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (room[i][j] == -1) continue;
                int diffusion_value = room[i][j] / 5;

                for (int k = 0; k < 4; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];

                    if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                        if (room[nr][nc] != -1) {
                            diffusion_arr[nr][nc] += diffusion_value;
                            diffusion_arr[i][j] -= diffusion_value;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                room[i][j] += diffusion_arr[i][j];
            }
        }
    }

    static void circulate(int order) {
        int row = cleaner.get(order)[0];
        int col = cleaner.get(order)[1];
        int row_bound = row;

        // 0번째는 반시계 순환, 1번째는 시계 순환
        if (order == 0) {
            int dir = 0;

            while (true) {
                int nr = row + dr[dir % 4];
                int nc = col + dc[dir % 4];

                if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                    if (room[nr][nc] == -1) {
                        room[row][col] = 0;
                        break;
                    }
                }

                switch (dir % 4) {
                    case 0:
                        if (nr < 0) {
                            dir++;
                        } else {
                            if (room[row][col] != -1) {
                                room[row][col] = room[nr][nc];
                            }
                            row = nr;
                        }
                        break;
                    case 1:
                        if (nc >= C) {
                            dir++;
                        } else {
                            room[row][col] = room[nr][nc];
                            col = nc;
                        }
                        break;
                    case 2:
                        if (nr > row_bound) {
                            dir++;
                        } else {
                            room[row][col] = room[nr][nc];
                            row = nr;
                        }
                        break;
                    case 3:
                        room[row][col] = room[nr][nc];
                        col = nc;
                        break;
                }
            }
        } else if (order == 1) {
            int dir = 6;

            while (true) {
                int nr = row + dr[dir % 4];
                int nc = col + dc[dir % 4];

                if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                    if (room[nr][nc] == -1) {
                        room[row][col] = 0;
                        break;
                    }
                }

                switch (dir % 4) {
                    case 0:
                        if (nr < row_bound) {
                            dir--;
                        } else {
                            room[row][col] = room[nr][nc];
                            row = nr;
                        }
                        break;
                    case 1:
                        if (nc >= C) {
                            dir--;
                        } else {
                            room[row][col] = room[nr][nc];
                            col = nc;
                        }
                        break;
                    case 2:
                        if (nr >= R) {
                            dir--;
                        } else {
                            if (room[row][col] != -1) {
                                room[row][col] = room[nr][nc];
                            }
                            row = nr;
                        }
                        break;
                    case 3:
                        room[row][col] = room[nr][nc];
                        col = nc;
                        break;
                }
            }
        }
    }
}
