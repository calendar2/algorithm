import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] original_arr = new int[N];
        int[] sorted_arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            original_arr[i] = sorted_arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sorted_arr);

        HashMap<Integer, Integer> coord_rank = new HashMap<>();
        int rank = 0;
        for (int i = 0; i < N; i++) {
            if (!coord_rank.containsKey(sorted_arr[i])) {
                coord_rank.put(sorted_arr[i], rank);
                rank++;
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(coord_rank.get(original_arr[i])).append(" ");
        }
        System.out.println(sb);
    }
}
