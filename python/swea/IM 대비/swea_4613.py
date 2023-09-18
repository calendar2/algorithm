# 이건 공부를 다시 해보자!
T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())    # N행 M열
    flags = [list(input()) for _ in range(N)]   # 현재 깃발 상태
    min_v = 2500

    work = [[0] * 3 for _ in range(N)]

    # 맨 윗줄을 각각 한 가지 색으로 바꾸기 위한 색칠 횟수
    for j in range(M):
        if flags[0][j] != 'W':
            work[0][0] += 1
        if flags[0][j] != 'B':
            work[0][1] += 1
        if flags[0][j] != 'R':
            work[0][2] += 1

    # 맨 윗줄의 색칠 횟수를 나머지 줄에도 적용
    for i in range(1, N):
        work[i][0] = work[i - 1][0]
        work[i][1] = work[i - 1][1]
        work[i][2] = work[i - 1][2]
        # 매 줄마다 각 색깔로 변경하기 위한 갯수를 구해서 그 전 줄 색칠 갯수와 합산
        for j in range(M):
            if flags[i][j] != 'W':
                work[i][0] += 1
            if flags[i][j] != 'B':
                work[i][1] += 1
            if flags[i][j] != 'R':
                work[i][2] += 1

    # 행기준 3개의 영역으로 구분
    for i in range(N - 2):  # 맨 아래에서 두 줄은 무조건 B,R 영역으로 칠해야 함
        for j in range(i + 1, N - 1):  # 하양 다음 줄부터 마지막 줄 전 줄까지는 파랑을 칠할 수 있는 영역
            Wcnt = work[i][0]
            Bcnt = work[j][1] - work[i][1]
            Rcnt = work[N - 1][2] - work[j][2]
            if min_v > Wcnt + Bcnt + Rcnt:
                min_v = Wcnt + Bcnt + Rcnt

    print(f'#{tc} {min_v}')