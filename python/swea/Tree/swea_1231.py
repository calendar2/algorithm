def inorder(p, N):      # N 완전이진트리의 마지막 정점
    if p <= N:
        inorder(p*2, N)            # 왼쪽 자식트리
        print(tree[p], end='')  # 중위순회에서 하는 일
        inorder(p*2+1, N)          # 오른쪽 자식트리

for tc in range(1, 11):
    N = int(input())    # 정점의 총수
    tree = [0] * (N+1)  # N번 노드까지 있는 완전이진트리
    for _ in range(N):
        arr = list(input().split())
        tree[int(arr[0])] = arr[1]
    # 중위순회
    print(f'#{tc} ', end='')
    inorder(1, N)      # root = 1
    print()