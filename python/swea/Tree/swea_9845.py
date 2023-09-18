def postorder(p, n):
    if p <= n:
        if tree[p] == 0:
            l = postorder(p*2, n)
            r = postorder(p*2+1, n)
            # 자식 노드가 한 개일 경우 r = 0
            if r is None:
                r = 0
            tree[p] = l+r
            return tree[p]
        else:
            return tree[p]

T = int(input())
for tc in range(1, T+1):
    N, M, L = map(int, input().split())     # N : 노드의 갯수, M : 리프 노드의 갯수, L : 출력할 노드 번호
    leaf_nodes = [list(map(int, input().split())) for _ in range(M)]    # 0번째는 리프 노드 번호, 1번째는 해당 노드에 저장된 값
    tree = [0] * (N+1)      # 완전이진트리

    # 리프 노드에 저장된 값 트리에 할당
    for leaf in leaf_nodes:
        tree[leaf[0]] = leaf[1]

    # 후위순회
    postorder(1, N)

    print(f'#{tc} {tree[L]}')