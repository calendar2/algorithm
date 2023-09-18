T = int(input())
for tc in range(1, T+1):
    N = int(input())    # 색칠하는 영역의 갯수
    arr = [list(map(int, input().split())) for _ in range(N)]

    color_map = [[0] * 10 for _ in range(10)]   # 전체 색종이

    # arr의 [i][0], [i][1]을 각각 r1, c1으로 시작하고 [i][2], [i][3]을 r2, c2로 마무리하는 영역을 [i][4]의 값으로 더해준다.
    # 위 작업은 color_map에서 진행한다. 그럼 보라색인 지역은 3으로 표시가 된다.
    for i in range(N):
        r1 = arr[i][0]  # 색칠이 시작되는 row값
        c1 = arr[i][1]  # 색칠이 시작되는 col값
        r2 = arr[i][2]  # 색칠이 끝나는 row값
        c2 = arr[i][3]  # 색칠이 끝나는 col값
        color = arr[i][4]   # 색깔

        # r1,c1을 시작점으로 설정하고, r2+1,c2+1을 끝 지점으로 설정해서 순회
        for j in range(r1, r2+1):
            for k in range(c1, c2+1):
                color_map[j][k] += color

    # 색칠이 완료되면 color_map을 순회하며 숫자가 3인 영역의 갯수만 찾는다.
    cnt = 0 # 보라색으로 색칠된 영역의 갯수
    for i in range(10):
        for j in range(10):
            if color_map[i][j] == 3:
                cnt += 1

    print(f'#{tc} {cnt}')