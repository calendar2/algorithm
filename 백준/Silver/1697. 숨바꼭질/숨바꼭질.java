import java.util.*;

public class Main {
    static int N;
    static int[] time;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int K = sc.nextInt();

        time = new int[100001];
        visited = new boolean[100001];
        bfs();

        System.out.println(time[K]);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        visited[N] = true;

        while (!q.isEmpty()) {
            int current = q.poll();
            int right = current + 1;
            int left = current - 1;
            int teleport = current * 2;

            if (teleport >= 0 && teleport <= 100000) {
                if (!visited[teleport]) {
                    time[teleport] = time[current] + 1;
                    q.add(teleport);
                    visited[teleport] = true;
                }
            }

            if (right >= 0 && right <= 100000) {
                if (!visited[right]) {
                    time[right] = time[current] + 1;
                    q.add(right);
                    visited[right] = true;
                }
            }

            if (left >= 0 && left <= 100000) {
                if (!visited[left]) {
                    time[left] = time[current] + 1;
                    q.add(left);
                    visited[left] = true;
                }
            }
        }
    }
}
