for tc in range(1, 11):
    length = int(input())   # 문자열 계산식 길이
    calculate_code = list(map(str, input()))    # 문자열 계산식

    change_list = [''] * length     # 후위 표기식용 리스트
    stack = []
    token = 0       # 후위 표기식용 리스트의 인덱스 접근을 위한 토큰

    # 후위표기식으로 변환
    for i in calculate_code:
        if i in '+-*/()':
            # 스택에 아무것도 없으면 스택에 추가
            if len(stack) == 0:
                stack.append(i)
            else:
                # 만약 + 또는 - 부호일 경우
                if i == '+' or i == '-':
                    # 우선순위가 가장 아래이므로 스택에 모든 요소를 후위 표기식용 리스트로 이동
                    while len(stack):
                        change_list[token] = stack.pop()
                        token += 1
                    stack.append(i)
                elif i == '*' or i == '/':      # 만약 * 또는 / 부호일 경우
                    # + 또는 - 부호보다는 우선순위가 높으므로 그 두 부호일 때만 스택에 쌓는다.
                    while len(stack):
                        if stack[-1] == '+' or stack[-1] == '-':
                            break
                        else:
                            change_list[token] = stack.pop()
                            token += 1
                    stack.append(i)
                elif i == '(':      # 여는 괄호일 경우
                    stack.append(i)
                else:       # 닫는 괄호일 경우
                    # 여는 괄호가 나올 때까지 스택의 요소를 후위 표기식용 리스트로 이동
                    while True:
                        if stack[-1] == '(':
                            stack.pop()
                            break
                        else:
                            change_list[token] = stack.pop()
                            token += 1
        else:
            change_list[token] = i
            token += 1
        
    # 순회가 끝나면 스택의 요소가 다 떨어질 때 까지 후위표기식 리스트로 이동
    while len(stack):
        change_list[token] = stack.pop()
        token += 1

    # 숫자 할당용 변수
    num1 = 0
    num2 = 0
    result = 0

    # 후위표기식 리스트를 순회하면서 계산시작
    for i in change_list:
        if i in '+-*/':
            num2 = int(stack.pop())
            num1 = int(stack.pop())

            # 부호에 맞게 계산
            if i == '+':
                result = num1 + num2
            elif i == '-':
                result = num1 - num2
            elif i == '*':
                result = num1 * num2
            else:
                result = num1 / num2

            stack.append(result)
        else:
            stack.append(i)

    print(f'#{tc} {stack[0]}')