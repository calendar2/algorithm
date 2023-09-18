package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_12100 {
	// 전역변수
	static int N;
//	static boolean isok = false;
	static int[] line_info;
	static int max = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 보드의 크기
		N = Integer.parseInt(br.readLine());
		
		// 게임 판
		int[][] board = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 상, 우, 하, 좌 순서로 블록을 이동시키는 재귀함수를 호출
		for (int i = 0; i < 4; i++) {
			backtracking(0, board, i);
		}
		
		// 작업 끝났으니 출력
		System.out.println(max);
	}

	static void backtracking(int cnt, int[][] original_b, int direc) {
		// 함수가 호출되면 블록이 변경됐다는 표시를 해제하고 변경횟수를 받아온다
	//	isok = false;
		
		// 현재 게임판의 복사본을 생성
		int[][] new_b = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				new_b[i][j] = original_b[i][j];
			}
		}
		
		// 블록 두 개를 비교할 인덱스
		int num_idx = -1;
		
		// 한 줄의 정보를 저장할 배열, 시작 인덱스, 끝 인덱스
		line_info = new int[N];
		int s_idx = 0;
		int e_idx = N-1;
		
		switch(direc) {
			case 0:
				// 위, 아래로 비교하며 숫자를 합치는 작업
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {						
						if(new_b[j][i] != 0) {
							if(num_idx == -1) {		// 첫 번째 블록 확인 전
								num_idx = j;
							}else {
								if(new_b[j][i] == new_b[num_idx][i]) {		// num_idx의 원소와 같은 숫자이면
									new_b[num_idx][i] *= 2;
									new_b[j][i] = 0;
								//	isok = true;
								}
								num_idx = j;
							}
						}
					}
					num_idx = -1;	// 초기화
				}
				
			//	if(isok) {	// 블록 변경이 됐다면 블록을 올리는 작업을 진행
					for (int i = 0; i < N; i++) {
						for (int j = 0; j < N; j++) {
							if(new_b[j][i] == 0) {
								line_info[e_idx] = new_b[j][i];
								e_idx--;
							}else {
								line_info[s_idx] = new_b[j][i];
								s_idx++;
							}
						}
						
						// line_info에 한줄이 입력되면 순서대로 삽입한다
						for (int j = 0; j < N; j++) {
							new_b[j][i] = line_info[j];
						}
						
						// 작업이 끝났으니 변수를 초기화
						s_idx = 0;
						e_idx = N-1;
					}
			//	}
//				else {		// 블록 변경이 되지 않았다면 최댓값이 나올 수 없을테니 이후 가짓수는 생략하고 리턴
//					return;
//				}
				break;
			case 1:
				// 좌, 우로 비교하며 숫자를 합치는 작업
				for (int i = 0; i < N; i++) {
					for (int j = N-1; j >= 0; j--) {
						if(new_b[i][j] != 0) {
							if(num_idx == -1) {		// 첫 번째 블록 확인 전
								num_idx = j;
							}else {
								if(new_b[i][j] == new_b[i][num_idx]) {		// num_idx의 원소와 같은 숫자이면
									new_b[i][num_idx] *= 2;
									new_b[i][j] = 0;
								//	isok = true;
								}
								num_idx = j;
							}
						}
					}
					num_idx = -1;
				}
				
			//	if(isok) {	// 블록 변경이 됐다면 블록을 오른쪽으로 미는 작업을 진행
					for (int i = 0; i < N; i++) {
						for (int j = N-1; j >= 0; j--) {
							if(new_b[i][j] == 0) {
								line_info[s_idx] = new_b[i][j];
								s_idx++;
							}else {
								line_info[e_idx] = new_b[i][j];
								e_idx--;
							}
						}
						
						// line_info에 한줄이 입력되면 순서대로 삽입한다
						for (int j = 0; j < N; j++) {
							new_b[i][j] = line_info[j];
						}
						
						// 작업이 끝났으니 변수를 초기화
						s_idx = 0;
						e_idx = N-1;
					}
			//	}
