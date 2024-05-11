import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 횟수 입력 및 변수 선언
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<Integer, String> pokemon_name = new HashMap<>();
        HashMap<String, Integer> pokemon_num = new HashMap<>();

        // 포켓몬 도감의 입력
        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            pokemon_name.put(i, name);
            pokemon_num.put(name, i);
        }

        // 내가 맞춰야 하는 포켓몬
        for (int i = 0; i < M; i++) {
            String question = br.readLine();

            if (pokemon_num.containsKey(question)) {
                sb.append(pokemon_num.get(question));
            } else {
                sb.append(pokemon_name.get(Integer.parseInt(question)));
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
