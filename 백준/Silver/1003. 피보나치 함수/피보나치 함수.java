import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // N이 39까지의 0과 1의 갯수를 미리 만들어놓기
        int[][] fibonacci = new int[41][2];
        fibonacci[0][0] = 1;
        fibonacci[0][1] = 0;
        fibonacci[1][0] = 0;
        fibonacci[1][1] = 1;

        for (int i = 2; i < 41; i++) {
            fibonacci[i][0] = fibonacci[i-1][0] + fibonacci[i-2][0];
            fibonacci[i][1] = fibonacci[i-1][1] + fibonacci[i-2][1];
        }

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(fibonacci[N][0]).append(" ").append(fibonacci[N][1]).append("\n");
        } // 테스트 케이스

        System.out.println(sb);
    }
}
