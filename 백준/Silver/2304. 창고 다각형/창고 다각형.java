import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] pillars = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pillars[i][0] = Integer.parseInt(st.nextToken());
            pillars[i][1] = Integer.parseInt(st.nextToken());
        }

        // 위치별 정렬
        Arrays.sort(pillars, (a, b) -> a[0] - b[0]);

        // 가장 큰 기둥의 인덱스
        int max_idx = -1;
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (pillars[i][1] > max) {
                max = pillars[i][1];
                max_idx = i;
            }
        }

        List<int[]> left_list = new ArrayList<>();
        int left_max = 0;
        for (int i = 0; i <= max_idx; i++) {
            if (pillars[i][1] > left_max) {
                left_max = pillars[i][1];
                left_list.add(new int[] {pillars[i][0], pillars[i][1]});
            }
        }

        List<int[]> right_list = new ArrayList<>();
        int right_max = 0;
        for (int i = N-1; i > max_idx; i--) {
            if (pillars[i][1] > right_max) {
                right_max = pillars[i][1];
                right_list.add(new int[] {pillars[i][0], pillars[i][1]});
            }
        }
        right_list.add(new int[] {pillars[max_idx][0], pillars[max_idx][1]});

        int area = 0;
        // 왼쪽 기둥 계산
        int[] start = left_list.get(0);
        int l_width = start[0];
        int l_height = start[1];
        for (int i = 1; i < left_list.size(); i++) {
            int[] cur = left_list.get(i);
            int width = cur[0] - l_width;
            int height = l_height;
            area += width * height;

            l_width = cur[0];
            l_height = cur[1];
        }

        // 오른쪽 기둥 계산
        int[] start2 = right_list.get(0);
        int r_width = start2[0];
        int r_height = start2[1];
        for (int i = 1; i < right_list.size(); i++) {
            int[] cur = right_list.get(i);
            int width = r_width - cur[0];
            int height = r_height;
            area += width * height;

            r_width = cur[0];
            r_height = cur[1];
        }

        System.out.println(area + max);
    }
}
