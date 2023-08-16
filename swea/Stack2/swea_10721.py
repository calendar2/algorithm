def f(i, N):
    global min_v
    if i == N:
        # print(p)
        s = 0
        for k in range(N):  # k행
            s += arr[k][p[k]]
        # print(s)
        if min_v > s:
            min_v = s
    else:
        for j in range(i, N):  # p[i]와 자리를 바꿀 위치
            p[i], p[j] = p[j], p[i]  # p[i] 결정
            f(i + 1, N)
            p[i], p[j] = p[j], p[i]  # 다음 j위치와 자리를 바꾸기전 원상복구


T = int(input())
for tc in range(1, T + 1):
    N = int(input())
    arr = [list(map(int, input().split())) for _ in range(N)]

    p = [i for i in range(N)]  # p[i] i행에서 고른 열번호
    min_v = 100  # 문제의 조건에서 10미만, 최대 10개의 정수

    f(0, N)  # p[0]부터 p[N-1]까지 각 행에서 열을 선택하는 함수
    print(f'#{tc} {min_v}')