def binary_search(v, l, r):
    global l_cnt
    global r_cnt

    l_cnt = 0
    r_cnt = 0

    while True:
        mid = (l+r)//2
        if A[mid] == v:
            return 1
        elif A[mid] < v:
            l_cnt = 0
            r_cnt += 1
            if r_cnt > 1:
                return 0
            l = mid+1
        else:
            r_cnt = 0
            l_cnt += 1
            if l_cnt > 1:
                return 0
            r = mid-1

T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())    # 리스트 A, B의 정수의 갯수
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))

    # 가능한 갯수, 왼쪽 탐색 횟수,오른쪽 탐색 횟수
    cnt = 0
    l_cnt = 0
    r_cnt = 0

    A.sort()
    for b in B:
        cnt += binary_search(b, 0, N-1)

    print(f'#{tc} {cnt}')