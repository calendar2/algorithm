T = int(input())
for tc in range(1, T+1):
    N = int(input())    # 카드의 갯수
    numbers = input()   # 숫자

    count_arr = [0] * 10    # 각 숫자의 갯수 배열

    for i in numbers:
        index = int(i)  # 각 숫자를 카운트 배열의 인덱스로
        count_arr[index] += 1

    many_num = 0    # 가장 많은 숫자
    many_cnt = 0    # 가장 많은 숫자의 갯수

    # 0 ~ 9까지 순회하며 가장 많은 숫자와 그 숫자의 갯수를 찾는다
    for i in range(10):
        if many_cnt <= count_arr[i]:
            many_cnt = count_arr[i]
            many_num = i

    print(f'#{tc} {many_num} {many_cnt}')