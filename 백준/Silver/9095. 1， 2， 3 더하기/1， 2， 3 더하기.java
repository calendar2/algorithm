import java.io.*;

public class Main {
    static int n;
    static int[] numbers = {1, 2, 3};
    static int cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            n = Integer.parseInt(br.readLine());
            cnt = 0;
            dfs(0);
            sb.append(cnt).append("\n");
        } // tc for

        System.out.println(sb);
    }

    static void dfs(int result) {
        if (result == n) {
            cnt++;
            return;
        }

        if (result > n) {
            return;
        }

        result += numbers[2];
        dfs(result);
        result -= 1;
        dfs(result);
        result -= 1;
        dfs(result);
    }
}
