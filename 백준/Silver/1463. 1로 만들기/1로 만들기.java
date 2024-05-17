import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] count = new int[1000001];
        for (int i = 2; i <= 1000000; i++) {
            count[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= 1000000; i++) {
            int cnt = count[i];

            if (i+1 <= 1000000 && (cnt+1 < count[i+1])) {
                count[i+1] = cnt + 1;
            }

            if (i*2 <= 1000000 && (cnt+1 < count[i*2])) {
                count[i*2] = cnt + 1;
            }

            if (i*3 <= 1000000 && (cnt+1 < count[i*3])) {
                count[i*3] = cnt + 1;
            }
        }

        System.out.println(count[N]);
    }
}
