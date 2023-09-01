
T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())    # N X M 크기
    map_info = [list(input()) for _ in range(N)]    # 지도 정보

    # 물의 갯수
    water_cnt = 0
    for i in range(N):
        for j in range(M):
            if map_info[i][j] == 'W':
                water_cnt += 1

    water = [[0, 0] for _ in range(water_cnt)]  # 물이 있는 곳의 좌표
    water_cnt = 0
    flag = False
    # 물이 있는 곳의 좌표를 먼저 담기
    for i in range(N):
        for j in range(M):
            if map_info[i][j] == 'W':
                water[water_cnt][0] = i
                water[water_cnt][1] = j
                water_cnt += 1
                if water_cnt == len(water):
                    flag = True
                    break
        if flag:
            break

    # 땅에서 물까지 가는 경로의 최솟값을 카운트
    cnt = N+M
    result = 0
    for i in range(N):
        for j in range(M):
            if map_info[i][j] == 'L':
                cnt = N+M
                for k in water:
                    if cnt > abs(i-k[0]) + abs(j-k[1]):
                        cnt = abs(i-k[0]) + abs(j-k[1])
                        if cnt == 1:
                            break
                result += cnt

    print(f'#{tc} {result}')