import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] position;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 0번째가 시간, 1번째가 횟수
        position = new int[100001][2];
        for (int i = 0; i <= 100000; i++) {
            position[i][0] = 200000;
            position[i][1] = 200000;
        }
        position[N][0] = 0;
        position[N][1] = 1;

        bfs();
        sb.append(position[M][0]).append("\n").append(position[M][1]);

        System.out.println(sb);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(N);

        while (!q.isEmpty()) {
            int cur = q.poll();
            int right = cur + 1;
            int left = cur - 1;
            int tele = cur * 2;

            // 오른쪽 이동
            if (right <= 100000) {
                if (position[cur][0] + 1 < position[right][0]) {
                    position[right][0] = position[cur][0] + 1;
                    position[right][1] = 1;
                    q.add(right);
                } else if (position[cur][0] + 1 == position[right][0]) {
                    position[right][1]++;
                    q.add(right);
                }
            }

            // 왼쪽 이동
            if (left >= 0) {
                if (position[cur][0] + 1 < position[left][0]) {
                    position[left][0] = position[cur][0] + 1;
                    position[left][1] = 1;
                    q.add(left);
                } else if (position[cur][0] + 1 == position[left][0]) {
                    position[left][1]++;
                    q.add(left);
                }
            }

            // 순간이동
            if (tele <= 100000) {
                if (position[cur][0] + 1 < position[tele][0]) {
                    position[tele][0] = position[cur][0] + 1;
                    position[tele][1] = 1;
                    q.add(tele);
                } else if (position[cur][0] + 1 == position[tele][0]) {
                    position[tele][1]++;
                    q.add(tele);
                }
            }
        }
    }
}
