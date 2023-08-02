T = int(input())
for tc in range(1, T+1):
    N = int(input())    # 양수의 갯수
    num_list = list(map(int, input().split()))  # 양수

    # 최소, 최대값
    max_val = num_list[0]
    min_val = num_list[0]

    for i in num_list:
        if min_val > i:
            min_val = i

        if max_val < i:
            max_val = i

    ans = max_val - min_val
    print(f'#{tc} {ans}')