'''
bfs 개념 + dp 개념으로 물이 있는 지역부터 가장 가까운 곳의 육지를 +1로 표시하고
그 후 bfs 탐색으로 가까운 지역들을 이전 지역에 +1씩 해주며 최단 거리를 구해낸다.
'''
def bfs(N, M):
    q = [(0, 0)] * (N*M)    # 큐를 정의
    front = -1
    rear = -1
    v = [[-1] * M for _ in range(N)]    # 거리 축적용 배열

    # 물 지역을 큐에 삽입하며 v의 위치를 0으로 시작
    for i in range(N):
        for j in range(M):
            if map_info[i][j] == 'W':
                rear += 1
                q[rear] = (i, j)
                v[i][j] = 0

    # 큐를 하나씩 빼면서 v에 거리를 기록
    while front != rear:
        front += 1
        i, j = q[front]
        for di, dj in [(0, 1), (1, 0), (0, -1), (-1, 0)]:
            ni = i + di
            nj = j + dj
            if 0 <= ni < N and 0 <= nj < M and map_info[ni][nj] == 'L' and v[ni][nj] == -1:
                rear += 1
                q[rear] = (ni, nj)
                v[ni][nj] = v[i][j] + 1

    # v에 기록을 완료했으므로 누적 합 구하기
    s = 0
    for i in range(N):
        for j in range(M):
            s += v[i][j]

    return s

T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())    # N X M 크기
    map_info = [list(input()) for _ in range(N)]    # 지도 정보

    print(f'#{tc} {bfs(N, M)}')