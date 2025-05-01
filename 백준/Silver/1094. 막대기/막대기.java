import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        int cnt = 0;
        int len = 64;
        while (len > 0) {
            if (X < len) {
                len /= 2;
            } else if (X > len) {
                X -= len;
                cnt += 1;
                len /= 2;
            } else {
                cnt += 1;
                break;
            }
        }

        System.out.println(cnt);
    }
}
