import sys

N = int(sys.stdin.readline())   # 색종이 갯수
positions = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]    # 색종이 위치

print(positions)