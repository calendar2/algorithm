T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())    # 컨테이너 수, 트럭 수
    w = list(map(int, input().split()))     # N개 화물의 무게
    t = list(map(int, input().split()))     # M개 트럭의 적재 용량

    # 무게와 적재 용량 모두 내림차순으로 정렬
    w.sort(reverse=True)
    t.sort(reverse=True)

    # 적재처리용 배열
    visited = [0] * M

    total_w = 0     # 총 적재량

    # 화물을 트럭에 적재할 수 있는지 하나씩 확인
    for i in range(N):
        for j in range(M):
            if visited[j] == 0:     # 아직 적재하지 않았다면
                if t[j] >= w[i]:     # 적재 용량이 투입된 화물보다 더 크거나 같을 경우
                    total_w += w[i]
                    visited[j] = 1
                    break

    print(f'#{tc} {total_w}')