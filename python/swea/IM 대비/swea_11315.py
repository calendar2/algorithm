T = int(input())
for tc in range(1, T+1):
    N = int(input())    # 판의 크기
    arr = [list(input()) for _ in range(N)]     # 오목 상태

    # 우, 우하, 하, 좌하
    dr = [0, 1, 1, 1]
    dc = [1, 1, 0, -1]

    omok = False
    cnt = 0

    # 바둑판을 순회하면서 오목 여부 확인
    for i in range(N):
        for j in range(N):
            # 해당 인덱스값에 돌이 놓여있으면
            if arr[i][j] == 'o':
                # 우, 우하, 하, 좌하 위치에 돌이 놓여있는지 확인
                for k in range(4):
                    cnt = 0
                    for l in range(1, 5):
                        nr = i + dr[k] * l
                        nc = j + dc[k] * l
                        if 0 <= nr < N and 0 <= nc < N:
                            if arr[nr][nc] == 'o':
                                cnt += 1

                        if l == 4:
                            if cnt == 4:
                                omok = True
                    if omok:
                        break   # for k
            if omok:
                break   # for j
        if omok:
            break   # for i

    if omok:
        print(f'#{tc} YES')
    else:
        print(f'#{tc} NO')