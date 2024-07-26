import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] triangle = new int[n][n];

        // 삼각형의 요소를 -1로 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                triangle[i][j] = -1;
            }
        }

        // 입력 받기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (n == 1) {
            System.out.println(triangle[0][0]);
        } else {
            for (int i = 1; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    if (j == 0) {
                        triangle[i][j] += triangle[i-1][j];
                    } else {
                        triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
                    }
                }
            }

            int max = 0;
            for (int i = 0; i < n; i++) {
                max = Math.max(max, triangle[n-1][i]);
            }
            System.out.println(max);
        }
    }
}
