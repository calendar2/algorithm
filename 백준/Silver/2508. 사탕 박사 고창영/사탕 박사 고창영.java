import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            br.readLine();
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            char[][] box = new char[r][c];
            for (int i = 0; i < r; i++) {
                String line = br.readLine();
                for (int j = 0; j < c; j++) {
                    box[i][j] = line.charAt(j);
                }
            }

            int cnt = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (box[i][j] == '>') {
                        if (j + 2 < c) {
                            if (box[i][j+1] == 'o' &&  box[i][j+2] == '<') {
                                cnt += 1;
                            }
                        }
                    } else if (box[i][j] == 'v') {
                        if (i + 2 < r) {
                            if (box[i+1][j] == 'o' &&  box[i+2][j] == '^') {
                                cnt += 1;
                            }
                        }
                    }
                }
            }

            sb.append(cnt).append("\n");
        } // tc for

        System.out.println(sb);
    }
}
