def f(i, j):        # A[i:j+1]에서 최댓값을 리턴하는 함수
    if i==j:            # 남은 원소가 하나면
        return i
    else:
        m = (i+j)//2
        r1 = f(i, m)        # 왼쪽 영역의 최댓값
        r2 = f(m+1, j)      # 오른쪽 영역의 최댓값
        return f(r1, r2)

T = int(input())
for tc in range(1, T+1):
    N = int(input())    # 인원수
    cards = list(map(int, input().split()))     # 고른 카드들

    # win =

    # print(f'#{tc} {win}')