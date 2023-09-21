INF = int(1e9)
T = int(input())
for tc in range(1, T+1):
    N = int(input())
    H = [list(map(int, input().split())) for _ in range(N)]

    # dijkstra, 출발점 0, 0
    U = [[0]*N for _ in range(N)]
    U[0][0] = 1

    D = [[INF]*N for _ in range(N)]
    D[0][0] = 0
    D[0][1] = 1 + max(H[0][1]-H[0][0], 0)   # 인접
    D[1][0] = 1 + max(H[1][0]-H[0][0], 0)   # 인접

    cnt = N*N - 1
    while cnt > 0:
        # D[w]가 최소인 정점 V-U의 원소 w를 선택
        min_i = min_j = 0
        min_v = INF
        for i in range(N):
            for j in range(N):
                if U[i][j]==0 and min_v > D[i][j]:
                    min_v = D[i][j]
                    min_i, min_j = i, j
        U[min_i][min_j] = 1                 # U[w] = 1
        for di, dj in [[0,1],[1,0],[0,-1],[-1,0]]:
            ni, nj = min_i+di, min_j+dj
            if 0<=ni<N and 0<=nj<N:
                D[ni][nj] = min(D[ni][nj], D[min_i][min_j] + 1 + max(H[ni][nj]-H[min_i][min_j], 0))

        cnt -= 1
    print(f'#{tc} {D[N-1][N-1]}')