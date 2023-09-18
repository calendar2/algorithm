T = int(input())
for tc in range(1, T+1):
    N = int(input())    # 신청서 갯수
    work_time = [list(map(int, input().split())) for _ in range(N)]     # 작업 시간

    # 작업 시간을 종료시간 순으로 정렬
    work_time.sort(key=lambda x : x[1])

    # 가능한 작업시간의 배열
    possible_time = [work_time[0]]      # 일단 첫번째 시간을 넣어준다.
    idx = 0

    # 두 번째 작업시간부터 종료시간과 시작시간을 비교하며 작업이 가능할 경우 배열에 삽입
    for i in range(1, N):
        if work_time[i][0] >= possible_time[idx][1]:
            possible_time.append(work_time[i])
            idx += 1

    print(f'#{tc} {len(possible_time)}')