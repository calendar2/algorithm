T = int(input())
for tc in range(1, T+1):
    N = int(input())    # 총 날짜
    prices = list(map(int, input().split()))    # 매매가

    sell_price = 0      # 총 판매가
    max_price = prices[N-1]       # 최고가

    for i in range(N-1, -1, -1):    # 배열의 뒤쪽부터 순회하며
        if max_price < prices[i]:   # 최고가보다 해당 인덱스의 가격이 높다면
            max_price = prices[i]   # 최고가 갱신

        sell_price += max_price - prices[i]  # 최고가 - 해당 가격으로 판매가를 더해준다.

    print(f'#{tc} {sell_price}')