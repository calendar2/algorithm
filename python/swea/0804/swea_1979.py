T = int(input())
for tc in range(1, T+1):
    N, K = map(int, input().split())    # N : 배열의 크기, K : 단어의 길이
    arr = [list(map(int, input().split())) for _ in range(N)]   # 퍼즐

    cnt = 0     # K 길이의 단어가 들어갈 수 있는 자리의 수

    # 배열을 행, 열 순회하며 1이 연속된 길이가 K와 같다면 cnt 증가
    for i in range(N):
        length = 0      # 1이 연속된 길이
        row_length = 0
        for j in range(N):
            # 가로 길이 체크
            if arr[i][j]:
                length += 1
            else:
                length = 0

            # 세로 길이 체크
            if arr[j][i]:
                row_length += 1
            else:
                row_length = 0

            # 가로 길이가 K일 때
            if length == K:
                cnt += 1
            elif length == K + 1:
                cnt -= 1

            # 세로 길이가 K일 때
            if row_length == K:
                cnt += 1
            elif row_length == K + 1:
                cnt -= 1

    print(f'#{tc} {cnt}')