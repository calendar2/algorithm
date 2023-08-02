T = int(input())
for tc in range(1, T+1):
    N = int(input())    # 수열의 길이
    numbers = input()   # 수열
    cnt = 0     # 연속한 1의 갯수
    max_cnt = 0     # cnt의 최댓값

    for i in numbers:
        if i == '0':
            cnt = 0
        elif i == '1':
            cnt += 1

            if cnt > max_cnt:
                max_cnt = cnt

    print(f'#{tc} {max_cnt}')