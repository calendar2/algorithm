T = int(input())
for tc in range(1, T+1):
    N = int(input())    # 원의 반지름

    cnt = 0     # 격자점의 갯수

    # x, y가 N까지 순회하며 조건을 만족하는지 확인
    for i in range(N+1):
        for j in range(N+1):
            if (i*i) + (j*j) <= N*N:
                cnt += 1

    # 음수까지 고려해서 cnt * 2 - 1을 진행(원점은 하나이므로 -1을 꼭 해준다)
    cnt = cnt * 4

    # 각 축은 한번씩 더 중첩됐으므로 (N+1)*4를 빼주고 원점을 한번 다시 더해준다.
    cnt = cnt - 4*(N+1) + 1
    print(f'#{tc} {cnt}')