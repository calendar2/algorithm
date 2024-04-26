import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            switch (order) {
                case "push":
                    q.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if (q.isEmpty()) {
                        sb.append("-1");
                    } else {
                        sb.append(q.poll());
                    }
                    sb.append("\n");
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    if (q.isEmpty()) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                    sb.append("\n");
                    break;
                case "front":
                    if (q.isEmpty()) {
                        sb.append("-1");
                    } else {
                        sb.append(q.peek());
                    }
                    sb.append("\n");
                    break;
                case "back":
                    if (q.isEmpty()) {
                        sb.append("-1");
                    } else {
                        sb.append(q.getLast());
                    }
                    sb.append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
