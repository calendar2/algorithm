import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        long result = 0;
        for (int i = 0; i < K; i++) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                stack.pop();
            } else {
                stack.add(n);
            }
        } // for loop

        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        System.out.println(result);
    }
}
