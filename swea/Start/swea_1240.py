T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())    # 배열의 세로, 가로 크기
    arr = [list(map(int, input())) for _ in range(N)]   # 주어진 배열

    # 암호 시작점의 row, col
    row = 0
    col = 0
    search = False
    code = [[0] * 7 for _ in range(8)]
    code_trans_num = [0] * 8     # 암호 숫자로 변환

    # 암호 딕셔너리
    code_dict = {'3211': 0, '2221': 1, '2122': 2, '1411': 3, '1132': 4,
                 '1231': 5, '1114': 6, '1312': 7, '1213': 8, '3112': 9}

    # 암호의 끝은 항상 1로 끝나므로 오른쪽부터 확인
    for i in range(N):
        for j in range(M-1, -1, -1):
            if arr[i][j]:
                row = i
                col = j - 55
                search = True
                break
        if search:
            break

    # 암호 추출
    for i in range(8):
        for j in range(7):
            code[i][j] = arr[row][col]
            col += 1

    cnt = 0
    code_sol = ''
    for i in range(8):
        code_sol = ''
        for j in range(7):
            if j == 0:
                cnt += 1
            elif code[i][j] == code[i][j-1]:
                cnt += 1
            else:
                code_sol += str(cnt)
                cnt = 1

        code_trans_num[i] = code_dict[code_sol]

    # 올바른 코드인지 확인
    code_chk = 0
    for i in range(8):
        if i % 2:
            code_chk += code_trans_num[i]
        else:
            code_chk += code_trans_num[i] * 3
    
    right_code = False
    if code_chk % 10 == 0:
        right_code = True

    ans = 0
    if right_code:
        for i in range(8):
            ans += code_trans_num[i]

    print(f'#{tc} {ans}')