import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] students_number = new String[N];
        String[] changed_number = new String[N];

        for (int i = 0; i < N; i++) {
            students_number[i] = br.readLine();
            changed_number[i] = "";
        }

        Set<String> set = new HashSet<>();
        int len = students_number[0].length();
        int k = len;

        for (int i = len-1; i > 0; i--) {
            for (int j = 0; j < N; j++) {
                changed_number[j] = students_number[j].charAt(i) + changed_number[j];
                set.add(changed_number[j]);
            }

            if (set.size() == N) {
                k = len - i;
                break;
            }
            set.clear();
        }

        System.out.println(k);
    }
}
