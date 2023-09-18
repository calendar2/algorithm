'''
9
7 4 2 0 0 6 0 7 0
'''
T = int(input())    # 테스트 케이스 갯수

for tc in range(1, T+1):
    N = int(input())    # 방의 가로 길이
    arr = list(map(int, input().split()))   # 쌓여있는 상자의 수

    # height_max_index = -1   # 가장 높은 상자의 인덱스
    height_max = arr[0]    # 가장 높은 상자의 높이
    # cnt_max = -1     # 가장 높은 상자의 높이와 똑같은 높이의 갯수
    fall_dis = 0    # 낙하 거리

    for i in range(N):
        if arr[i] < height_max:
            fall_dis += 1

    print(f'#{tc} {fall_dis}')