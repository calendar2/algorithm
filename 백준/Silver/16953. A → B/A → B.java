import java.util.*;

public class Main {
    static int A;
    static int B;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();

        int ans = bfs();
        System.out.println(ans);
    }

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {A, 1});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int double_step = cur[0] * 2;
            long add_one = (long)cur[0] * 10 + 1;

            if (double_step <= B) {
                if (double_step < B) {
                    q.add(new int[] {double_step, cur[1] + 1});
                } else {
                    return cur[1] + 1;
                }
            }

            if (add_one <= B) {;
                if (add_one < B) {
                    q.add(new int[] {(int)add_one, cur[1] + 1});
                } else {
                    return cur[1] + 1;
                }
            }
        }

        return -1;
    }
}
