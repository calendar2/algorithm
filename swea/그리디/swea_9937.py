def nPk(i, N, K):   # N개 중 K개 고르는 순열
    if i == K:

    else:
        for j in range(N):
            if used[j] == 0:    # 사용하지 않은 숫자면
                p[i] =

T = int(input())
for tc in range(1, T+1):
    cards = list(map(int, input().split()))     # 카드들
    p1 = []
    p2 = []
    n = 0   # 한 사람당 카드의 갯수
    p = [0]*3   # 3개를 골라 만든 순열

    for i in range(0, 12, 2):
        p1.append(cards[i])
        p2.append(cards[i+1])

        if i >= 4:
            n = len(p1)
            used = [0]*n    # 사용 여부
            r = nPk(0, n, 3)

    print(p1)
    print(p2)