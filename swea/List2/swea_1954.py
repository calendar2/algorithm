T = int(input())
for tc in range(1, T+1):
    N = int(input())    # 달팽이 크기

    arr = [[0] * N for _ in range(N)]   # 빈 배열 생성
    # 우, 하, 좌, 상
    dr = [0, 1, 0, -1]
    dc = [1, 0, -1, 0]

    # 현재 row, col
    nr = 0
    nc = 0

    direc = 0 # 현재 방향(상,하,좌,우 중 어딘지)

    # 달팽이 탐색
    for i in range(N*N):
        arr[nr][nc] = i+1

        # 현재 위치를 저장
        row = nr
        col = nc

        # direc : 0일 때 우, 1 -> 하, 2 -> 좌, 3 -> 상
        for j in range(direc, 4):
            nr = row + dr[j]
            nc = col + dc[j]

            if 0 <= nc < N and 0 <= nr < N and arr[nr][nc] == 0:
                direc = j
                break
            # elif nc >= N:
            #     nc -= 1
            # elif nr >= N:
            #     nr -= 1
            # elif nc < 0:
            #     nc += 1
            # elif nr < 0:
            #     nr += 1
            else:
                if direc == 3:
                    # nr += 1
                    direc = 0
                    nr = row + dr[direc]
                    nc = col + dc[direc]
                # elif direc == 0:
                #     # nc -= 1
                #     direc = 1
                # elif direc == 1:
                #     # nr -= 1
                #     direc = 2
                # else:
                #     # nc += 1
                #     direc = 3

    print(f'#{tc}')
    for i in range(N):
        print(*arr[i])