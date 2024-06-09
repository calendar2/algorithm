import java.io.*;
import java.util.*;

public class Main {
    static int r;
    static int c;
    static int cnt = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int)Math.pow(2, N);
        dac(0, size, 0, size);
        System.out.println(cnt);
    }

    static void dac(int s_row, int e_row, int s_col, int e_col) {
        if (e_row-s_row == 1) {
            cnt++;
            return;
        }

        int m_row = (s_row+e_row) / 2;
        int m_col = (s_col+e_col) / 2;

        if (r >= s_row && r < m_row && c >= s_col && c < m_col) {
            dac(s_row, m_row, s_col, m_col);
        } else if (r >= s_row && r < m_row && c >= m_col && c < e_col) {
            cnt += (m_row-s_row) * (m_col-s_col);
            dac(s_row, m_row, m_col, e_col);
        } else if (r >= m_row && r < e_row && c >= s_col && c < m_col) {
            cnt += (m_row-s_row) * (e_col-s_col);
            dac(m_row, e_row, s_col, m_col);
        } else {
            cnt += (m_row-s_row) * (e_col-s_col) + (e_row-s_row) * (m_col-s_col) - (m_row-s_row) * (m_col-s_col);
            dac(m_row, e_row, m_col, e_col);
        }
    }
}
