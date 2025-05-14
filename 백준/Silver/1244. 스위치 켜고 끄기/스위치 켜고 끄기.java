import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] status = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            status[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[][] students = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            students[i][0] = Integer.parseInt(st.nextToken());
            students[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            if (students[i][0] == 1) {
                for (int j = 1; j <= n; j++) {
                    if (j % students[i][1] == 0) {
                        if (status[j] == 0) {
                            status[j] = 1;
                        } else {
                            status[j] = 0;
                        }
                    }
                }
            } else {
                if (status[students[i][1]] == 0) {
                    status[students[i][1]] = 1;
                } else {
                    status[students[i][1]] = 0;
                }

                int left = students[i][1] - 1;
                int right = students[i][1] + 1;
                while (left >= 1 && right <= n) {
                    if (status[left] != status[right]) {
                        break;
                    }

                    if (status[left] == 0) {
                        status[left] = 1;
                        status[right] = 1;
                    } else {
                        status[left] = 0;
                        status[right] = 0;
                    }

                    left -= 1;
                    right += 1;
                }
            }
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            sb.append(status[i]).append(" ");
            cnt += 1;

            if (cnt == 20) {
                sb.append("\n");
                cnt = 0;
            }
        }

        System.out.println(sb);
    }
}
