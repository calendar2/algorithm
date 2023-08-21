# 전위순회 한번 해보자
def preorder_traverse(t):
    if t:
        visited[t] = 1
        # 간선 순회하면서 다음 자식 노드로 탐색
        for c_tree in tree_order_two:
            if c_tree[0] == t and visited[c_tree[1]] == 0:
                preorder_traverse(c_tree[1])

T = int(input())
for tc in range(1, T+1):
    E, N = map(int, input().split())    # E : 간선 갯수, N : 서브트리 갯수 찾아야 하는 노드
    tree_order = list(map(int, input().split()))    # 트리 구조
    visited = [0] * (E + 2)  # 방문처리용 배열(1번 노드가 배열 인덱스 1번에 해당)
    tree_order_two = []     # 2차원 배열로 변환

    # 2차원 배열로 변환
    for i in range(0, E*2, 2):
        tree_order_two.append([tree_order[i], tree_order[i+1]])

    # 트리 탐색
    preorder_traverse(N)
    cnt = 0     # 서브 노드 갯수
    for i in visited:
        if i:
            cnt += 1

    print(f'#{tc} {cnt}')