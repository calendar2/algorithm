T = int(input())
for tc in range(1, T+1):
    N = int(input())    # 정수의 갯수
    arr = list(map(int, input().split()))   # N개의 정수

    for i in range(N-1):
        # 홀수번째일 때
        if i % 2 == 0:
            max_idx = i
            for j in range(i+1, N):
                if arr[max_idx] < arr[j]:
                    max_idx = j
            arr[i], arr[max_idx] = arr[max_idx], arr[i]

        else:
            min_idx = i
            for j in range(i+1, N):
                if arr[min_idx] > arr[j]:
                    min_idx = j
            arr[i], arr[min_idx] = arr[min_idx], arr[i]

    print(f'#{tc}', end=' ')
    for i in range(10):
        print(arr[i], end=' ')
    print()