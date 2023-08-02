for tc in range(1, 11):
    N = int(input())    # 건물의 갯수
    height = list(map(int, input().split()))    # 건물의 높이
    building = 0    # 조망권이 확보된 세대의 수

    for i in range(2, N-1):
        height_diff = 0 # 건물의 높이 차
        min_diff = 255  # 건물 간 가장 낮은 차이

        if height[i] > height[i-1] and height[i] > height[i-2] and height[i] > height[i+1] and height[i] > height[i+2]:
            for j in range(i-2, i+3):
                if i == j:
                    continue

                height_diff = height[i] - height[j]
                if height_diff < min_diff:
                    min_diff = height_diff

            building += min_diff

    print(f'#{tc} {building}')