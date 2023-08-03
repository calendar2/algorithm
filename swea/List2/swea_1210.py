for tc in range(1, 11):
    T = int(input())
    arr = [list(map(int, input().split())) for _ in range(100)] # 사다리

    start = 100
    # 도착지점의 x좌표 구하기
    end = 0
    for i in range(100):
        if arr[99][i] == 2:
            end = i

    # 상, 좌, 우
    dr = [-1, 0, 0]
    dc = [0, -1, 1]

    # 출발점 찾기
    def find_ladder(row, col):
        # 왼쪽 먼저
        if col-1 >= 0 and arr[row][col-1] == 1:
            nr = row + dr[1]
            nc = col + dc[1]
        # 그 다음 오른쪽
        elif col+1 < 100 and arr[row][col+1] == 1:
            nr = row + dr[2]
            nc = col + dc[2]
        # 둘 다 못 가면 위로
        elif arr[row-1][col] == 1:
            nr = row + dr[0]
            nc = col + dc[0]
        # 세 방향 다 못 가면
        else:
            return

        # nr이 0이면 출발지 도착
        if nr == 0:
            return nc
        else:
            arr[row][col] = 0
            return find_ladder(nr, nc)

    start = find_ladder(99, end)

    print(f'#{tc} {start}')