T = int(input())
for tc in range(1, T+1):
    # N : 상자의 갯수, Q : 반복 횟수
    N, Q = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(Q)]   # L, R 배열

    # 상자 배열
    box_arr = [0] * N

    # Q회 작업을 하며 L번째부터 R번째 상자의 숫자를 변경
    for i in range(1, Q+1):
        L = arr[i-1][0]
        R = arr[i-1][1]

        for j in range(L, R+1):
            box_arr[j-1] = i

    print(f'#{tc}', *box_arr)