def bfs(s_row, s_col):
    queue = []
    queue.append((s_row, s_col))    # 큐에 삽입
    while queue:
        s_row, s_col = queue.pop(0)
        # 하우상좌
        for dr, dc in [[1, 0], [0, 1], [-1, 0], [0, -1]]:
            nr = s_row + dr
            nc = s_col + dc
            if 0 <= nr < 16 and 0 <= nc <16:
                if maze[nr][nc] == '0':
                    queue.append((nr, nc))
                    maze[nr][nc] = '1'
                elif maze[nr][nc] == '3':
                    return 1
    return 0

for tc in range(10):
    T = int(input())    # 테스트 케이스 번호
    maze = [list(input()) for _ in range(16)]   # 미로

    row = ''
    col = ''
    flag = False

    # 시작 위치 찾기
    for i in range(16):
        for j in range(16):
            if maze[i][j] == '2':
                row = i
                col = j
                flag = True
                break
        if flag:
            break

    ans = bfs(row, col)
    print(f'#{T} {ans}')