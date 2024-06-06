import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] trees = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        int low = 0;
        int high = 1000000000;

        while (low < high) {
            long height = 0L;
            int mid = (low + high) / 2;

            for (int i = 0; i < N; i++) {
                if (trees[i] > mid) {
                    height += trees[i] - mid;
                }
            }

            if (height < M) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(low-1);
    }
}
