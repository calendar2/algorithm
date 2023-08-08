import sys

N = int(sys.stdin.readline())       # 라운드 횟수

A_list = []     # A의 딱지 모양
B_list = []     # B의 딱지 모양
winner = ''

# 각 라운드 딱지 모양 리스트
for i in range(N):
    temp_A = list(map(int, sys.stdin.readline().split()))
    temp_B = list(map(int, sys.stdin.readline().split()))

    A_list.append(temp_A)
    B_list.append(temp_B)

# A, B의 딱지 모양 중 우선순위의 갯수
cnt_A = 0
cnt_B = 0

# 각 라운드간 이긴 사람
for i in range(N):
    cnt_A = 0
    cnt_B = 0

    for j in range(4, 0, -1):
        for a in range(1, A_list[i][0]+1):
            if A_list[i][a] == j:
                cnt_A += 1

        for b in range(1, B_list[i][0]+1):
            if B_list[i][b] == j:
                cnt_B += 1

        # 승자 판별
        if cnt_A > cnt_B:
            winner = 'A'
            break
        elif cnt_A < cnt_B:
            winner = 'B'
            break
        else:
            if j == 1:
                winner = 'D'

    print(winner)

# print(A_list)
# print(B_list)