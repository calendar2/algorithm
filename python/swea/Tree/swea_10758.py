def min_heap(p, n):
    global cnt
    v = p
    if p <= n:
        tree[p] = numbers[cnt]
        # 트리에 새로운 값을 입력하고 부모 노드와 비교
        while v > 1 and tree[v//2] > tree[v]:
            tree[v//2], tree[v] = tree[v], tree[v//2]
            v = v // 2
        cnt += 1
        min_heap(p+1, n)
        # min_heap(p*2+1, n)

T = int(input())
for tc in range(1, T+1):
    N = int(input())    # 정점의 갯수
    numbers = list(map(int, input().split()))   # 자연수
    tree = [0] * (N+1)
    cnt = 0
    index = N
    result = 0  # 최종 결과값

    # 최소 힙
    min_heap(1, N)

    # 조상 노드에 정수의 합 구하기
    while index > 1:
        index = index // 2  # 가장 마지막 정점의 부모 노드
        result += tree[index]

    print(f'#{tc} {result}')