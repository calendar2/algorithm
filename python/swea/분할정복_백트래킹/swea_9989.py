def backtracking(s, n, val):
    global val_min

    if s == n:
        if val_min > val:
            val_min = val
        return

    for i in range(n):
        if visited[s][i] == 0:  # 방문 전이라면
            price = V[s][i]
            val += price

            if val > val_min:
                continue

            ns = s
            while ns < n:
                visited[ns][i] = 1   # 방문처리
                ns += 1

            backtracking(s+1, n, val)

            while ns > 0:
                ns -= 1
                visited[ns][i] = 0
            val -= price

T = int(input())
for tc in range(1, T+1):
    N = int(input())    # 제품 수
    V = [list(map(int, input().split())) for _ in range(N)]     # 생산비용
    visited = [[0]*N for _ in range(N)]     # 방문처리용 배열

    # 생산비용과 최솟값
    val_min = 100 * N

    backtracking(0, N, 0)
    print(f'#{tc} {val_min}')
    # print(visited)