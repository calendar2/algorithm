T = int(input())
for tc in range(1, T+1):
    V, E = map(int, input().split())    # V : 노드 갯수, E : 간선 갯수
    routes = [list(map(int, input().split())) for _ in range(E)]    # 출발, 도착 노드 정보
    S, G = map(int, input().split())    # S : 시작점, G : 도착점

    visited = [0] * V       # 방문기록용 배열
    stack = []      # 스택...
    w = 0       # 현재 위치
    # idx = -1    # routes를 탐색할 인덱스
    goal = 0     # 도착지에 도달이 가능하면 1로, 불가능하면 0으로
    isFinish = False      # 탐색을 끝내야하면 true로

    # dfs 메서드
    def dfs(start, end, goal2, isFinish2, w2):
        visited[start-1] = 1    # 시작점 방문 기록
        while True:
            # 지금 있는 출발점에서 어떤 도착점으로 갈 수 있는지 탐색
            for i in range(E):
                if routes[i][0] == start and visited[routes[i][1]-1] == 0:
                    w2 = routes[i][1]    # 출발점에서 갈 수 있는 도착점을 w에 할당
                    visited[w2-1] = 1
                    stack.append(start)     # 스택에 방문지 입력

                    if w2 == end:
                        isFinish2 = True
                        goal2 = 1
                    else:
                        start = w2
                    break
                else:       # 지금 있는 출발점에서 갈 수 있는 도착점이 없거나 갈 수 있는 도착점이 이미 방문했을 경우
                    if i == E-1:
                        if stack:       # 스택 기록이 아직 남아있으면
                            start = stack.pop()     # 가장 마지막 방문 위치로 회귀
                        else:
                            isFinish2 = True

            if isFinish2:      # 탐색을 종료해야하니까 while 탈출
                break
        return goal2

    ans = dfs(S, G, goal, isFinish, w)
    print(f'#{tc} {ans}')