import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] network;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        network = new int[m][2];
        visited = new boolean[n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            network[i][0] = Integer.parseInt(st.nextToken());
            network[i][1] = Integer.parseInt(st.nextToken());
        }

        bfs(1);

        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            if (visited[i]) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int i = 0; i < m; i++) {
                if (network[i][0] == node && !visited[network[i][1]]) {
                    q.add(network[i][1]);
                    visited[network[i][1]] = true;
                }

                if (network[i][1] == node && !visited[network[i][0]]) {
                    q.add(network[i][0]);
                    visited[network[i][0]] = true;
                }
            }
        }
    }
}
