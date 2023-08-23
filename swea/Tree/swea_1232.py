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
        if len(tree[p]) > 2:    # 해당 노드가 자식 노드를 갖고 있으면
            l = postorder(int(tree[p][2]), n)
            r = postorder(int(tree[p][3]), n)
            cal = tree[p][1]
            # 계산결과 구하기
            tree[p][1] = calculate(int(l), int(r), cal)
            return tree[p][1]
        else:   # 자식 노드가 없으면
            return tree[p][1]

for tc in range(1, 11):
    N = int(input())    # 정점의 갯수
    tree = [[0]]   # 이진트리

    # 입력값 받아서 tree에 저장하기
    for i in range(N):
        arr = list(map(str, input().split()))
        tree.append(arr)

    result = postorder(1, N)    # 최종 계산값

    print(f'#{tc} {int(result)}')