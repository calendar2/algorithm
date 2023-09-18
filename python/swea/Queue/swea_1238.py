def bfs(start):
    queue = []
    queue.append(start)     # 큐 삽입
    visited[start] = 1      # 연락 당번은 1로 시작
    cnt = 0
    while queue:
        v = queue.pop(0)
        for data in data_two:
            if v == data[0] and visited[data[1]] == 0:  # from이 현재 번호와 일치하고 to가 아직 연락 받기 전이라면
                queue.append(data[1])
                visited[data[1]] = visited[v] + 1   # 연락받은 순서를 1 늘려서 할당해준다.
                cnt = visited[data[1]]

    return cnt

for tc in range(1, 11):
    N, s_num = map(int, input().split())    # N : 데이터의 길이, s_num : 시작 번호
    datas = list(map(int, input().split())) # 비상연락망 정보
    visited = [0] * 101  # 연락받은 순서 기록

    # 비상연락망을 2차원 배열로 from, to 형식으로 나누기
    data_two = []
    for i in range(0, N, 2):
        data_two.append([datas[i], datas[i+1]])

    last_call = bfs(s_num)
    last_call_max = 0

    # 연락을 가장 마지막에 받은 사람들을 비교하며 최댓값 찾기
    for i in range(101):
        if visited[i] == last_call:
            if last_call_max < i:
                last_call_max = i

    print(f'#{tc} {last_call_max}')