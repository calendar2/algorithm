import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            answer[i] = Integer.parseInt(br.readLine());
        }

        int answer_idx = 0;
        int num = 1;
        while (true) {
            if (stack.isEmpty()) {
                stack.push(num);
                sb.append("+").append("\n");
                num++;
            } else {
                while (stack.peek() == answer[answer_idx]) {
                    stack.pop();
                    sb.append("-").append("\n");
                    answer_idx++;

                    if (stack.isEmpty()) {
                        break;
                    }
                }

                if (num > n || answer_idx == n) {
                    break;
                }
                stack.push(num);
                sb.append("+").append("\n");
                num++;
            }
        }

        if (stack.isEmpty() && answer_idx >= n) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }
}
