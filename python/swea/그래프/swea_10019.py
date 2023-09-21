import heapq


def dijkstra(start):
    # 2. 우선순위 큐
    pq = []

    # 출발점 초기화
    heapq.heappush(pq, (0, start))
    distance[start] = 0

    while pq:
        # 현재 시점에서 누적 거리가 가장 짧은 노드에 대한 정보 꺼내기
        dist, now = heapq.heappop(pq)

        if distance[now] < dist:
            continue

        for next in graph[now]:
            next_node = next[0]
            cost = next[1]
            new_cost = dist + cost

            if distance[next_node] <= new_cost:
                continue

            distance[next_node] = new_cost
            heapq.heappush(pq, (new_cost, next_node))

T = int(input())
for tc in range(1, T+1):
    N, E = map(int, input().split())    # 마지막 번호, 도로의 갯수

    # 인접리스트
    graph = [[] for _ in range(N+1)]
    for _ in range(E):
        f, t, w = map(int, input().split())
        graph[f].append([t, w])

    # 1. 누적 거리를 계속 저장
    INF = int(1e9)
    distance = [INF] * (N+1)

    dijkstra(0)
    print(f'#{tc} {distance[N]}')