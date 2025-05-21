import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int D;
    static List<ArrayList<Node>> fast_info = new ArrayList<>();
    static int[] distance = new int[10001];

    static class Node {
        int goal;
        int dist;

        Node(int goal, int dist) {
            this.goal = goal;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        // 거리 dp, 지름길 리스트 초기화
        for (int i = 0; i <= 10000; i++) {
            distance[i] = i;
            fast_info.add(new ArrayList<>());
        }

        // 지름길 정보 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            fast_info.get(s).add(new Node(e, d));
        }

        for (int i = 0; i <= D; i++) {
            dijkstra(i);
        }

        System.out.println(distance[D]);
    }

    static void dijkstra(int start) {
        if (start > D) {
            return;
        }

        if (distance[start+1] > distance[start] + 1) {
            distance[start+1] = distance[start] + 1;
        }

        for (Node n : fast_info.get(start)) {
            if (distance[n.goal] > distance[start] + n.dist) {
                distance[n.goal] = distance[start] + n.dist;
            }
        }
    }
}
