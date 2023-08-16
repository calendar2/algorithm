T = int(input())
for tc in range(1, T+1):
    N = int(input())    # 미로의 크기
    maze = [list(input()) for _ in range(N)]
    stack = []

    # 좌, 상, 우, 하
    dr = [0, -1, 0, 1]
    dc = [-1, 0, 1, 0]

    col = 0
    row = 0
    success = 0     # 성공 여부

    # 시작지점 찾기 + 미로 숫자로 변경
    for i in range(N):
        for j in range(N):
            maze[i][j] = int(maze[i][j])
            if maze[i][j] == 2:
                col = j
                row = i

    # 시작지점
    s_row = row
    s_col = col

    # 미로 탐색
    while True:
        maze[row][col] = 1  # 방문처리

        for i in range(4):
            nr = row + dr[i]
            nc = col + dc[i]

            if 0 <= nr < N and 0 <= nc < N:
                if maze[nr][nc] != 1:
                    stack.append([row, col])
                    row = nr
                    col = nc
                    break

        # 도착지에 들어가면 성공
        if maze[row][col] == 3:
            success = 1
            break

        # 만약 좌,상,우,하 전부 돌았는데 갈 수 있는 곳이 없으면 다시 돌아가
        if maze[row][col] == 1:
            if row == s_row and col == s_col:
                break
            else:
                row = stack[-1][0]
                col = stack[-1][1]
                stack.pop()

    print(f'#{tc} {success}')