import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] matrix;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        int[][] ans = half(matrix, B);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(ans[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static int[][] half(int[][] A, long b) {
        if (b == 1) {
            return A;
        }

        int[][] ret = half(A, b/2);
        ret = multiply(ret, ret);

        if (b % 2 == 1) {
            return multiply(ret, matrix);
        }

        return ret;
    }

    static int[][] multiply(int[][] A, int[][] B) {
        int[][] temp = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    temp[i][j] += A[i][k] * B[k][j];
                    temp[i][j] %= 1000;
                }
            }
        }

        return temp;
    }
}
