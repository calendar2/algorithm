for tc in range(1, 11):
    dump_cnt = int(input()) # 덤프 횟수
    box_height_list = list(map(int, input().split()))   # 상자의 높이값

    # 상자의 최고, 최저 높이
    max_height = 0
    min_height = 100

    # 상자의 최고, 최저 높이의 인덱스
    max_height_index = 0
    min_height_index = 0

    height_diff = 0     # 최고, 최저의 높이차
    # isDump = False      # 덤프 가능 여부 확인

    # 덤프 횟수만큼 반복하며 평탄화 작업
    for i in range(dump_cnt):
        # 최저, 최고 높이, 인덱스 초기화
        min_height = 100
        max_height = 0
        # min_height_index = 0
        # max_height_index = 0

        # 상자의 최고, 최저 높이와 인덱스 구하기
        for j in range(100):
            if min_height > box_height_list[j]:
                min_height = box_height_list[j]
                min_height_index = j

            if max_height < box_height_list[j]:
                max_height = box_height_list[j]
                max_height_index = j

        # 만약 상자의 최고, 최저 높이 차가 1 이내로 줄어들게 되면 반복 종료
        if max_height - min_height <= 1:
            # height_diff = max_height - min_height
            # isDump = True
            break

        # 덤프 작업하기
        box_height_list[min_height_index] += 1
        box_height_list[max_height_index] -= 1

    # 최종적인 상자의 최고, 최저 높이 구하기
    min_height = 100
    max_height = 0

    for j in range(100):
        if min_height > box_height_list[j]:
            min_height = box_height_list[j]

        if max_height < box_height_list[j]:
            max_height = box_height_list[j]

    # 최고와 최저 높이차 할당
    height_diff = max_height - min_height
    print(f'#{tc} {height_diff}')