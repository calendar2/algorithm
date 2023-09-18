T = int(input())
for tc in range(1, T+1):
    N = list(input())   # 입력값

    stack1 = []      # 스택1 생성
    stack2 = []     # 스택2 생성

    # 괄호 비교용
    prev = ''
    now = ''

    # 스택1에 괄호만 넣는 스텝
    for i in N:
        if i == '(' or i == ')' or i == '{' or i == '}':
            stack1.append(i)

    # 길이
    stack1_length = len(stack1)
    stack2_length = 0

    flag = True

    while flag:
        if stack2_length == 0:
            prev = stack1.pop()
            stack1_length -= 1

            stack2.append(prev)
            stack2_length += 1
        else:
            prev = stack2.pop()
            stack2.append(prev)

            now = stack1.pop()
            stack1_length -= 1

            # 괄호 비교
            if now == '(' and prev == ')':
                stack2.pop()
                stack2_length -= 1
            elif now == '{' and prev == '}':
                stack2.pop()
                stack2_length -= 1
            else:
                stack2.append(now)
                stack2_length += 1
                prev = now

        if stack1_length == 0:
            flag = False

    ans = 0
    if stack2_length == 0:
        ans = 1

    print(f'#{tc} {ans}')