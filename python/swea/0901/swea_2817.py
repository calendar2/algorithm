T = int(input())
for tc in range(1, T+1):
    N, K = map(int, input().split())    # 수열의 갯수, 목표 합
    arr = list(map(int, input().split()))   # 수열

    # 바이너리 카운팅
    result = 0
    cnt = 0
    for i in range(1, (1<<N)):
        for j in range(N):
            if i & (1<<j):
                result += arr[j]
        if result == K:
            cnt += 1
        result = 0

    print(f'#{tc} {cnt}')