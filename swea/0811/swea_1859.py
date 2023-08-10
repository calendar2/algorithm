T = int(input())
for tc in range(1, T+1):
    N = int(input())    # 총 날짜
    prices = list(map(int, input().split()))    # 매매가

    product_status = [0] * N    # 상품 상태(1이면 내가 산거, 2면 내가 판거)
    sell_price = 0      # 총 판매가

    max_price_idx = 0       # 최고가 인덱스
    shop = True     # true면 장사 진행 중

    while shop:
        # 최고가 구하기
        for i in range(N):
            if prices[max_price_idx] < prices[i]:
                max_price_idx = i

        if max_price_idx == N-1:
            for i in range(N):
                if i == N-1:
                    sell_price +=