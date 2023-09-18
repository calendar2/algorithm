def perm(i, k):
    global a, b, cor
    if i == k:  # 순열이 하나 만들어질 때
        for j in range(3):
            A[j] = num[j]
            B[j] = num[j+3]

        for j in range(2):
            if A[j] == A[j+1]:
                if j == 0:
                    a = 2
                else:
                    if a == 2:
                        a = 3
                    else:
                        a = 0
            elif int(A[j])+1 == int(A[j+1]):
                if j == 0:
                    a = 1
                else:
                    if a == 1:
                        a = 3
                    else:
                        a = 0
            else:
                a = 0

            if B[j] == B[j + 1]:
                if j == 0:
                    b = 2
                else:
                    if b == 2:
                        b = 3
                    else:
                        b = 0
            elif int(B[j]) + 1 == int(B[j + 1]):
                if j == 0:
                    b = 1
                else:
                    if b == 1:
                        b = 3
                    else:
                        b = 0
            else:
                b = 0
        # for문이 끝나고
        if a == 3 and b == 3:
            cor += 1

    else:
        for j in range(i, k):
            num[i], num[j] = num[j], num[i]
            perm(i+1, k)
            num[i], num[j] = num[j], num[i]

T = int(input())
for tc in range(1, T+1):
    num = list(input())       # 6자리 수
    A = ['']*3
    B = ['']*3

    # 베이비진일 경우 1로 변경
    a = 0
    b = 0

    cor = 0
    perm(0, 6)

    if cor:
        print(f'#{tc} Baby Gin')
    else:
        print(f'#{tc} Lose')