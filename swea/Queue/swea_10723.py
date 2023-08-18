def BFS(s_row, s_col, n):
    queue = []
    queue.append((s_row, s_col))     # 시작점 v를 큐에 삽입
    visited[s_row][s_col] = 0
    while queue:    # 큐가 비어있지 않은 경우
        s_row, s_col = queue.pop(0)    # 큐의 첫번째 원소 반환
        # 좌상우하
        for dr, dc in [[0, -1], [-1, 0], [0, 1], [1, 0]]:
            if 0 <= s_row+dr < n and 0 <= s_col+dc < n:
                nr = s_row + dr
                nc = s_col + dc
                if maze[nr][nc] == 0:  # 방문되지 않는 곳이라면
                    queue.append((nr, nc))  # 큐에 삽입
                    maze[nr][nc] = 1    # 방문처리해주고
                    visited[nr][nc] = visited[s_row][s_col] + 1     # 이전 카운트로부터 + 1
                elif maze[nr][nc] == 3:     # 만약 도착지라면
                    return s_row, s_col
    return -1, -1   # 도착지에 도착하지 못 하면 row, col에 -1을 반환해준다.

T = int(input())
for tc in range(1, T+1):
    N = int(input())    # 미로의 크기
    maze = [list(input()) for _ in range(N)]    # 미로
    visited = [[0] * N for _ in range(N)]   # 카운트용 배열

    col = 0
    row = 0

    # 미로의 요소 숫자로 변경 + 시작점 찾기
    for i in range(N):
        for j in range(N):
            maze[i][j] = int(maze[i][j])
            if maze[i][j] == 2:
                col = j
                row = i

    # 최종 도착 인덱스
    f_row, f_col = BFS(row, col, N)
    ans = 0
    if f_row == -1:
        ans = 0
    else:
        ans = visited[f_row][f_col]

    print(f'#{tc} {ans}')