import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            // 초기 입력
            int n = Integer.parseInt(br.readLine());
            HashMap<String, ArrayList<String>> clothes = new HashMap<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String cloth = st.nextToken();
                String kind = st.nextToken();

                if (clothes.containsKey(kind)) {
                    clothes.get(kind).add(cloth);
                } else {
                    ArrayList<String> list = new ArrayList<>();
                    list.add(cloth);
                    clothes.put(kind, list);
                }
            }

            // 경우의 수 계산
            int num = 1;
            for (ArrayList<String> list : clothes.values()) {
                num *= list.size()+1;
            }

            if (n == 0) {
                sb.append(0).append("\n");
            } else {
                sb.append(num-1).append("\n");
            }
        } // tc for

        System.out.println(sb);
    }
}
