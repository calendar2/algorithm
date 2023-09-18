T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())    # 도시의 크기, 하나의 집이 지불할 수 있는 비용
    city = [list(map(int, input().split())) for _ in range(N)]      # 도시 정보

    # 운영비용, 이익, 서비스 받는 집 수, 보안 회사가 손해보지 않을 때 서비스를 가장 많이 받는 집의 수
    K = 0
    earning = 0
    cnt = 0
    house_cnt = 0

    # 서비스 영역을 1부터 도시에 꽉 차도록 늘리며 비교
    for i in range(N*2):
        # 서비스 크기에 따라 운영비용 업데이트
        K = (i+1)*(i+1) + i*i

        # 도시를 순회
        for j in range(N):
            for k in range(N):
                # 서비스 중심지를 변경했으므로 cnt 초기화
                cnt = 0
                for l in range(N):
                    for m in range(N):
                        if city[l][m] == 1:     # 탐색 위치가 집이면
                            if abs(j-l) + abs(k-m) <= i:    # 탐색 위치와 현재 중심점이 서비스 거리 내에 있는지 확인
                                cnt += 1

                # 서비스 받는 집을 탐색했으니 비용 계산
                earning = M*cnt - K
                if earning >= 0:
                    if house_cnt < cnt:
                        house_cnt = cnt

    print(f'#{tc} {house_cnt}')