import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 초기 세팅
        String init = br.readLine();
        int N = init.length();
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (int i = 0; i < N; i++) {
            stack1.push(init.charAt(i));
        }

        // 명령어
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            switch (order) {
                case "L":
                    if (!stack1.isEmpty()) {
                        stack2.push(stack1.pop());
                    }
                    break;
                case "D":
                    if (!stack2.isEmpty()) {
                        stack1.push(stack2.pop());
                    }
                    break;
                case "B":
                    if (!stack1.isEmpty()) {
                        stack1.pop();
                    }
                    break;
                case "P":
                    char temp = st.nextToken().charAt(0);
                    stack1.push(temp);
                    break;
            }
        }

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        while (!stack2.isEmpty()) {
            sb.append(stack2.pop());
        }

        System.out.println(sb);
    }
}
