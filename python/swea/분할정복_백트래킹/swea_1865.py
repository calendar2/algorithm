def backtracking(s, n, work):
    global work_max

    if work < work_max:   # 확률이 더 작아지면
        return

    if s == n:  # 다 탐색했을 때
        if work_max < work:
            work_max = work
        return

    for i in range(n):
        if visited[i] == 0:  # 방문 전이라면
            visited[i] = 1  # 방문처리
            backtracking(s+1, n, work * (P[s][i] / 100))
            visited[i] = 0

T = int(input())
for tc in range(1, T+1):
    N = int(input())
    P = [list(map(int, input().split())) for _ in range(N)]     # 일을 성공할 확률
    visited = [0] * N     # 방문처리용 배열

    # 확률로 바꾸기
    # for i in range(N):
    #     for j in range(N):
    #         P[i][j] /= 100

    work_max = 0
    backtracking(0, N, 1)

    # 소수점 6자리 출력
    work_max *= 100
    print(f'#{tc} {work_max:.6f}')