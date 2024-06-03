import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] edge;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edge = new int[M][2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            edge[i][0] = Integer.parseInt(st.nextToken());
            edge[i][1] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[N+1];
        visited[0] = true;
        int start = 0;
        int cnt = 0;

        while (true) {
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    start = i;
                    break;
                }
            }

            if (start == 0) {
                break;
            } else {
                dfs(start);
                cnt++;
                start = 0;
            }
        }

        System.out.println(cnt);
    }

    static void dfs(int start) {
        Stack<Integer> stack = new Stack<>();
        stack.add(start);
        visited[start] = true;

        while (!stack.isEmpty()) {
            int node = stack.pop();

            for (int i = 0; i < M; i++) {
                if (edge[i][0] == node && !visited[edge[i][1]]) {
                    stack.add(edge[i][1]);
                    visited[edge[i][1]] = true;
                } else if (edge[i][1] == node && !visited[edge[i][0]]) {
                    stack.add(edge[i][0]);
                    visited[edge[i][0]] = true;
                }
            }
        }
    }
}
