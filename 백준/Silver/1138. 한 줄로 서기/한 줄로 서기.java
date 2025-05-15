import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] record = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            record[i] = Integer.parseInt(st.nextToken());
        }

        int[] line = new int[N];
        for (int i = 1; i <= N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (record[i] == cnt) {
                    if (line[j] == 0) {
                        line[j] = i;
                        break;
                    }
                } else {
                    if (line[j] == 0) {
                        cnt += 1;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(line[i]).append(" ");
        }

        System.out.println(sb);
    }
}
