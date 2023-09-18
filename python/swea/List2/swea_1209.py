for tc in range(1, 11):
    T = int(input())    # 테스트 케이스 번호
    arr = [list(map(int, input().split())) for _ in range(100)]

    max_val = 0 # 최댓값
    sum_col = 0    # 행 한줄의 합
    sum_row = 0 # 열 한줄의 합
    sum_right_down = 0  # 오른쪽 아래 대각선 합
    sum_left_down = 0   # 왼쪽 아래 대각선 합

    # 행,열 순회 최댓값
    for i in range(100):
        sum_col = 0
        sum_row = 0
        for j in range(100):
            sum_col += arr[i][j]
            sum_row += arr[j][i]

        if max_val < sum_col:
            max_val = sum_col

        if max_val < sum_row:
            max_val = sum_row

    # 대각선 순회 최댓값
    for i in range(10):
        sum_right_down += arr[i][i]
        sum_left_down += arr[9-i][i]

    if max_val < sum_right_down:
        max_val = sum_right_down

    if max_val < sum_left_down:
        max_val = sum_left_down

    print(f'#{T} {max_val}')