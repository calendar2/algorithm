T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())    # 배열의 세로, 가로 크기
    arr = []     # 주어진 배열
    for i in range(N):
        msg = input()
        if msg != '0'*M:
            if len(arr) != 0:
                for j in range(len(arr)):
                    if arr[j] == msg:
                        break
                    if j == len(arr)-1:
                        arr.append(msg)
            else:
                arr.append(msg)

    # 암호 담을 배열들
    code_16_0 = []      # 16진수, 앞에 0이 남아있는 암호
    temp = []           # arr 요소를 리스트로 만들어서 담아줄 배열
    col = 0

    for i in arr:
        temp.append(list(i))

    # 우측에 있는 0을 제거한다.
    for i in temp:
        for j in range(len(i)-1, -1, -1):
            if i[j] != '0':
                col = j
                break
        code_16_0.append(i[0:j+1])

    # 16진수 -> 2진수 변환
    trans_dict1 = {'0': '0000', '1': '0001', '2': '0010', '3': '0011',
                   '4': '0100', '5': '0101', '6': '0110', '7': '0111',
                   '8': '1000', '9': '1001', 'A': '1010', 'B': '1011',
                   'C': '1100', 'D': '1101', 'E': '1110', 'F': '1111'}

    # 2진수 코드 -> 숫자 코드로 변환(역순으로 배치)
    trans_dict2 = {'1123': '0', '1222': '1', '2212': '2',
                   '1141': '3', '2311': '4', '1321': '5',
                   '4111': '6', '2131': '7', '3121': '8', '2113': '9'}

    code_2 = []     # 2진수로 변환한 암호
    temp_str = ''
    # 2진수로 암호를 변환하자!
    for i in code_16_0:
        for j in i:
            temp_str += trans_dict1[j]
        code_2.append(temp_str)
        temp_str = ''

    code = []
    cnt = 0
    code_trans = ''
    code_trans_int = 0
    check = True
    code_num = ''
    for i in code_2:
        for j in range(len(i)-1, -1, -1):
            if j == len(i)-1 and i[j] == '1':
                cnt += 1
            else:
                if code_trans == '':
                    if i[j] == '1':
                        cnt += 1
                    else:
                        if i[j] != i[j+1]:
                            code_trans += str(cnt)
                            cnt = 1
                else:
                    if i[j] == i[j+1]:
                        cnt += 1
                    else:
                        code_trans += str(cnt)
                        cnt = 1

            if len(code_trans) == 4:
                code_trans_int = int(code_trans)
                while check:
                    for k in range(4):
                        if code_trans[k] == '1':
                            check = False
                            break
                    if check:
                        code_trans_int = code_trans_int // 2
                        code_trans = str(code_trans_int)
                code_num += trans_dict2[code_trans]

            # code_num이 8자리인지


    print(code_2)
    print(code_2[0][len(code_2[0])-1] == '1')