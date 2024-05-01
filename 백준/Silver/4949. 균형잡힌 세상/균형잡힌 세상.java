import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String sentence = br.readLine();
            if (sentence.equals(".")) break;

            int length = sentence.length();
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < length; i++) {
                if (sentence.charAt(i) == '(' || sentence.charAt(i) == '[') {
                    stack.add(sentence.charAt(i));
                } else if (sentence.charAt(i) == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        sb.append("no").append("\n");
                        break;
                    } else if (stack.peek() == '(') {
                        stack.pop();
                    }
                } else if (sentence.charAt(i) == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        sb.append("no").append("\n");
                        break;
                    } else if (stack.peek() == '[') {
                        stack.pop();
                    }
                }

                if (i == length-1) {
                    if (stack.isEmpty()) {
                        sb.append("yes");
                    } else {
                        sb.append("no");
                    }
                    sb.append("\n");
                }
            }
        } // while loop

        System.out.println(sb);
    }
}
