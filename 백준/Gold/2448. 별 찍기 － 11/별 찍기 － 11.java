import java.util.*;

public class Main {
    static char[][] stars;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        stars = new char[N][N*2-1];
        for (int i = 0; i < N; i++) {
            Arrays.fill(stars[i], ' ');
        }

        print_star(0, N-1, N);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N*2-1; j++) {
                sb.append(stars[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void print_star(int r, int c, int n) {
        if (n == 3) {
            stars[r][c] = '*';
            stars[r+1][c-1] = stars[r+1][c+1] = '*';
            stars[r+2][c-2] = stars[r+2][c-1] = stars[r+2][c] = stars[r+2][c+1] = stars[r+2][c+2] = '*';
        } else {
            int mid = n / 2;
            print_star(r, c, mid);
            print_star(r+mid, c-mid, mid);
            print_star(r+mid, c+mid, mid);
        }
    }
}
