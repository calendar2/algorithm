package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// import java.util.Scanner;

public class boj_14501 {
	static int N;
	static int[][] arr;
	
	// 기록용 배열
	static int[] record;
	static int[] visited;
	
	static int result_max = 0;	// 수익 최댓값
	static int result = 0;	// 수익

	public static void main(String[] args) throws Exception {
		/*
		 * 백준 14501 - 퇴사
		 * 대표적인 DP를 이용한 문제인 것 같다.(DP 맞나...?)
		 * 입력은 소요날짜로 주어지지만 순서대로 1일부터 N일까지니까 시작, 끝 날짜 + 수익으로 2차원 배열을 만들고 수익으로 정렬한다.
		 * (도저히 안되겠어서 끝나는 날짜순으로 정렬했다)
		 * 방문처리용 배열을 만들어서 수익이 큰 순서대로 방문처리, 시작, 종료날짜를 비교하며 가장 많은 수익을 올리도록 조절한다.
		 * (원리는 비슷했지만 좀 더 브루트포스 방식으로 가능한 경우의 수를 다 대입하며 최댓값을 구했다)
		 */
		
		// Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// N = sc.nextInt();	// 날짜
		N = Integer.parseInt(br.readLine());
		int end = 0;	// 종료 날짜
		
		// 배열 만들기
		arr = new int[N+1][3];
		record = new int[N+1];
		visited = new int[N+1];
		visited[0] = 1;		// 0번째는 미리 방문처리
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = i;	// 시작 날짜
			// end = sc.nextInt();
			end = Integer.parseInt(st.nextToken());
			arr[i][1] = i + end;	// 종료 날짜
			// arr[i][2] = sc.nextInt();	// 수익
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		
		// 종료날짜를 기준으로 오름차순 정렬(람다식 사용)
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
	
	// 최대 수익을 찾기 위한 메서드
	static void search(int start) {
		boolean flag = true;
		
		visited[start] = 1;		// 방문처리
		if(arr[start][1] <= N) {
			record[start] = arr[start][2];
		}
		
		while(flag) {
			// 다음으로 가능한 곳 찾기
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
