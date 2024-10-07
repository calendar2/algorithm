import java.io.*;

public class Main {
    static class Node {
        int num;
        Node left, right;

        Node(int num) {
            this.num = num;
        }

        void insert(int n) {
            if (n < this.num) {
                if (this.left == null) {
                    this.left = new Node(n);
                } else {
                    this.left.insert(n);
                }
            } else {
                if (this.right == null) {
                    this.right = new Node(n);
                } else {
                    this.right.insert(n);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()));
        while (true) {
            String input = br.readLine();
            if (input == null || input.equals("")) {
                break;
            }

            root.insert(Integer.parseInt(input));
        }

        post_order(root);
    }

    static void post_order(Node node) {
        if (node == null) {
            return;
        }

        post_order(node.left);
        post_order(node.right);
        System.out.println(node.num);
    }
}
