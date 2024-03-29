T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())    # N : 보드의 길이, M : 돌을 놓는 횟수
    play = [list(map(int, input().split())) for _ in range(M)]      # 돌을 놓는 방법

    arr = [[0] * N for _ in range(N)]   # 보드 제작

    # 초기 셋팅
    arr[N//2-1][N//2-1] = 2
    arr[N//2-1][N//2] = 1
    arr[N//2][N//2-1] = 1
    arr[N//2][N//2] = 2

    # 상, 우상, 우, 우하, 하, 좌하, 좌, 좌상
    dr = [-1, -1, 0, 1, 1, 1, 0, -1]
    dc = [0, 1, 1, 1, 0, -1, -1, -1]
    temp = []

    # 사이에 있는 돌 뒤집기
    switch = False
    cnt = 0

    for i in range(M):
        # 돌 착수
        arr[play[i][1]-1][play[i][0]-1] = play[i][2]

        # 8방향으로 같은 돌이 있는지 탐색
        for j in range(8):
            # 착수점 바로 인접하게 돌이 있을 경우부터 탐색
            nr = (play[i][1] - 1) + dr[j]
            nc = (play[i][0] - 1) + dc[j]
            if 0 <= nr < N and 0 <= nc < N:
                if arr[nr][nc] != 0 and arr[nr][nc] != play[i][2]:
                    for k in range(2, N):
                        nr = (play[i][1] - 1) + dr[j] * k
                        nc = (play[i][0] - 1) + dc[j] * k

                        if 0 <= nr < N and 0 <= nc < N:
                            if arr[nr][nc] == 0:
                                break
                            # 같은 색 돌이 놓여있으면 탐색 종료
                            elif arr[nr][nc] == play[i][2]:
                                switch = True
                                cnt = k
                                break

                    # 탐색 후 뒤집기 가능한 곳을 배열에 담기
                    if switch:
                        for l in range(1, cnt):
                            nr = (play[i][1] - 1) + dr[j] * l
                            nc = (play[i][0] - 1) + dc[j] * l
                            temp.append((nr, nc))
                        switch = False

        # 8방향 전부 탐색이 되어 뒤집기 가능한 점을 찾아내면
        while temp:
            row, col = temp.pop(0)
            arr[row][col] = play[i][2]

    # 흑돌, 백돌 갯수 탐색
    black = 0
    white = 0
    for i in range(N):
        for j in range(N):
            if arr[i][j] == 1:
                black += 1
            elif arr[i][j] == 2:
                white += 1

    print(f'#{tc} {black} {white}')