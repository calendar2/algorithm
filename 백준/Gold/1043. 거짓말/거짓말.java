import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[] truth;
    static int[] parent;
    static ArrayList<ArrayList<Integer>> party = new ArrayList<>();
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int true_cnt = Integer.parseInt(st.nextToken());
        truth = new int[true_cnt];

        for (int i = 0; i < true_cnt; i++) {
            truth[i] = Integer.parseInt(st.nextToken());
        }

        parent = new int[N+1];

        for (int i = 0; i <= M; i++) {
            party.add(new ArrayList<>());
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int guests = Integer.parseInt(st.nextToken());
            for (int j = 0; j < guests; j++) {
                party.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= M; i++) {
            int first = party.get(i).get(0);
            for (int j = 1; j < party.get(i).size(); j++) {
                union(first, party.get(i).get(j));
            }
        }

        for (int i = 1; i <= M; i++) {
            int leader = party.get(i).get(0);
            boolean flag = true;
            for (int j = 0; j < true_cnt; j++) {
                if (isSame(leader, truth[j])) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static int find(int a) {
        if (parent[a] == a) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    static boolean isSame(int a, int b) {
        if (find(a) == find(b)) {
            return true;
        } else {
            return false;
        }
    }
}
