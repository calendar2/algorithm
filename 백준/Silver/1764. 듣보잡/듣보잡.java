import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> no_hear = new HashMap<>();
        for (int i = 0; i < N; i++) {
            no_hear.put(br.readLine(), i);
        }

        // 탐색
        ArrayList<String> no_hear_no_see = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String no_see = br.readLine();
            if (no_hear.containsKey(no_see)) {
                no_hear_no_see.add(no_see);
            }
        }

        // 정렬
        Collections.sort(no_hear_no_see);
        sb.append(no_hear_no_see.size()).append("\n");
        for (String answer : no_hear_no_see) {
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}
