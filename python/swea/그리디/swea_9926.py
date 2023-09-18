def f(i, j, s, N):  # i,j 현재 방문한 칸, s 이전에 지나온 칸의 숫자 합계
    global result_min
    if i >= N or j >= N:    # 영역을 벗어난 경우
        return
    elif i == N-1 and j == N-1:     # 맨 오른쪽 아래 도착
        # s + arr[i][j]가 최솟값인지 확인
        if result_min > s+arr[i][j]:
            result_min = s + arr[i][j]
    else:
        f(i, j+1, s+arr[i][j], N)   # 오른쪽으로 이동
        f(i+1, j, s+arr[i][j], N)   # 아래로 이동

T = int(input())
for tc in range(1, T+1):
    N = int(input())    # 가로, 세로 칸수
    arr = [list(map(int, input().split())) for _ in range(N)]   # 자연수들

    result_min = 0
    for i in range(N):
        for j in range(N):
            result_min += arr[i][j]

    f(0, 0, 0, N)
    print(f'#{tc} {result_min}')