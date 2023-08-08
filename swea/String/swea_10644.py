T = int(input())
for tc in range(1, T+1):
    str1 = input()
    str2 = input()

    cnt = 0     # str1에 포함된 글자가 str2에 몇 개 있는지
    max_cnt = 0     # cnt 중 최댓값

    for i in str1:
        cnt = 0
        for j in str2:
            if i == j:
                cnt += 1
        if max_cnt < cnt:
            max_cnt = cnt

    print(f'#{tc} {max_cnt}')