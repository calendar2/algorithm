def find_set(x):
    if parents[x] == x:
        return x

    parents[x] = find_set(parents[x])
    return parents[x]

def union(x, y):
    x = find_set(x)
    y = find_set(y)

    if x == y:
        return

    if x < y:
        parents[y] = x
    else:
        parents[x] = y

T = int(input())
for tc in range(1, T+1):
    V, E = map(int, input().split())
    edge = []
    for _ in range(E):
        n1, n2, w = map(int, input().split())
        edge.append([n1, n2, w])

    # w를 기준으로 정렬
    edge.sort(key=lambda x : x[2])

    # 사이클 발생 여부를 union find로 해결
    parents = [i for i in range(V+1)]

    # 현재 방문한 정점 수
    cnt = 0
    sum_weight = 0
    for n1, n2, w in edge:
        # 사이클이 발생하지 않는다면
        if find_set(n1) != find_set(n2):
            cnt += 1
            sum_weight += w
            union(n1, n2)
            # MST 구성이 끝나면
            if cnt == V:
                break
    print(f'#{tc} {sum_weight}')