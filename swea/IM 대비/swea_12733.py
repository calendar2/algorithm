T = int(input())
for tc in range(1, T+1):
    n = int(input())    # 지도의 크기
    arr = [list(input()) for _ in range(n)]     # 현재 기지국 정보

    # 상, 우, 하, 좌
    dr = [-1, 0, 1, 0]
    dc = [0, 1, 0, -1]

    # 기지국 커버 배수
    step = 0

    # 지도를 순회하며 기지국의 커버 여부 확인
    for i in range(n):
        for j in range(n):
            if arr[i][j] == 'A':    # A 기지국이 있을 경우
                step = 1
            elif arr[i][j] == 'B':  # B 기지국일 경우
                step = 2
            elif arr[i][j] == 'C':  # C 기지국일 경우
                step = 3
            else:                   # 기지국이 아닐 경우
                step = 0

            # 기지국 커버 범위만큼 상, 우, 하, 좌 탐색
            for k in range(1, step+1):
                for l in range(4):
                    row = i + dr[l] * k
                    col = j + dc[l] * k

                    if 0 <= row < n and 0 <= col < n:
                        if arr[row][col] == 'H':    # 탐색 위치에 집이 있을 경우
                            arr[row][col] = 'O'

    # 기지국의 커버 범위 탐색이 끝났으면 커버되지 않는 집의 수를 구한다.
    cnt = 0
    for i in range(n):
        for j in range(n):
            if arr[i][j] == 'H':
                cnt += 1

    print(f'#{tc} {cnt}')