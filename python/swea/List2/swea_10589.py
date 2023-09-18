T = int(input())
for tc in range(1, T+1):
    N, K = map(int, input().split())    # N : 부분집합 원소의 수, K : 부분 집합의 합

    # 1 ~ 12까지의 집합 생성
    arr = []
    for i in range(1, 13):
        arr.append(i)

    cnt = 0 # 부분 집합의 합이 K인 갯수
    result = 0  # 부분 집합의 합
    arr_cnt = 0 # 부분집합 원소의 수

    # 부분집합 만들기
    for i in range(1<<12):
        arr_cnt = 0
        result = 0

        for j in range(12):
            if i & (1<<j):
                result += arr[j]
                arr_cnt += 1

        # 부분집합을 만들고 부분집합 원소의 갯수가 N개이며 합이 K라면 cnt를 늘린다.
        if arr_cnt == N:
            if result == K:
                cnt += 1

    print(f'#{tc} {cnt}')