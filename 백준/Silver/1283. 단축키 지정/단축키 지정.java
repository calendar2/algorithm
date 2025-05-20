import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb1 = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] options = new String[N];
        for (int i = 0; i < N; i++) {
            options[i] = br.readLine();
        }

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            boolean isOk = false;
            String s = options[i];

            // 1
            String[] arr = s.split(" ");
            for (int j = 0; j < arr.length; j++) {
                char c = arr[j].toLowerCase().charAt(0);
                if (set.add(c)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("[").append(arr[j].charAt(0)).append("]").append(arr[j].substring(1));
                    arr[j] = sb2.toString();
                    isOk = true;
                    break;
                }
            }

            if (isOk) {
                StringBuilder sb3 = new StringBuilder();
                for (int j = 0; j < arr.length; j++) {
                    sb3.append(arr[j]).append(" ");
                }
                options[i] = sb3.toString();
            } else { // 2
                String[] arr2 = s.split("");
                for (int j = 0; j < arr2.length; j++) {
                    if (arr2[j].equals(" ")) {
                        continue;
                    }

                    if (set.add(arr2[j].toLowerCase().charAt(0))) {
                        arr2[j] = "[" + arr2[j] + "]";
                        isOk = true;
                        break;
                    }
                }

                if (isOk) {
                    StringBuilder sb4 = new StringBuilder();
                    for (int j = 0; j < arr2.length; j++) {
                        sb4.append(arr2[j]);
                    }
                    options[i] = sb4.toString();
                }
            }
        }

        for (int i = 0; i < N; i++) {
            sb1.append(options[i]).append("\n");
        }
        System.out.println(sb1);
    }
}