//				else {		// 블록 변경이 되지 않았다면 최댓값이 나올 수 없을테니 이후 가짓수는 생략하고 리턴
//					return;
//				}
				break;
			case 2:
				// 위, 아래로 비교하며 숫자를 합치는 작업
				for (int i = 0; i < N; i++) {
					for (int j = N-1; j >= 0; j--) {
						if(new_b[j][i] != 0) {
							if(num_idx == -1) {		// 첫 번째 블록 확인 전
								num_idx = j;
							}else {
								if(new_b[j][i] == new_b[num_idx][i]) {		// num_idx의 원소와 같은 숫자이면
									new_b[num_idx][i] *= 2;
									new_b[j][i] = 0;
								//	isok = true;
								}
								num_idx = j;
							}
						}
					}
					num_idx = -1;
				}
				
			//	if(isok) {	// 블록 변경이 됐다면 블록을 내리는 작업을 진행
					for (int i = 0; i < N; i++) {
						for (int j = N-1; j >= 0; j--) {
							if(new_b[j][i] == 0) {
								line_info[s_idx] = new_b[j][i];
								s_idx++;
							}else {
								line_info[e_idx] = new_b[j][i];
								e_idx--;
							}
						}
						
						// line_info에 한줄이 입력되면 순서대로 삽입한다
						for (int j = 0; j < N; j++) {
							new_b[j][i] = line_info[j];
						}
						
						// 작업이 끝났으니 변수를 초기화
						s_idx = 0;
						e_idx = N-1;
					}
			//	}
//				else {		// 블록 변경이 되지 않았다면 최댓값이 나올 수 없을테니 이후 가짓수는 생략하고 리턴
//					return;
//				}
				break;
			case 3:
				// 좌, 우로 비교하며 숫자를 합치는 작업
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if(new_b[i][j] != 0) {
							if(num_idx == -1) {		// 첫 번째 블록 확인 전
								num_idx = j;
							}else {
								if(new_b[i][j] == new_b[i][num_idx]) {		// num_idx의 원소와 같은 숫자이면
									new_b[i][num_idx] *= 2;
									new_b[i][j] = 0;
								//	isok = true;
								}
								num_idx = j;
							}
						}
					}
					num_idx = -1;
				}
				
			//	if(isok) {	// 블록 변경이 됐다면 블록을 왼쪽으로 미는 작업을 진행
					for (int i = 0; i < N; i++) {
						for (int j = 0; j < N; j++) {
							if(new_b[i][j] == 0) {
								line_info[e_idx] = new_b[i][j];
								e_idx--;
							}else {
								line_info[s_idx] = new_b[i][j];
								s_idx++;
							}
						}
						
						// line_info에 한줄이 입력되면 순서대로 삽입한다
						for (int j = 0; j < N; j++) {
							new_b[i][j] = line_info[j];
						}
						
						// 작업이 끝났으니 변수를 초기화
						s_idx = 0;
						e_idx = N-1;
					}
			//	}
//				else {		// 블록 변경이 되지 않았다면 최댓값이 나올 수 없을테니 이후 가짓수는 생략하고 리턴
//					return;
//				}
				break;
		}
		
		// 블록 변경횟수 1회 추가
		int count = cnt + 1;
		
		if(count == 5) {	// 변경횟수가 5회라면 최댓값 비교
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(max < new_b[i][j]) {
						max = new_b[i][j];
					}
				}
			}
		}else {		// 변경횟수가 5회 미만이라면 다음 움직임 진행
			// 4방향 이동 : 0부터 3까지 순서대로 상, 우, 하, 좌
			for (int i = 0; i < 4; i++) {
				backtracking(count, new_b, i);
			}
			
			// 변경횟수 5회 미만 + 4방향 탐색이 끝나면 최댓값 비교(경우에 따라 최대 작업 횟수가 5회 미만이 나올수도 있으므로)
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					if(max < new_b[i][j]) {
//						max = new_b[i][j];
//					}
//				}
//			}
		}
	}
}
