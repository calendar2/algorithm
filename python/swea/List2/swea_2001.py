T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())    # N : 지도의 크기, M : 파리채 크기
    arr = [list(map(int, input().split())) for _ in range(N)]   # 파리의 갯수

    fly_cnt = 0     # 잡은 파리 갯수
    max_fly = 0     # 잡은 파리의 최대 갯수

    # 지도의 크기에서 파리채 크기만큼 뺀 영역까지만 순회한다.
    for i in range(N-M+1):
        for j in range(N-M+1):
            fly_cnt = 0
            # 파리채 크기로 순회하며 잡은 파리 갯수를 센다.
            for k in range(i, i+M):
                for l in range(j, j+M):
                    fly_cnt += arr[k][l]

            if max_fly < fly_cnt:
                max_fly = fly_cnt

    print(f'#{tc} {max_fly}')
    # print(arr)