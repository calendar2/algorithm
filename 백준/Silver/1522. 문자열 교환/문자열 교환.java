import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int min = 1001;

        String str = br.readLine();
        int len = str.length();
        int a_cnt = 0;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == 'a') {
                a_cnt++;
            }
        }

        for (int i = 0; i < len; i++) {
            int b_cnt = 0;
            for (int j = i; j < a_cnt + i; j++) {
                if (str.charAt(j % len) == 'b') {
                    b_cnt++;
                }
            }

            if (b_cnt < min) {
                min = b_cnt;
            }
        }

        System.out.println(min);
    }
}
