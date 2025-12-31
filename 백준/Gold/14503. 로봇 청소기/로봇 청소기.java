import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] room = new int[N][M];
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};

		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean isFinished = false;
		while (!isFinished) {
			room[r][c] = 2;
			for (int i = 0; i < 4; i++) {
				d -= 1;
				if (d < 0) {
					d = 3;
				}

				int nr = r + dr[d];
				int nc = c + dc[d];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
					continue;
				}

				if (room[nr][nc] == 0) {
					r = nr;
					c = nc;
					break;
				}

				if (i == 3) {
					int row = r - dr[d];
					int col = c - dc[d];

					if (room[row][col] == 1) {
						isFinished = true;
						break;
					}

					r =  row;
					c = col;
				}
			}
		}

		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (room[i][j] == 2) {
					count++;
				}
			}
		}

		System.out.println(count);
	}
}
