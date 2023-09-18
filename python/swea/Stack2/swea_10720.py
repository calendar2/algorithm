def rcp(g1, g2):    # 가위바위보 함수
    if cards[g1] == 1 and cards[g2] == 3:
        return g1
    elif cards[g1] == 3 and cards[g2] == 1:
        return g2
    elif cards[g1] >= cards[g2]:
        return g1
    else:
        return g2

def dac(i, j):        # 분할 정복 알고리즘
    if i == j:            # 남은 원소가 하나면 그 값을 리턴
        return i
    else:
        m = (i + j) // 2
        r1 = dac(i, m)        # 왼쪽 분할
        r2 = dac(m+1, j)      # 오른쪽 분할
        return rcp(r1, r2)

T = int(input())
for tc in range(1, T+1):
    N = int(input())    # 인원수
    cards = list(map(int, input().split()))     # 고른 카드들

    win = dac(0, N-1)

    print(f'#{tc} {win+1}')