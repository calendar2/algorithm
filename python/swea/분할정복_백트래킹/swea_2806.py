def promising(i, j):
    for k in range(i):
        if arr[k][j]:   # 같은 열에 퀸이 있으면
            return 0
    ni, nj = i-1, j+1   # 오른쪽 대각선 확인
    while 0<=ni<N and 0<=nj<N:
        if arr[ni][nj]:
            return 0
        ni -= 1
        nj += 1
    ni, nj = i-1, j-1   # 왼쪽 위 대각선 확인
    while 0<=ni<N and 0<=nj<N:
        if arr[ni][nj]:
            return 0
        ni -= 1
        nj -= 1
    return 1

def f(i, N):
    global cnt
    if i==N:    # N개의 퀸을 모두 놓으면
        cnt += 1
    else:
        # i행 j열에 퀸을 놓을 수 있으면
        for j in range(N):
            if promising(i, j):
                arr[i][j] = 1
                f(i+1, N)
                arr[i][j] = 0

T = int(input())
for tc in range(1, T+1):
    N = int(input())
    arr = [[0]*N for _ in range(N)]
    cnt = 0
    f(0, N)     # 0번 행부터 총 N개의 퀸 놓기

    print(f'#{tc} {cnt}')