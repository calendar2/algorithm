T = int(input())
for tc in range(1, T+1):
    # K : 한번 충전으로 이동할 수 있는 정류장 수
    # N : 정류장 갯수, M : 충전기가 설치된 정류장 수
    K, N, M = map(int, input().split())
    arr = list(map(int, input().split()))   # 충전기가 설치된 정류장의 번호

    bus_arr = [0] * (N+1)   # 정류장 배열
    bus = 0    # 현재 버스의 위치
    oil_cnt = 0     # 충전 횟수
    isOil = False   # 주유했는지 여부
    bus_init = 0    # 버스의 시작점
    goal_fail = True # 목표지점 도달 실패

    while goal_fail:
        for i in range(K, 0, -1):
            bus += i    # 버스가 K만큼 간다.

            # bus가 마지막 정류장을 뛰어넘었을 경우 무한루프를 종료한다.
            if bus >= N:
                goal_fail = False
                break

            # arr를 순회하며 bus의 위치와 똑같은 정류장이 있으면 bus_arr의 값을 1로 변경해준다.
            for j in arr:
                if j == bus:
                    bus_arr[bus] = 1
                    oil_cnt += 1
                    isOil = True
                    break

            # 주유를 했으면 맨 위 for문도 탈출한다.
            if isOil:
                isOil = False
                break
            else:
                # 주유를 실패했을 경우 버스에 위치를 -i로 변경해준다.
                bus -= i

        # 버스의 시작점과 버스의 현재 위치가 같거나 bus의 시작점이 0이라면 목표 도달을 실패로 변경한다.
        if bus_init == bus:
            goal_fail = False
            oil_cnt = 0

        bus_init = bus

    print(f'#{tc} {oil_cnt}')