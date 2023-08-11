T = int(input())
for tc in range(1, T+1):
    position = list(input())    # 쇠막대기와 레이저 배치

    cnt = 0     # 절단되는 쇠막대기 갯수
    left = 0    # 쇠막대기 갯수
    length = len(position)      # 주어진 배치의 길이

    for i in range(length):
        if position[i] == '(':
            left += 1
        else:
            left -= 1
            if position[i-1] == '(':
                cnt += left
            else:
                cnt += 1

    print(f'#{tc} {cnt}')