import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            switch (order) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if (stack.isEmpty()) {
                        sb.append("-1");
                    } else {
                        sb.append(stack.pop());
                    }
                    sb.append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    if (stack.isEmpty()) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                    sb.append("\n");
                    break;
                case "top":
                    if (stack.isEmpty()) {
                        sb.append("-1");
                    } else {
                        sb.append(stack.peek());
                    }
                    sb.append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
