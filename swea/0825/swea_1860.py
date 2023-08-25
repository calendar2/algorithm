T = int(input())
for tc in range(1, T+1):
    N, M, K = map(int, input().split())     # N : 손님 수, M : K개의 붕어빵을 만드는 시간, K : 붕어빵 갯수
    client_time = list(map(int, input().split()))   # 손님이 도착하는 시간(리스트)

    # 시간 정렬
    client_time.sort()
    last_client = client_time[-1]   # 가장 마지막에 도착하는 시간

    time = 0    # 현재 시간
    fish_bread = 0  # 만든 붕어빵 갯수
    make_fish_bread = M     # 붕어빵 만들어지는 시간
    fail = False

    # 가장 마지막 시간까지 시간을 증가시키며 붕어빵 만들기
    while time < last_client:
        time += 1   # 1초 지남

        if time == make_fish_bread:     # 붕어빵 구워지는 시간이 되면
            fish_bread += K     # K개의 붕어빵 만듬
            make_fish_bread += M    # 다음 붕어빵이 만들어지는 시간

        # 손님이 오면 붕어빵을 줄인다.
        for i in client_time:
            if time == i:
                fish_bread -= 1
                break

        # 만약 붕어빵 갯수가 음수가 되면 impossible
        if fish_bread < 0:
            fail = True
            break

    if client_time[0] == 0:
        fail = True

    if fail:
        print(f'#{tc} Impossible')
    else:
        print(f'#{tc} Possible')