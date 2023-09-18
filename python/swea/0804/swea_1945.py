T = int(input())
for tc in range(1, T+1):
    N = int(input())    # 숫자 N

    a, b, c, d, e = 0, 0, 0, 0, 0
    isDivide = True

    while isDivide:
        if N % 2 == 0:
            N = N / 2
            a += 1
        elif N % 3 == 0:
            N = N / 3
            b += 1
        elif N % 5 == 0:
            N = N / 5
            c += 1
        elif N % 7 == 0:
            N = N / 7
            d += 1
        elif N % 11 == 0:
            N = N / 11
            e += 1
        else:
            isDivide = False

    print(f'#{tc}', a, b, c, d, e)