def calculate(num1, num2, cal):
    if cal == '+':
        return num1 + num2
    elif cal == '-':
        return num1 - num2
    elif cal == '*':
        return num1 * num2
    else:
        return num1 / num2

def postorder(p, n):
    if p <= n:
        l = postorder(p*2, n)

        # 자식 노드가 없는 최하단 노드일 경우
        if l is None:
            return tree[p]

        r = postorder(p*2+1, n)
        cal = tree[p]
        # 계산결과 구하기
        tree[p] = calculate(int(l), int(r), cal)
        return tree[p]

for tc in range(1, 11):
    N = int(input())    # 정점의 갯수
    tree = [0] * (N+1)  # 완전이진트리

    # 입력값 받아서 tree에 저장하기
    for i in range(N):
        arr = list(map(str, input().split()))
        tree[int(arr[0])] = arr[1]

    result = postorder(1, N)    # 최종 계산값

    print(f'#{tc} {int(result)}')