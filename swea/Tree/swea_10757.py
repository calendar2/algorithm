def inorder(p, N):
    global cnt
    if p <= N:
        inorder(p*2, N)
        tree[p] = cnt
        cnt += 1
        inorder(p*2+1, N)

T = int(input())
for tc in range(1, T+1):
    N = int(input())    # 노드의 갯수
    tree = [0] * (N+1)  # 완전이진트리
    cnt = 1

    # 중위순회
    inorder(1, N)

    print(f'#{tc} {tree[1]} {tree[N//2]}')