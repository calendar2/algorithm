package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_12100 {
	// ��������
	static int N;
//	static boolean isok = false;
	static int[] line_info;
	static int max = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// ������ ũ��
		N = Integer.parseInt(br.readLine());
		
		// ���� ��
		int[][] board = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// ��, ��, ��, �� ������ ����� �̵���Ű�� ����Լ��� ȣ��
		for (int i = 0; i < 4; i++) {
			backtracking(0, board, i);
		}
		
		// �۾� �������� ���
		System.out.println(max);
	}

	static void backtracking(int cnt, int[][] original_b, int direc) {
		// �Լ��� ȣ��Ǹ� ����� ����ƴٴ� ǥ�ø� �����ϰ� ����Ƚ���� �޾ƿ´�
	//	isok = false;
		
		// ���� �������� ���纻�� ����
		int[][] new_b = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				new_b[i][j] = original_b[i][j];
			}
		}
		
		// ��� �� ���� ���� �ε���
		int num_idx = -1;
		
		// �� ���� ������ ������ �迭, ���� �ε���, �� �ε���
		line_info = new int[N];
		int s_idx = 0;
		int e_idx = N-1;
		
		switch(direc) {
			case 0:
				// ��, �Ʒ��� ���ϸ� ���ڸ� ��ġ�� �۾�
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {						
						if(new_b[j][i] != 0) {
							if(num_idx == -1) {		// ù ��° ��� Ȯ�� ��
								num_idx = j;
							}else {
								if(new_b[j][i] == new_b[num_idx][i]) {		// num_idx�� ���ҿ� ���� �����̸�
									new_b[num_idx][i] *= 2;
									new_b[j][i] = 0;
								//	isok = true;
								}
								num_idx = j;
							}
						}
					}
					num_idx = -1;	// �ʱ�ȭ
				}
				
			//	if(isok) {	// ��� ������ �ƴٸ� ����� �ø��� �۾��� ����
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
						
						// line_info�� ������ �ԷµǸ� ������� �����Ѵ�
						for (int j = 0; j < N; j++) {
							new_b[j][i] = line_info[j];
						}
						
						// �۾��� �������� ������ �ʱ�ȭ
						s_idx = 0;
						e_idx = N-1;
					}
			//	}
//				else {		// ��� ������ ���� �ʾҴٸ� �ִ��� ���� �� �����״� ���� �������� �����ϰ� ����
//					return;
//				}
				break;
			case 1:
				// ��, ��� ���ϸ� ���ڸ� ��ġ�� �۾�
				for (int i = 0; i < N; i++) {
					for (int j = N-1; j >= 0; j--) {
						if(new_b[i][j] != 0) {
							if(num_idx == -1) {		// ù ��° ��� Ȯ�� ��
								num_idx = j;
							}else {
								if(new_b[i][j] == new_b[i][num_idx]) {		// num_idx�� ���ҿ� ���� �����̸�
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
				
			//	if(isok) {	// ��� ������ �ƴٸ� ����� ���������� �̴� �۾��� ����
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
						
						// line_info�� ������ �ԷµǸ� ������� �����Ѵ�
						for (int j = 0; j < N; j++) {
							new_b[i][j] = line_info[j];
						}
						
						// �۾��� �������� ������ �ʱ�ȭ
						s_idx = 0;
						e_idx = N-1;
					}
			//	}
//				else {		// ��� ������ ���� �ʾҴٸ� �ִ��� ���� �� �����״� ���� �������� �����ϰ� ����
//					return;
//				}
				break;
			case 2:
				// ��, �Ʒ��� ���ϸ� ���ڸ� ��ġ�� �۾�
				for (int i = 0; i < N; i++) {
					for (int j = N-1; j >= 0; j--) {
						if(new_b[j][i] != 0) {
							if(num_idx == -1) {		// ù ��° ��� Ȯ�� ��
								num_idx = j;
							}else {
								if(new_b[j][i] == new_b[num_idx][i]) {		// num_idx�� ���ҿ� ���� �����̸�
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
				
			//	if(isok) {	// ��� ������ �ƴٸ� ����� ������ �۾��� ����
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
						
						// line_info�� ������ �ԷµǸ� ������� �����Ѵ�
						for (int j = 0; j < N; j++) {
							new_b[j][i] = line_info[j];
						}
						
						// �۾��� �������� ������ �ʱ�ȭ
						s_idx = 0;
						e_idx = N-1;
					}
			//	}
//				else {		// ��� ������ ���� �ʾҴٸ� �ִ��� ���� �� �����״� ���� �������� �����ϰ� ����
//					return;
//				}
				break;
			case 3:
				// ��, ��� ���ϸ� ���ڸ� ��ġ�� �۾�
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if(new_b[i][j] != 0) {
							if(num_idx == -1) {		// ù ��° ��� Ȯ�� ��
								num_idx = j;
							}else {
								if(new_b[i][j] == new_b[i][num_idx]) {		// num_idx�� ���ҿ� ���� �����̸�
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
				
			//	if(isok) {	// ��� ������ �ƴٸ� ����� �������� �̴� �۾��� ����
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
						
						// line_info�� ������ �ԷµǸ� ������� �����Ѵ�
						for (int j = 0; j < N; j++) {
							new_b[i][j] = line_info[j];
						}
						
						// �۾��� �������� ������ �ʱ�ȭ
						s_idx = 0;
						e_idx = N-1;
					}
			//	}
//				else {		// ��� ������ ���� �ʾҴٸ� �ִ��� ���� �� �����״� ���� �������� �����ϰ� ����
//					return;
//				}
				break;
		}
		
		// ��� ����Ƚ�� 1ȸ �߰�
		int count = cnt + 1;
		
		if(count == 5) {	// ����Ƚ���� 5ȸ��� �ִ� ��
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(max < new_b[i][j]) {
						max = new_b[i][j];
					}
				}
			}
		}else {		// ����Ƚ���� 5ȸ �̸��̶�� ���� ������ ����
			// 4���� �̵� : 0���� 3���� ������� ��, ��, ��, ��
			for (int i = 0; i < 4; i++) {
				backtracking(count, new_b, i);
			}
			
			// ����Ƚ�� 5ȸ �̸� + 4���� Ž���� ������ �ִ� ��(��쿡 ���� �ִ� �۾� Ƚ���� 5ȸ �̸��� ���ü��� �����Ƿ�)
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
