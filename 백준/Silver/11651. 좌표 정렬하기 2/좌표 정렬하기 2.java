import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        ArrayList<ArrayList<Integer>> two_dimension = new ArrayList<>();
        for (int i = 0; i < 200001; i++) {
            two_dimension.add(i, new ArrayList<>());
        }

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            two_dimension.get(y+100000).add(x);
        }

        for (int i = 0; i < 200001; i++) {
            Collections.sort(two_dimension.get(i));
        }

        for (int i = 0; i < 200001; i++) {
            if (two_dimension.get(i).size() > 0) {
                for (int x: two_dimension.get(i)) {
                    sb.append(x).append(" ").append(i-100000).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
