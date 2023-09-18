T = int(input())
for tc in range(1, T+1):
    num2 = list(input())    # 이진수
    num3 = list(input())    # 삼진수
    num2_cand = [0] * len(num2)     # 이진수로부터 추측할 수 있는 숫자 후보들
    num = 0

    # 이진수의 값을 하나씩 변경해주며 후보 탐색
    for i in range(len(num2)):
        if int(num2[i]):
            num2[i] = '0'
        else:
            num2[i] = '1'

        m = 1
        num = 0
        for j in range(len(num2)-1, -1, -1):
            num += int(num2[j]) * m
            m = m * 2

        num2_cand[i] = num
        if int(num2[i]):
            num2[i] = '0'
        else:
            num2[i] = '1'

    fin = False
    result = 0
    val3 = ''   # num3의 원래 값
    # 삼진수의 값을 하나씩 변경하며 추측값이 존재하는지 확인
    for i in range(len(num3)):
        val3 = num3[i]
        for j in range(3):
            if val3 != j:
                num3[i] = str(j)

                m = 1
                num = 0
                for k in range(len(num3)-1, -1, -1):
                    num += int(num3[k]) * m
                    m = m * 3

                if num in num2_cand:
                    fin = True
                    result = num
                    break   # for k
            if fin:
                break   # for j
        num3[i] = val3
        if fin:
            break   # for i

    print(f'#{tc} {result}')