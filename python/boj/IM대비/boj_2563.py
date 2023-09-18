import sys

N = int(sys.stdin.readline())   # 색종이 갯수
positions = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]    # 색종이 위치
ground = []
for i in range(101):
    ground.append([0]*101)

# 색종이 넓이
area = 0

# 요소별로 비교
for position in positions:
    for i in range(position[0], position[0]+10):
        for j in range(position[1], position[1]+10):
            ground[i][j] = 1

for i in range(101):
    for j in range(101):
        if ground[i][j] == 1:
            area += 1

print(area)
# print(ground)