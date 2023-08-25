T = int(input())
for tc in range(1, T+1):
    N = int(input())    # 격자판의 크기
    arr = [list(input()) for _ in range(N)]     # 격자판
    length = [0] * N

    fail = False
    handsome_rectangle = False

    # 우, 하
    dr = [0, 1]
    dc = [1, 0]

    # 한 줄에 닫힌 칸이 몇 개인지
    for i in range(N):
        for j in range(N):
            if arr[i][j] == '#':
                length[i] += 1

    # 0을 제외한 배열을 만들어주고
    new_length = []
    for i in length:
        if i:
            new_length.append(i)

    # 새 배열이 하나라도 존재하면
    if len(new_length):
        if new_length[0] == 1:
            handsome_rectangle = True
        if len(new_length) != new_length[0]:
            fail = True

    # 만약 길이가 전부 동일하다면
    for i in range(1, len(new_length)):
        if new_length[i-1] != new_length[i]:
            fail = True
            break

    # 일단 길이가 전부 같다면 연속하는지 추가로 확인
    cnt = new_length[0]
    if fail is False and handsome_rectangle is False:
        for i in range(N):
            for j in range(N):
                if arr[i][j] == '#':
                    for k in range(cnt):
                        nr = i + dr[1] * k
                        if 0 <= nr < N:
                            for l in range(cnt):
                                nc = j + dc[0] * l
                                if 0 <= nc < N:
                                    if arr[nr][nc] != '#':
                                        fail = True
                                        break   # for l
                                if k == cnt-1 and l == cnt-1 and fail == False:
                                    handsome_rectangle = True
                        if fail or handsome_rectangle:
                            break   # for k
                if fail or handsome_rectangle:
                    break   # for j
            if fail or handsome_rectangle:
                break   # for i

    if handsome_rectangle:
        print(f'#{tc} yes')
    else:
        print(f'#{tc} no')