import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

        char[][] bomb_map = new char[n][n];
        char[][] cur_map = new char[n][n];
        char[][] result_map = new char[n][n];

        // 지뢰 지도
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < n; j++) {
                bomb_map[i][j] = temp.charAt(j);
            }
        }

        // 플레이어가 현재 게임 중인 상태
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < n; j++) {
                cur_map[i][j] = temp.charAt(j);
            }
        }

        // 플레이어의 게임을 바탕으로 현재 지도의 숫자 표시
        boolean isFail = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cur_map[i][j] != 'x') {
                    result_map[i][j] = cur_map[i][j];
                    continue;
                }

                if (bomb_map[i][j] == '*') {
                    isFail = true;
                    continue;
                }

                int cnt = 0;
                for (int k = 0; k < 8; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];

                    if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                        if (bomb_map[nr][nc] == '*') {
                            cnt += 1;
                        }
                    }
                }

                result_map[i][j] = (char) ('0' + cnt);
            }
        }

        // 지뢰를 밝았다면 지도에 지뢰 표시
        if (isFail) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (bomb_map[i][j] == '*') {
                        result_map[i][j] = bomb_map[i][j];
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            String ans = "";
            for (int j = 0; j < n; j++) {
                ans += result_map[i][j];
            }
            sb.append(ans).append('\n');
        }

        System.out.println(sb);
    }
}
