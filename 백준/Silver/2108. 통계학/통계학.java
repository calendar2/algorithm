import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer> numbers;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력
        N = Integer.parseInt(br.readLine());
        numbers = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            numbers.add(Integer.parseInt(br.readLine()));
        }

        sb.append(mean()).append("\n");
        sb.append(center()).append("\n");
        sb.append(mode()).append("\n");
        sb.append(range()).append("\n");

        System.out.println(sb);
    }

    // 산술 평균
    static int mean() {
        int total = 0;
        for (int i = 0; i < N; i++) {
            total += numbers.get(i);
        }

        double ans = (double)total / N;

        return (int)Math.round(ans);
    }

    // 중앙값
    static int center() {
        Collections.sort(numbers);
        return numbers.get(N/2);
    }

    // 최빈값
    static int mode() {
        int[] count = new int[8001];
        for (int i = 0; i < N; i++) {
            count[numbers.get(i)+4000]++;
        }

        boolean min = true;
        int mode_idx = 0;
        int mode_cnt = 0;
        for (int i = 0; i < 8001; i++) {
            if (count[i] == 0) continue;

            if (count[i] == mode_cnt && min) {
                mode_idx = i;
                min = false;
            }

            if (count[i] > mode_cnt) {
                mode_cnt = count[i];
                mode_idx = i;
                min = true;
            }
        }

        return mode_idx-4000;
    }

    // 범위
    static int range() {
        int num_range = 0;
        if (N > 1) {
            num_range = numbers.get(N-1) - numbers.get(0);
        }

        return num_range;
    }
}
