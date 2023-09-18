def bfs(start, end, n):
    visited = [0] * (n+1)   # 방문처리용 배열(노드가 1번부터 시작하니까 쉽게 생각하려고 크기+1로 지음
    queue = []
    queue.append(start)
    visited[start] = 1      # 시작지점 방문처리
    while queue:
        v = queue.pop(0)
        for i in kansun:
            if v == i[0] and visited[i[1]] == 0:   # 시작점이 일치하면서 해당 노드 방문이 아직 안됐으면
                if i[1] == end:
                    return visited[v]
                queue.append(i[1])
                visited[i[1]] = visited[v] + 1      # 이전 노드 카운트 + 1

            if v == i[1] and visited[i[0]] == 0:    # 간선 방향성이 없으므로 뒤집어서 한번 더
                if i[0] == end:
                    return visited[v]
                queue.append(i[0])
                visited[i[0]] = visited[v] + 1
    return 0

T = int(input())
for tc in range(1, T+1):
    V, E = map(int, input().split())    # V : 노드 갯수, E : 간선 갯수
    kansun = [list(map(int, input().split())) for _ in range(E)]    # 간선
    S, G = map(int, input().split())    # S : 시작 지점, G : 도착 지점

    success = 0
    success = bfs(S, G, V)
    print(f'#{tc} {success}')