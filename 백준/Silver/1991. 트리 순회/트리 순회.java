import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static String[][] trees;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        trees = new String[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            trees[i][0] = st.nextToken();
            trees[i][1] = st.nextToken();
            trees[i][2] = st.nextToken();
        }

        preorder("A");
        sb.append("\n");
        inorder("A");
        sb.append("\n");
        postorder("A");
        System.out.println(sb);
    }

    static void preorder(String node) {
        if (node.equals(".")) {
            return;
        }

        for (int i = 0; i < N; i++) {
            if (trees[i][0].equals(node)) {
                sb.append(trees[i][0]);
                preorder(trees[i][1]);
                preorder(trees[i][2]);
            }
        }
    }

    static void inorder(String node) {
        if (node.equals(".")) {
            return;
        }

        for (int i = 0; i < N; i++) {
            if (trees[i][0].equals(node)) {
                inorder(trees[i][1]);
                sb.append(trees[i][0]);
                inorder(trees[i][2]);
            }
        }
    }

    static void postorder(String node) {
        if (node.equals(".")) {
            return;
        }

        for (int i = 0; i < N; i++) {
            if (trees[i][0].equals(node)) {
                postorder(trees[i][1]);
                postorder(trees[i][2]);
                sb.append(trees[i][0]);
            }
        }
    }
}
