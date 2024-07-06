import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] paper;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        paper = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] max_value = new int[10];
        max_value[0] = square();
        max_value[1] = Math.max(col_line(), row_line());
        max_value[2] = Math.max(col_s(), row_s());
        max_value[3] = Math.max(top_L(), right_L());
        max_value[4] = Math.max(reverse_L(), left_L());
        max_value[5] = Math.max(under_tank(), top_tank());
        max_value[6] = Math.max(right_tank(), left_tank());
        max_value[7] = Math.max(reverse_row_s(), reverse_col_s());
        max_value[8] = Math.max(mirror_top_L(), mirror_reverse_L());
        max_value[9] = Math.max(mirror_right_L(), mirror_left_L());

        int max = 0;
        for (int i = 0; i < 10; i++) {
            max = Math.max(max, max_value[i]);
        }

        System.out.println(max);
    }

    static int square() {
        int square_max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i+1 < N && j+1 < M) {
                    int value = paper[i][j] + paper[i][j+1] + paper[i+1][j] + paper[i+1][j+1];
                    square_max = Math.max(square_max, value);
                }
            }
        }

        return square_max;
    }

    static int col_line() {
        int line_max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (j+3 < M) {
                    int value = paper[i][j] + paper[i][j+1] + paper[i][j+2] + paper[i][j+3];
                    line_max = Math.max(line_max, value);
                }
            }
        }

        return line_max;
    }

    static int row_line() {
        int line_max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i+3 < N) {
                    int value = paper[i][j] + paper[i+1][j] + paper[i+2][j] + paper[i+3][j];
                    line_max = Math.max(line_max, value);
                }
            }
        }

        return line_max;
    }

    static int row_s() {
        int s_max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i+2 < N && j+1 < M) {
                    int value = paper[i][j] + paper[i+1][j] + paper[i+1][j+1] + paper[i+2][j+1];
                    s_max = Math.max(s_max, value);
                }
            }
        }

        return s_max;
    }

    static int col_s() {
        int s_max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = M-1; j >= 0; j--) {
                if (i+1 < N && j >= 2) {
                    int value = paper[i][j] + paper[i][j-1] + paper[i+1][j-1] + paper[i+1][j-2];
                    s_max = Math.max(s_max, value);
                }
            }
        }

        return s_max;
    }

    static int reverse_row_s() {
        int s_max = 0;
        for (int i = 0; i < N-2; i++) {
            for (int j = M-1; j >= 1; j--) {
                int value = paper[i][j] + paper[i+1][j] + paper[i+1][j-1] + paper[i+2][j-1];
                s_max = Math.max(s_max, value);
            }
        }

        return s_max;
    }

    static int reverse_col_s() {
        int s_max = 0;
        for (int i = 0; i < N-1; i++) {
            for (int j = 0; j < M-2; j++) {
                int value = paper[i][j] + paper[i][j+1] + paper[i+1][j+1] + paper[i+1][j+2];
                s_max = Math.max(s_max, value);
            }
        }

        return s_max;
    }

    static int top_L() {
        int L_max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i+2 < N && j+1 < M) {
                    int value = paper[i][j] + paper[i+1][j] + paper[i+2][j] + paper[i+2][j+1];
                    L_max = Math.max(L_max, value);
                }
            }
        }

        return L_max;
    }

    static int right_L() {
        int L_max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i+1 < N && j+2 < M) {
                    int value = paper[i][j] + paper[i+1][j] + paper[i][j+1] + paper[i][j+2];
                    L_max = Math.max(L_max, value);
                }
            }
        }

        return L_max;
    }

    static int reverse_L() {
        int L_max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i+2 < N && j+1 < M) {
                    int value = paper[i][j] + paper[i][j+1] + paper[i+1][j+1] + paper[i+2][j+1];
                    L_max = Math.max(L_max, value);
                }
            }
        }

        return L_max;
    }

    static int left_L() {
        int L_max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = M-1; j >= 0; j--) {
                if (i+1 < N && j >= 2) {
                    int value = paper[i][j] + paper[i+1][j] + paper[i+1][j-1] + paper[i+1][j-2];
                    L_max = Math.max(L_max, value);
                }
            }
        }

        return L_max;
    }

    static int mirror_top_L() {
        int L_max = 0;
        for (int i = 0; i < N-2; i++) {
            for (int j = M-1; j >= 1; j--) {
                int value = paper[i][j] + paper[i+1][j] + paper[i+2][j] + paper[i+2][j-1];
                L_max = Math.max(L_max, value);
            }
        }

        return L_max;
    }

    static int mirror_reverse_L() {
        int L_max = 0;
        for (int i = 0; i < N-2; i++) {
            for (int j = 0; j < M-1; j++) {
                int value = paper[i][j] + paper[i][j+1] + paper[i+1][j] + paper[i+2][j];
                L_max = Math.max(L_max, value);
            }
        }

        return L_max;
    }

    static int mirror_right_L() {
        int L_max = 0;
        for (int i = 0; i < N-1; i++) {
            for (int j = 0; j < M-2; j++) {
                int value = paper[i][j] + paper[i+1][j] + paper[i+1][j+1] + paper[i+1][j+2];
                L_max = Math.max(L_max, value);
            }
        }

        return L_max;
    }

    static int mirror_left_L() {
        int L_max = 0;
        for (int i = 0; i < N-1; i++) {
            for (int j = 0; j < M-2; j++) {
                int value = paper[i][j] + paper[i][j+1] + paper[i][j+2] + paper[i+1][j+2];
                L_max = Math.max(L_max, value);
            }
        }

        return L_max;
    }

    static int under_tank() {
        int tank_max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i+1 < N && j+2 < M) {
                    int value = paper[i][j] + paper[i][j+1] + paper[i][j+2] + paper[i+1][j+1];
                    tank_max = Math.max(tank_max, value);
                }
            }
        }

        return tank_max;
    }

    static int top_tank() {
        int tank_max = 0;
        for (int i = N-1; i >= 1; i--) {
            for (int j = 0; j < M; j++) {
                if (j+2 < M) {
                    int value = paper[i][j] + paper[i][j+1] + paper[i][j+2] + paper[i-1][j+1];
                    tank_max = Math.max(tank_max, value);
                }
            }
        }

        return tank_max;
    }

    static int right_tank() {
        int tank_max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i+2 < N && j+1 < M) {
                    int value = paper[i][j] + paper[i+1][j] + paper[i+2][j] + paper[i+1][j+1];
                    tank_max = Math.max(tank_max, value);
                }
            }
        }

        return tank_max;
    }

    static int left_tank() {
        int tank_max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = M-1; j >= 1; j--) {
                if (i+2 < N) {
                    int value = paper[i][j] + paper[i+1][j] + paper[i+2][j] + paper[i+1][j-1];
                    tank_max = Math.max(tank_max, value);
                }
            }
        }

        return tank_max;
    }
}
