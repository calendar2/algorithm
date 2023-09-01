def dfs(r, c):
    global cnt
    nr = r
    nc = c
    for k in range(4):
        row = nr + dr[k]
        col = nc + dc[k]
        if 0 <= row < N and 0 <= col < N:
            if rooms[nr][nc] + 1 == rooms[row][col]:
                cnt += 1
                dfs(row, col)

T = int(input())
for tc in range(1, T+1):
    N = int(input())    # 한 줄의 갯수
    rooms = [list(map(int, input().split())) for _ in range(N)]     # 방 번호

    # 상, 우, 하, 좌
    dr = [-1, 0, 1, 0]
    dc = [0, 1, 0, -1]

    # 방 번호, 횟수
    room_num = N*N+1
    result = 0
    cnt = 1

    # 탐색 시작
    for i in range(N):
        for j in range(N):
            cnt = 1
            dfs(i, j)
            if result < cnt:
                result = cnt
                room_num = rooms[i][j]
            elif result == cnt:
                if room_num > rooms[i][j]:
                    room_num = rooms[i][j]

    print(f'#{tc} {room_num} {result}')