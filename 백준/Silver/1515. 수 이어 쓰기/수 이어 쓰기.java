import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();

        int n = 1;
        int num_idx = 0;
        boolean flag = true;
        while (flag) {
            if (n < 10) {
                if (n == num.charAt(num_idx) - '0') {
                    num_idx += 1;
                    if (num_idx >= num.length()) {
                        flag = false;
                    }
                }
            } else {
                String[] temp = Integer.toString(n).split("");
                int base_idx = 0;
                while (true) {
                    if (temp[base_idx].charAt(0) == num.charAt(num_idx)) {
                        num_idx += 1;
                        if (num_idx >= num.length()) {
                            flag = false;
                            break;
                        }
                    }
                    base_idx += 1;
                    if (base_idx >= temp.length) {
                        break;
                    }
                }
            }
            n += 1;
        }

        System.out.println(n-1);
    }
}
