import sys

garo, sero = map(int, sys.stdin.readline().split())      # 종이의 가로, 세로 길이
N = int(sys.stdin.readline())   # 자르는 갯수
cut_list = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]     # 자르는 방향과 위치 2차원 배열로

# 자르는 위치의 배열
row_list = []
col_list = []

for i in cut_list:
    if i[0]:
        col_list.append(i[1])
    else:
        row_list.append(i[1])

# 각각 가장 마지막 점을 리스트에 추가
row_list.append(sero)
col_list.append(garo)

# 각각의 자르는 위치 정렬
row_list.sort()
col_list.sort()

# 길이로 변환하여 할당
for i in range(len(row_list)-1, 0, -1):
    length = row_list[i] - row_list[i-1]
    row_list[i] = length

for i in range(len(col_list)-1, 0, -1):
    length = col_list[i] - col_list[i-1]
    col_list[i] = length

# 넓이를 구하면서 최댓값 구하기
area = 0
area_max = 0

for i in col_list:
    for j in row_list:
        area = i * j

        if area_max < area:
            area_max = area

print(area_max)