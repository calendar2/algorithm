import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int new_point = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[] points = new int[N];
        if (N > 0) {
            st = new StringTokenizer(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            points[i] = Integer.parseInt(st.nextToken());
        }

        if (N == P && points[points.length-1] >= new_point) {
            System.out.println(-1);
        } else {
            int rank = 1;
            for (int i = 0; i < N; i++) {
                if (points[i] > new_point) {
                    rank++;
                } else {
                    break;
                }
            }

            System.out.println(rank);
        }
    }
}
