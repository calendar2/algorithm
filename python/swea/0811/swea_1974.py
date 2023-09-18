T = int(input())
for tc in range(1, T+1):
    puzzle = [list(map(int, input().split())) for _ in range(9)]    # 주어지는 퍼즐
    sdoku = 1   # 스도쿠 여부
    area = [0] * 9      # 가로, 세로, 3x3 영역의 값을 할당하기 위한 리스트
    area_set = {}       # area가 중복되는 값을 가지는지 확인

    # 행 순회
    for i in range(9):
        for j in range(9):
            area[j] = puzzle[i][j]

        area_set = set(area)
        if len(area_set) != 9:
            sdoku = 0
            break

    # 열 순회
    if sdoku:
        for i in range(9):
            for j in range(9):
                area[j] = puzzle[j][i]

            area_set = set(area)
            if len(area_set) != 9:
                sdoku = 0
                break

    # 3x3 순회
    if sdoku:
        row = 0
        col = 0
        cnt = 0
        for _ in range(9):
            cnt = 0
            for i in range(row, row+3):
                for j in range(col, col+3):
                    area[cnt] = puzzle[i][j]
                    cnt += 1

            col += 3
            if col == 9:
                row += 3
                col = 0
            area_set = set(area)
            if len(area_set) != 9:
                sdoku = 0
                break

    print(f'#{tc} {sdoku}')