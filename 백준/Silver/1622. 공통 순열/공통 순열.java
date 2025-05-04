import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            String a = br.readLine();
            if (a == null) {
                break;
            }
            String b = br.readLine();

            int len = b.length();
            boolean[] visited = new boolean[len];
            List<Character> list = new ArrayList<>();

            for (int i = 0; i < a.length(); i++) {
                char c = a.charAt(i);
                for (int j = 0; j < len; j++) {
                    if (visited[j]) {
                        continue;
                    }

                    if (c == b.charAt(j)) {
                        list.add(c);
                        visited[j] = true;
                        break;
                    }
                }
            }

            Collections.sort(list);
            for (char l: list) {
                sb.append(l);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
