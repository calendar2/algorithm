T = int(input())    # 테스트 케이스 갯수
for tc in range(1, T+1):
    N = int(input())    # 정수의 갯수
    arr = list(map(int, input().split()))   # 정수의 배열

    # 최소, 최대값의 인덱스
    min_index = 0
    max_index = 0

    # 최소, 최대값
    min_val = arr[0]
    max_val = arr[0]

    for i in range(N):
        if arr[i] < min_val:
            min_index = i
            min_val = arr[i]

        if arr[i] >= max_val:
            max_index = i
            max_val = arr[i]

    ans = max_index - min_index

    if ans < 0:
        ans *= -1

    # print(max_index, min_index, max_val, min_val)
    # print(arr)
    print(f'#{tc} {ans}')