for _ in range(10):
    tc, N = map(int, input().split())   # tc : 테스트 케이스 번호, N : 길의 갯수
    routes = list(map(int, input().split()))  # 출발, 도착지점이 있는 길
    routes_two = []       # 길을 2차원 배열로 변경
    temp = []

    # 길을 2차원 배열로 변경하는 과정
    for i in range(N*2):
        temp.append(routes[i])

        if i%2 == 1:
            routes_two.append(temp)
            temp = []

    start = 0
    end = 99
    visited = [0] * 100     # 방문처리용 배열
    stack = []
    w = 0   # 현재 위치
    searching = True
    goal = 0

    def dfs(start2, end2, w2, searching2, goal2):
        visited[0] = 1
        while searching2:
            for j in range(N):
                if routes_two[j][0] == start2 and visited[routes_two[j][1]-1] == 0:
                    w2 = routes_two[j][1]
                    visited[w2-1] = 1
                    stack.append(start2)

                    if w2 == end2:
                        searching2 = False
                        goal2 = 1
                    else:
                        start2 = w2
                    break
                else:
                    if j == N-1:
                        if stack:
                            start2 = stack.pop()
                        else:
                            searching2 = False

        return goal2

    ans = dfs(start, end, w, searching, goal)
    print(f'#{tc} {ans}')
