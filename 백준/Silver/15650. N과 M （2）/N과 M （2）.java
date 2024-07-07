import java.util.*;

public class Main {
    static int[] numbers;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        numbers = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = i+1;
        }

        comb(N, 0, M);
        System.out.println(sb);
    }

    static void comb(int n, int start, int r) {
        if (r == 0) {
            // r개만큼 선택한 상황
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    sb.append(numbers[i]).append(" ");
                }
            }
            sb.append("\n");

            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            comb(n, i+1, r-1);
            visited[i] = false;
        }
    }
}
