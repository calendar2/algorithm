def erase(i, j, ratio, N):
    end = i
    while end < N and bcode[i][j-1] == 1:
        end += 1
    for r in range(i, end):
        for c in range(j-56*ratio, j):
            bcode[r][c] = 0

# 16진수 -> 2진수 변환
h2b = {'0': '0000', '1': '0001', '2': '0010', '3': '0011',
       '4': '0100', '5': '0101', '6': '0110', '7': '0111',
       '8': '1000', '9': '1001', 'A': '1010', 'B': '1011',
       'C': '1100', 'D': '1101', 'E': '1110', 'F': '1111'}

# 3자리까지만 알아도 코드 변환이 가능하다.
pat = {211: 0, 221: 1, 122: 2,
       411: 3, 132: 4, 231: 5,
       114: 6, 312: 7, 213: 8, 112: 9}

T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())    # 배열의 세로, 가로 크기
    hcode = [input() for _ in range(N)]     # 주어진 배열
    bcode = [[0]*M*4 for _ in range(N)]     # 16진수 코드를 2진수로 저장할 배열

    # 16진수 코드를 2진수로 변환해서 담는 과정
    for i in range(N):
        for j in range(M):
            for k in range(4):
                bcode[i][j*4+k] = int(h2b[hcode[i][j]][k])

    M *= 4      # M을 4배로 늘리고
    ans = 0     # 나중에 정답으로 쓸 변수

    # 각 열을 돌면서 코드가 나타나면 암호코드 찾기
    for i in range(N):
        j = 0
        pwd = [0] * 8   # 암호코드 저장할 배열
        k = 0

        while j < M:
            # 앞에서부터 순회하며 0이 나올 땐 일단 건너뛰기
            while j < M and bcode[i][j] == 0:
                j += 1

            # 0을 건너뛰었는데 암호코드가 없으면 다음줄로 이동
            if j == M:
                break

            # if문을 넘어왔으면 1의 갯수 세기
            cnt100 = 0
            while j < M and bcode[i][j] == 1:
                cnt100 += 1
                j += 1

            # 그다음 0과 1의 갯수도 차례로 세기
            cnt10 = 0
            while j < M and bcode[i][j] == 0:
                cnt10 += 1
                j += 1
            cnt1 = 0
            while j < M and bcode[i][j] == 1:
                cnt1 += 1
                j += 1

            ratio = min(cnt1, cnt10, cnt100)    # 암호의 배율 찾기
            cnt1 //= ratio
            cnt10 //= ratio
            cnt100 //= ratio

            # 암호코드 찾아서 배열에 삽입
            pwd[k] = pat[cnt100*100 + cnt10*10 + cnt1]
            k += 1

            # 8자리가 되면 올바른 암호코드 판별
            if k == 8:
                cs = ((pwd[0]+pwd[2]+pwd[4]+pwd[6])*3 + pwd[1]+pwd[3]+pwd[5]+pwd[7]) % 10
                if cs == 0:     # 정상일때만
                    ans += sum(pwd)
                erase(i, j, ratio, N)
                k = 0
    print(f'#{tc} {ans}')