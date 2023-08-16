T = int(input())
for tc in range(1, T+1):
    calculate_code = list(map(str, input().split()))    # 연산 코드

    stack = []      # 숫자를 담을 스택
    num = 0         # 숫자 할당용 변수
    num1 = 0     # 숫자 할당용 변수
    num2 = 0        # 숫자 할당용 변수2
    result = ''      # 결과값
    err = False     # 정상적인 계산인지 확인

    # 연산 코드를 순회하며 계산 시작
    for i in calculate_code:
        if i == '+':
            if len(stack) >= 2:
                num2 = stack.pop()
                num1 = stack.pop()

                num = num1 + num2
                stack.append(num)
            else:
                err = True
                break

        elif i == '-':
            if len(stack) >= 2:
                num2 = stack.pop()
                num1 = stack.pop()

                num = num1 - num2
                stack.append(num)
            else:
                err = True
                break

        elif i == '*':
            if len(stack) >= 2:
                num2 = stack.pop()
                num1 = stack.pop()

                num = num1 * num2
                stack.append(num)
            else:
                err = True
                break

        elif i == '/':
            if len(stack) >= 2:
                num2 = stack.pop()
                num1 = stack.pop()

                num = num1 // num2
                stack.append(num)
            else:
                err = True
                break

        elif i == '.':
            if len(stack) >= 2:
                err = True
            else:
                num = stack.pop()
                result = str(num)

        else:
            num = int(i)
            stack.append(num)

    if err:
        result = 'error'

    print(f'#{tc} {result}')