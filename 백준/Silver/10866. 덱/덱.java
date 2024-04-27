import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            switch (order) {
                case "push_front":
                    dq.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    dq.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if (dq.isEmpty()) {
                        sb.append("-1");
                    } else {
                        sb.append(dq.pollFirst());
                    }
                    sb.append("\n");
                    break;
                case "pop_back":
                    if (dq.isEmpty()) {
                        sb.append("-1");
                    } else {
                        sb.append(dq.pollLast());
                    }
                    sb.append("\n");
                    break;
                case "size":
                    sb.append(dq.size()).append("\n");
                    break;
                case "empty":
                    if (dq.isEmpty()) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                    sb.append("\n");
                    break;
                case "front":
                    if (dq.isEmpty()) {
                        sb.append("-1");
                    } else {
                        sb.append(dq.getFirst());
                    }
                    sb.append("\n");
                    break;
                case "back":
                    if (dq.isEmpty()) {
                        sb.append("-1");
                    } else {
                        sb.append(dq.getLast());
                    }
                    sb.append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
