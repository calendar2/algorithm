def perm(i, k):
    global battery_min
    if i == k:
        battery = 0
        for j in range(k):
            if j == 0:  # 첫 시작은 사무실에서 관리구역으로
                battery = arr[0][area[j]] + arr[area[j]][area[j+1]]
            elif j == k-1:
                battery += arr[area[j]][0]
            else:
                battery += arr[area[j]][area[j+1]]
        if battery_min > battery:
            battery_min = battery
    else:
        for j in range(i, k):
            area[i], area[j] = area[j], area[i]
            perm(i+1, k)
            area[i], area[j] = area[j], area[i]

T = int(input())
for tc in range(1, T+1):
    N = int(input())
    arr = [list(map(int, input().split())) for _ in range(N)]
    area = [i for i in range(1, N)]

    battery_min = 0
    for i in range(N):
        for j in range(N):
            battery_min += arr[i][j]

    perm(0, N-1)
    print(f'#{tc} {battery_min}')