import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> grades = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            grades.add(i, Integer.parseInt(br.readLine()));
        }

        // Collection 정렬로 정렬하고 절사 평균?
        Collections.sort(grades);
        double double_n = (double) n;
        int except_num = (int)Math.round(double_n * 0.15);

        int total_grade = 0;
        for (int i = except_num; i < n-except_num; i++) {
            total_grade += grades.get(i);
        }

        int result = (int)Math.round((double) total_grade / (n - except_num*2));
        System.out.println(result);
    }
}
