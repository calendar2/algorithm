T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())    # N : 풍선판 row, M : 풍선판 col
    arr = [list(map(int, input().split())) for _ in range(N)]   # 꽃가루 갯수

    max_flower = 0  # 꽃가루 최대 갯수
    # 상, 하, 좌, 우
    dr = [-1, 1, 0, 0]
    dc = [0, 0, -1, 1]

    sum_flower = 0  # 터진 꽃가루의 합

    # arr를 순회하며 터진 꽃가루의 합을 구하고 최댓값과 비교한다.
    for i in range(N):
        for j in range(M):
            sum_flower = 0
            sum_flower += arr[i][j]
            for k in range(4):
                nr = i + dr[k]
                nc = j + dc[k]
                if nr >= 0 and nc >= 0:
                    #     continue
                    # sum_flower += arr[nr][nc]
                    try:
                        sum_flower += arr[nr][nc]
                    except:
                        continue

            if max_flower < sum_flower:
                max_flower = sum_flower

    print(f'#{tc} {max_flower}')