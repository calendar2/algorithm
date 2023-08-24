T = int(input())
for tc in range(1, T+1):
    N = float(input())  # 주어진 숫자
    bin_num = ''    # 이진수 표현용
    fail = False

    for i in range(13):
        if i == 12:
            fail = True
            break
        N *= 2
        namugi = int(N) % 10
        bin_num += str(namugi)
        N = N - namugi

        if N == 0:
            break

    if fail:
        bin_num = 'overflow'

    print(f'#{tc} {bin_num}')