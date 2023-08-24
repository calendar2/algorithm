T = int(input())
for tc in range(1, T+1):
    N = int(input())    # 격자의 크기
    stage = [list(map(int, input().split())) for _ in range(N)]     # 스테이지 점수 분포

    # 상, 하, 좌, 우
    dr = [-1, 1, 0, 0]
    dc = [0, 0, -1, 1]

    # 최대, 최솟값
    point_max = 0
    point_min = stage[0][0]

    for i in range(1, N):
        for j in range(4):
            nr = dr[j] * i
            nc = dc[j] * i

            if 0 <= nr < N and 0 <= nc < N:
                point_min += stage[nr][nc]

    # 최대, 최소 구하기
    point = 0
    for i in range(N):
        for j in range(N):
            point = stage[i][j]

            for k in range(1, N):
                for l in range(4):
                    nr = i + dr[l] * k
                    nc = j + dc[l] * k

                    if 0 <= nr < N and 0 <= nc < N:
                        point += stage[nr][nc]

            if point_max < point:
                point_max = point

            if point_min > point:
                point_min = point

    ans = point_max - point_min
    print(f'#{tc} {ans}')