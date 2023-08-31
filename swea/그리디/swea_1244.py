def comb(n, r, cnt):
    global result, change

    if r == 0:  # 조합이 하나 완성될 때
        # 해당 인덱스끼리 변경
        num_list[tr[0]], num_list[tr[1]] = num_list[tr[1]], num_list[tr[0]]
        cnt += 1
        if cnt == change:
            chk = ''
            for i in num_list:
                chk += i
            if result < int(chk):
                result = int(chk)
        else:
            comb(n, 2, cnt)
        num_list[tr[0]], num_list[tr[1]] = num_list[tr[1]], num_list[tr[0]]
    elif n < r:
        return
    else:
        tr[r-1] = an[n-1]
        comb(n-1, r-1, cnt)
        comb(n-1, r, cnt)

T = int(input())
for tc in range(1, T+1):
    num, change = map(int, input().split())     # 숫자, 교환횟수
    num_list = list(str(num))   # 주어진 숫자를 리스트화(문자형식)
    tr = [0] * 2    # 조합이 임시 저장될 배열
    length = len(num_list)  # 숫자 갯수
    an = [i for i in range(length)]     # 인덱스 배열

    result = 0
    comb(length, 2, change)

    print(f'#{tc} {result}')