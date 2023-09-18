T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())    # N : 정수의 갯수, M : 구간의 갯수
    arr = list(map(int, input().split()))   # 정수 배열

    # 최소값
    min_val = 0
    for i in arr:
        min_val += i

    # 최대값
    max_val = 0

    for i in range(N-M+1):
        result = 0
        for j in range(M):
            result += arr[i+j]

        if result < min_val:
            min_val = result

        if result > max_val:
            max_val = result

    ans = max_val - min_val
    print(f'#{tc} {ans}')