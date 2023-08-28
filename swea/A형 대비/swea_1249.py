def bfs(s_row, s_col, N):
    queue.append((s_row, s_col))
    visited[s_row][s_col] = 1  # 현재 위치 방문처리
    while queue:
        nr, nc = queue.pop(0)
        # 우, 하, 좌, 상
        for dr, dc in [[0, 1], [1, 0], [0, -1], [-1, 0]]:
            row = nr + dr
            col = nc + dc
            if 0 <= row < N and 0 <= col < N:
                # 탐색 경로가 아직 한번도 방문하지 않은 곳이면
                if visited[row][col] == 0:
                    queue.append((row, col))
                    visited[row][col] = 1
                    count[row][col] = arr[row][col] + arr[nr][nc]
                else:   # 한번이라도 방문이 된 곳이라면
                    if arr[row][col]+arr[nr][nc] < count[row][col]:
                        queue.append((row, col))
                        visited[row][col] = 1
                        count[row][col] = arr[row][col] + arr[nr][nc]

T = int(input())
for tc in range(1, T+1):
    N = int(input())    # 지도의 크기
    arr = [list(map(int, input())) for _ in range(N)]   # 지도의 상태

    # 이동 경로별 복구 시간 기록용 배열과 큐 + 방문처리용 배열
    queue = []
    count = [[0]*N for _ in range(N)]
    visited = [[0]*N for _ in range(N)]

    bfs(0, 0, N)

    print(f'#{tc} {count}')