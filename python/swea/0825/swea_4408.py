T = int(input())
for tc in range(1, T+1):
    N = int(input())    # 돌아가야할 학생들의 수
    arr = [list(map(int, input().split())) for _ in range(N)]   # 현재 방과 돌아가야할 방 번호

    hotel = [[0] * 200 for _ in range(3)]   # 수련회의 방 구조

    # 시작위치, 도착위치
    s_row = -1
    s_col = -1
    e_row = -1
    e_col = -1

    # arr를 순회하며 이동하는 복도의 값을 카운팅한다.
    for i in arr:
        if i[0] % 2:    # 현재 방이 홀수일 경우
            s_row = 0
            s_col = i[0] // 2
        else:
            s_row = 2
            s_col = i[0]//2 - 1

        if i[1] % 2:
            e_row = 0
            e_col = i[1] // 2
        else:
            e_row = 2
            e_col = i[1]//2 - 1

        # 현재 위치
        nr = s_row
        nc = s_col

        # 도착점까지 도착할 때 까지 계속 이동
        while True:
            if nr == 1:  # 복도일 경우
                if nc < e_col:      # 도착점이 오른쪽에 있을 경우
                    nc += 1
                elif nc > e_col:    # 도착점이 왼쪽에 있을 경우
                    nc -= 1
                else:   # 도착지점일 경우
                    break
            else:   # 위쪽 또는 아래쪽 방일 경우
                nr = 1
            hotel[nr][nc] += 1

    print(f'#{tc} {max(hotel[1])}')