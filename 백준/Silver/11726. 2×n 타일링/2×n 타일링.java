import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n <= 2) {
            System.out.println(n);
        } else {
            long[] tiles = new long[n+1];
            tiles[1] = 1L;
            tiles[2] = 2L;

            for (int i = 3; i <= n; i++) {
                tiles[i] = (tiles[i-1] + tiles[i-2]) % 10007;
            }

            System.out.println(tiles[n] % 10007L);
        }
    }
}
