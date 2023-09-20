def f(i, N, c, e):  # i번 정류장 도착, N종점번호, c 이전의 교환횟수, e남은 배터리용량
    global min_v
    if i==N:        # 종점에 도착한 경우
        if min_v > c:
            min_v = c
    elif min_v <= c:
        return
    else:
        f(i+1, N, c+1, bat[i]-1)    # 교체
        if e > 0:
            f(i+1, N, c, e-1)   # 통과

T = int(input())
for tc in range(1, T+1):
    bat = list(map(int, input().split()))
    min_v = bat[0]  # 100
    f(2, bat[0], 0, bat[1]-1)   # 1번정류장은 무조건 교체, 출발점은 교환횟수 제외
    print(f'#{tc} {min_v}')