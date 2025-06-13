import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] liquids = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            liquids[i] = Integer.parseInt(st.nextToken());
        }

        int min = 2000000000;
        int left = 0;
        int right = N - 1;
        int left_idx = 0;
        int right_idx = N - 1;

        while (left < right) {
            if (min >= Math.abs(liquids[left] + liquids[right])) {
                min = Math.abs(liquids[left] + liquids[right]);
                left_idx = left;
                right_idx = right;
            }

            if (liquids[left] + liquids[right] >= 0) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(liquids[left_idx] + " " + liquids[right_idx]);
    }
}
