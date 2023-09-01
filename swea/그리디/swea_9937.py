def baby_gin(p):
    r = tri = 0
    if p[0]==p[1]==p[2]:
        tri += 1
    if p[0]+2 == p[1]+1 == p[2]:
        r += 1
    if r+tri >= 1:
        return 1
    else:
        return 0

def nPk(i, N, K, player):   # N개 중 K개 고르는 순열
    if i == K:
        return baby_gin(p)
    else:
        for j in range(N):
            if used[j] == 0:    # 사용하지 않은 숫자면
                if player == 1:
                    p[i] = p1[j]
                else:
                    p[i] = p2[j]

                used[j] = 1
                if nPk(i+1, N, K, player):
                    return 1
                used[j] = 0
        return 0

T = int(input())
for tc in range(1, T+1):
    cards = list(map(int, input().split()))     # 카드들
    p1 = []
    p2 = []
    used = [0] * (len(cards)//2)  # 사용 여부
    n = 0   # 한 사람당 카드의 갯수
    p = [0]*3   # 3개를 골라 만든 순열
    r1 = 0
    r2 = 0

    for i in range(0, 12, 2):
        p1.append(cards[i])
        p2.append(cards[i+1])

        if i >= 4:
            n = len(p1)
            r1 = nPk(0, n, 3, 1)
            r2 = nPk(0, n, 3, 2)

        if r1 or r2:
            break

    if r1:
        print(f'#{tc} 1')
    else:
        if r2:
            print(f'#{tc} 2')
        else:
            print(f'#{tc} 0')