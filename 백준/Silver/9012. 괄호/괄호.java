import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            String VPS = br.readLine();
            int cnt = 0;

            for (int i = 0; i < VPS.length(); i++) {
                if (VPS.charAt(i) == '(') {
                    cnt++;
                } else if (VPS.charAt(i) == ')') {
                    cnt--;
                }

                if (cnt < 0) {
                    break;
                }
            }

            if (cnt == 0) {
                sb.append("YES");
            } else {
                sb.append("NO");
            }
            sb.append("\n");
        } // tc for
        System.out.println(sb);
    }
}
