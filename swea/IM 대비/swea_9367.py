T = int(input())
for tc in range(1, T+1):
    N = int(input())    # 당근 갯수
    c_list = list(map(int, input().split()))    # 수확한 당근들

    ans = 0
    cnt = 0

    for i in range(1, N):
        if c_list[i] > c_list[i-1]:
            cnt += 1
            if i == N-1:
                ans = cnt
        else:
            if ans < cnt:
                ans = cnt
            cnt = 0

    print(f'#{tc} {ans+1}')