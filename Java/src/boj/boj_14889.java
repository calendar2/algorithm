package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_14889 {
	// ��������
	static int[][] arr;
	static List<Integer> team1 = new ArrayList<Integer>();
	static List<Integer> team2 = new ArrayList<Integer>();
	
	static int t1_s = 0;
	static int t2_s = 0;
	static int s_min = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());	// ȸ�� ��
		
		// �� �ó���
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// �ε��� ���տ� �迭, �湮ó���� �迭
		boolean[] visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			visited[i] = false;
		}
		
		// �ó��� �� �ʱ�ȭ
		s_min = Integer.MAX_VALUE;
		
		comb(visited, 0, N, N/2);
		System.out.println(s_min);
	}
	
	// ���� �˰���(ȸ���� �������� ������ ����)
	static void comb(boolean[] visited, int start, int n, int r) {
		if(r == 0) {
			t1_s = 0;
			t2_s = 0;
			
			for (int i = 0; i < n; i++) {
				// �湮ó���� �ε����� q1��, �湮ó������ ���� �ε����� q2�� ����
				if(visited[i]) {
					team1.add(i);
				}else {
					team2.add(i);
				}
			}
			
			// �ݺ��ϸ� �ó��� �� ���ϱ�
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
