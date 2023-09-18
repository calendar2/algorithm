T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())    # N : 해상도의 열, M : 해상도의 행
    photo = [list(map(int, input().split())) for _ in range(N)]     # 사진

    length = 0      # 구조물 길이
    length_max = 0  # 구조물 길이의 최댓값

    # 행 순회
    for i in range(N):
        length = 0
        for j in range(M):
            if photo[i][j]:
                length += 1
            else:
                if length_max < length:
                    length_max = length
                length = 0
        if length_max < length:
            length_max = length

    # 열 순회
    for i in range(M):
        length = 0
        for j in range(N):
            if photo[j][i]:
                length += 1
            else:
                if length_max < length:
                    length_max = length
                length = 0
        if length_max < length:
            length_max = length

    print(f'#{tc} {length_max}')