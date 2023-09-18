package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_14889 {
	// 전역변수
	static int[][] arr;
	static List<Integer> team1 = new ArrayList<Integer>();
	static List<Integer> team2 = new ArrayList<Integer>();
	
	static int t1_s = 0;
	static int t2_s = 0;
	static int s_min = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());	// 회원 수
		
		// 팀 시너지
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 인덱스 조합용 배열, 방문처리용 배열
		boolean[] visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			visited[i] = false;
		}
		
		// 시너지 차 초기화
		s_min = Integer.MAX_VALUE;
		
		comb(visited, 0, N, N/2);
		System.out.println(s_min);
	}
	
	// 조합 알고리즘(회원을 절반으로 나누기 위해)
	static void comb(boolean[] visited, int start, int n, int r) {
		if(r == 0) {
			t1_s = 0;
			t2_s = 0;
			
			for (int i = 0; i < n; i++) {
				// 방문처리된 인덱스면 q1에, 방문처리되지 않은 인덱스는 q2에 삽입
				if(visited[i]) {
					team1.add(i);
				}else {
					team2.add(i);
				}
			}
			
			// 반복하며 시너지 차 구하기
			for (int i = 0; i < team1.size(); i++) {
				for (int j = 0; j < team1.size(); j++) {
					if(i != j) {
						t1_s += arr[team1.get(i)][team1.get(j)];
						t2_s += arr[team2.get(i)][team2.get(j)];
					}
				}
			}
			
			if(s_min > Math.abs(t1_s - t2_s)) {
				s_min = Math.abs(t1_s - t2_s);
			}
			
			team1.clear();
			team2.clear();
			return;
		}
		
		for (int i = start; i < n; i++) {
			visited[i] = true;
			comb(visited, i+1, n, r-1);
			visited[i] = false;
		}
	}

}
