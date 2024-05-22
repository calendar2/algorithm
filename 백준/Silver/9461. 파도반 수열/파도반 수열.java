import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            long[] P = new long[N];

            if (N <= 3) {
                sb.append(1).append("\n");
            } else if (N == 4 || N == 5) {
                sb.append(2).append("\n");
            } else {
                for (int i = 0; i < 3; i++) {
                    P[i] = 1;
                }
                P[3] = P[4] = 2;

                for (int i = 5; i < N; i++) {
                    P[i] = P[i-1] + P[i-5];
                }

                sb.append(P[N-1]).append("\n");
            }
        } // tc for

        System.out.println(sb);
    }
}
