import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken()) - 1;
        int y = Integer.parseInt(st.nextToken()) - 1;

        int[] tournament = new int[N];
        tournament[x] = tournament[y] = 2;

        // 초기 세팅
        int round = 1;
        boolean isMeet = false;
        for (int i = 0; i < N; i += 2) {
            if (i == N-1) {
                if (i == x || i == y) {
                    tournament[i] = 2;
                } else {
                    tournament[i] = 1;
                }
            } else {
                if ((i == x && (i+1) == y) || ((i+1) == x && i == y)) {
                    isMeet = true;
                    break;
                } else if (i == x || i == y) {
                    tournament[i] = 2;
                    tournament[i+1] = 0;
                } else if ((i+1) == x || (i+1) == y) {
                    tournament[i] = 0;
                    tournament[i+1] = 2;
                } else {
                    tournament[i] = 1;
                    tournament[i+1] = 0;
                }
            }
        }

        while (!isMeet) {
            round += 1;

            // 현재 라운드의 승자를 파악
            int prev = -1;
            int cur = -1;
            for (int i = 0; i < N; i++) {
                if (tournament[i] == 0) {
                    continue;
                }

                if (prev == -1) {
                    prev = i;
                } else {
                    cur = i;
                }

                if (cur != -1) {
                    if (tournament[prev] == 2 && tournament[cur] == 2) {
                        isMeet = true;
                        break;
                    } else if (tournament[prev] == 2 && tournament[cur] == 1) {
                        tournament[cur] = 0;
                    } else if (tournament[prev] == 1 && tournament[cur] == 2) {
                        tournament[prev] = 0;
                    } else {
                        tournament[cur] = 0;
                    }
                    prev = -1;
                    cur = -1;
                }
            }
        }

        System.out.println(round);
    }
}
