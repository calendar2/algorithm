T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())    # N : 파리 리스트 크기, M : 스프레이 세기
    fly_list = [list(map(int, input().split())) for _ in range(N)]  # 파리 리스트

    # 잡은 파리 수, 최댓값
    kill_cnt = 0
    kill_cnt_max = 0

    # 상,우,하,좌 / 우상, 우하, 좌하, 좌상
    dr = [-1, 0, 1, 0, -1, 1, 1, -1]
    dc = [0, 1, 0, -1, 1, 1, -1, -1]

    # 파리 리스트를 순회하며 파리 퇴치
    for i in range(N):
        for j in range(N):
            kill_cnt = fly_list[i][j]   # 현재 위치의 파리 갯수

            # 스프레이 세기만큼 추가로 파리 퇴치
            for l in range(1, M):
                for k in range(4):
                    nr = i + dr[k] * l
                    nc = j + dc[k] * l

                    # 영역 내라면 퇴치한 파리 갯수에 추가
                    if 0 <= nr < N and 0 <= nc < N:
                        kill_cnt += fly_list[nr][nc]

            # 최댓값과 비교
            if kill_cnt_max < kill_cnt:
                kill_cnt_max = kill_cnt

            # 대각선 방향도 똑같은 알고리즘 적용
            kill_cnt = fly_list[i][j]
            for l in range(1, M):
                for k in range(4, 8):
                    nr = i + dr[k] * l
                    nc = j + dc[k] * l
                    if 0 <= nr < N and 0 <= nc < N:
                        kill_cnt += fly_list[nr][nc]
            if kill_cnt_max < kill_cnt:
                kill_cnt_max = kill_cnt

    print(f'#{tc} {kill_cnt_max}')