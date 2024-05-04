import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int M = sc.nextInt();
        int N = sc.nextInt();

        // 소수 구하기
        boolean[] isPrime = new boolean[N+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        // i*i 가 N 이하일 때만 확인해도 된다.
        // 예를들어 N이 100일 경우 10의 배수까지만 확인해도 모든 소수를 찾는다.
        // 11의 배수는 11*1, 11*2, 11*3 ~~~ 11*9까지만 존재하는데 이미 앞선 숫자들에서 모두 확인된 숫자이다.
        for (int i = 2; i*i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i*i; j <= N; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        // 소수 출력
        for (int i = M; i <= N; i++) {
            if (isPrime[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}
