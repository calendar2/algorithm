T = int(input())
for tc in range(1, T+1):
    N, sixteen_order = input().split()      # 16진수 크기와 16진수
    sixteen_list = list(sixteen_order)      # 리스트화
    trans_dict = {'A': 10, 'B': 11, 'C': 12, 'D': 13, 'E': 14, 'F': 15}
    two_order = ''      # 2진수
    temp = []       # 계산용 리스트

    # 리스트 크기만큼 순회
    for i in range(int(N)):
        num = sixteen_list[i]
        if num in trans_dict:
            num = trans_dict[num]
        else:
            num = int(num)

        # 2진수로 만들어서 리스트에 담기(역순이니 주의!)
        for j in range(4):
            namugi = num % 2
            num = num // 2
            temp.append(namugi)

        for j in range(4):
            two_order += str(temp.pop())

    print(f'#{tc} {two_order}')