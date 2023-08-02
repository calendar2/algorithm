N = int(input())    # 색종이 수
arr = [list(map(int, input().split())) for _ in range(N)]   # 색종이 위치

total_map = [[0] * 1001 for _ in range(1001)]   # 바닥

# arr를 순회하면서 바닥 배열에 색종이가 놓인 위치의 숫자를 변경해준다.
for i in range(N):
    row_start = arr[i][1]   # 색종이가 놓인 y값 처음 위치
    col_start = arr[i][0]   # 색종이가 놓인 x값 처음 위치
    row_dis = arr[i][3]     # 색종이 가로길이
    col_dis = arr[i][2]     # 색종이 세로길이

    for j in range(row_start, row_start+row_dis):
        total_map[j][col_start : col_start+col_dis] = [i+1] * col_dis
        # for k in range(col_start, col_start+col_dis):
        #     total_map[j][k] = i + 1     # 첫 번째 색종이면 1로, 두 번째 색종이면 2로 변경, 3도 4도 쭉쭉...

area = 0    # 색종이의 면적
for i in range(N):
    area = 0
    for j in range(1001):
        # for k in range(1001):
        #     if total_map[j][k] == (i + 1):
        #         area += 1
        area += total_map[j].count(i+1)

    print(area)