import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 문서의 갯수
            int M = Integer.parseInt(st.nextToken()); // M번째 문서가 몇 번째로 인쇄되었는지?

            Queue<int[]> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int[] temp = new int[2];
                temp[0] = i;
                temp[1] = Integer.parseInt(st.nextToken());
                q.add(temp);
            }

            // q에서 값을 하나씩 빼면서 M과 확인
            int cnt = 1;
            boolean insert;
            while (!q.isEmpty()) {
                int[] temp = q.poll();

                insert = false;
                for (int[] document : q) {
                    if (document[1] > temp[1]) {
                        q.add(temp);
                        insert = true;
                        break;
                    }
                }

                if (!insert) {
                    if (temp[0] == M) {
                        break;
                    } else {
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        } // 테스트 루프

        System.out.println(sb);
    }
}