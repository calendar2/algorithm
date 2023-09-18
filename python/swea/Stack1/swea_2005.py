T = int(input())
for tc in range(1, T+1):
    N = int(input())    # 삼각형 크기
    print(f'#{tc}')
    print(1)

    # 스택 생성
    stack1 = [1]
    stack2 = []

    N -= 1

    prev = 0
    now = 0
    new = 0

    while N > 0:
        if not stack2:
            while len(stack1) > 0:
                if not stack2:
                    prev = stack1.pop()
                    stack2.append(prev)
                else:
                    now = stack1.pop()
                    new = prev + now
                    stack2.append(new)
                    prev = now
            stack2.append(1)
            print(*stack2)
        else:
            while len(stack2) > 0:
                if not stack1:
                    prev = stack2.pop()
                    stack1.append(prev)
                else:
                    now = stack2.pop()
                    new = prev + now
                    stack1.append(new)
                    prev = now
            stack1.append(1)
            print(*stack1)
        N -= 1