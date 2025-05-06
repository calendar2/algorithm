import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] books = new int[N];

        if (N > 0) {
            st = new StringTokenizer(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            books[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 1;
        int result = 0;
        for (int i = 0; i < N; i++) {
            if (result + books[i] > M) {
                cnt += 1;
                result = 0;
            }
            result += books[i];
        }

        System.out.println(N == 0 ? 0 : cnt);
    }
}
