def bfs(n, m):
    visited[n] = 1  # 시작점 방문처리
    q = [n]

    while q:
        n2 = q.pop(0)

        if n2 == m:
            return visited[n2]

        for i in (n2+1, n2-1, n2*2, n2-10):
            if 0 <= i < 1000001 and visited[i] == 0:
                q.append(i)
                visited[i] = visited[n2] + 1

T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())    # 주어지는 자연수, 만들어야하는 자연수
    visited = [0] * 1000001
    q = []
    cnt = 0

    cnt = bfs(N, M)

    print(f'#{tc} {cnt-1}')