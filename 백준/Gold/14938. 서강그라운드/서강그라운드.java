import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int r;
    static int[] items;
    static ArrayList<ArrayList<int[]>> roads = new ArrayList<>();
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        items = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <= n; i++) {
            roads.add(new ArrayList<>());
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            roads.get(a).add(new int[] {b, l});
            roads.get(b).add(new int[] {a, l});
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            int item = dijkstra(i);
            max = Math.max(max, item);
        }

        System.out.println(max);
    }

    static int dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[1] - o2[1]));
        pq.add(new int[] {start, 0});
        int[] distance = new int[n+1];
        boolean[] visited = new boolean[n+1];

        for (int i = 0; i <= n; i++) {
            distance[i] = INF;
        }
        distance[start] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (visited[cur[0]]) continue;
            visited[cur[0]] = true;

            for (int[] next : roads.get(cur[0])) {
                if (distance[next[0]] > distance[cur[0]] + next[1]) {
                    distance[next[0]] = distance[cur[0]] + next[1];
                    pq.add(new int[] {next[0], distance[next[0]]});
                }
            }
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] <= m) {
               cnt += items[i];
            }
        }

        return cnt;
    }
}
