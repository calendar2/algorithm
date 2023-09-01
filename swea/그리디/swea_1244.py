def work(length, cnt):
    global result, max_num
    flag = False
    if cnt == 0:
        chk = ''
        for i in num_list:
            chk += i

        if result < int(chk):
            result = int(chk)

    else:
        for i in range(length):
            for j in range(length):
                if i != j:
                    num_list[i], num_list[j] = num_list[j], num_list[i]
                    chk2 = ''
                    for k in num_list:
                        chk2 += k

                    if chk2 == max_num:
                        if cnt%2:
                            result = int(max_num)
                        else:
                            num_list[-1], num_list[-2] = num_list[-2], num_list[-1]
                            chk2 = ''
                            for l in num_list:
                                chk2 += l
                            result = int(chk2)
                            max_num = chk2
                    else:
                        work(length, cnt-1)
                    if str(result) == max_num:
                        flag = True
                        break
                    num_list[i], num_list[j] = num_list[j], num_list[i]
            if flag:
                break

T = int(input())
for tc in range(1, T+1):
    num, change = map(int, input().split())     # 숫자, 교환횟수
    num_list = list(str(num))   # 주어진 숫자를 리스트화(문자형식)
    num_set = list(set(num_list))
    length = len(num_list)  # 숫자 갯수
    an = [i for i in range(length)]     # 인덱스 배열

    result = 0

    # 숫자로 변경
    num_list_int = [0] * length
    for i in range(length):
        num_list_int[i] = int(num_list[i])
    num_list_int.sort(reverse=True)

    # 최댓값
    max_num = ''
    for i in range(length):
        max_num += str(num_list_int[i])

    if change >= length-1 and length != len(num_set):
        result = int(max_num)
    else:
        work(length, change)

    print(f'#{tc} {result}')