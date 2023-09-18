package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// import java.util.Scanner;

public class boj_14501 {
	static int N;
	static int[][] arr;
	
	// ��Ͽ� �迭
	static int[] record;
	static int[] visited;
	
	static int result_max = 0;	// ���� �ִ�
	static int result = 0;	// ����

	public static void main(String[] args) throws Exception {
		/*
		 * ���� 14501 - ���
		 * ��ǥ���� DP�� �̿��� ������ �� ����.(DP �³�...?)
		 * �Է��� �ҿ䳯¥�� �־������� ������� 1�Ϻ��� N�ϱ����ϱ� ����, �� ��¥ + �������� 2���� �迭�� ����� �������� �����Ѵ�.
		 * (������ �ȵǰھ ������ ��¥������ �����ߴ�)
		 * �湮ó���� �迭�� ���� ������ ū ������� �湮ó��, ����, ���ᳯ¥�� ���ϸ� ���� ���� ������ �ø����� �����Ѵ�.
		 * (������ ��������� �� �� ���Ʈ���� ������� ������ ����� ���� �� �����ϸ� �ִ��� ���ߴ�)
		 */
		
		// Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// N = sc.nextInt();	// ��¥
		N = Integer.parseInt(br.readLine());
		int end = 0;	// ���� ��¥
		
		// �迭 �����
		arr = new int[N+1][3];
		record = new int[N+1];
		visited = new int[N+1];
		visited[0] = 1;		// 0��°�� �̸� �湮ó��
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = i;	// ���� ��¥
			// end = sc.nextInt();
			end = Integer.parseInt(st.nextToken());
			arr[i][1] = i + end;	// ���� ��¥
			// arr[i][2] = sc.nextInt();	// ����
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		
		// ���ᳯ¥�� �������� �������� ����(���ٽ� ���)
//		Arrays.sort(arr, (o1, o2) -> {
//			return o1[1] - o2[1];
//		});
		
		search(1);
		
		for (int i = 0; i < N+1; i++) {
			if(result_max < record[i]) {
				result_max = record[i];
			}
		}
		
		System.out.println(result_max);
	}
	
	// �ִ� ������ ã�� ���� �޼���
	static void search(int start) {
		boolean flag = true;
		
		visited[start] = 1;		// �湮ó��
		if(arr[start][1] <= N) {
			record[start] = arr[start][2];
		}
		
		while(flag) {
			// �������� ������ �� ã��
			int next = arr[start][1];
			if(next <= N) {
				visited[next] = 1;
			}else {
				for (int i = 0; i < arr.length; i++) {
					if(visited[i] == 0) {
						next = i;
						start = 0;
						visited[next] = 1;
						break;
					}
				}
			}
			
			if(arr[next][1] <= N+1) {
				result = record[start] + arr[next][2];
				if(result > record[next]) {
					record[next] = result;
				}
			}
			
			start = next;
			
			for (int i = 0; i < N+1; i++) {
				if(visited[i] == 0) {
					break;
				}
				if(i == N) {
					flag = false;
				}
			}
		}
	}

}
