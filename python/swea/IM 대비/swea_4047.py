T = int(input())
for tc in range(1, T+1):
    S = list(input())   # 카드의 정보

    # 모양별 카드
    spade = []
    dia = []
    heart = []
    clova = []

    # 각 무늬에 맞춰 담기
    for i in range(0, len(S), 3):
        if S[i] == 'S':
            if S[i+1] == '0':
                spade.append(int(S[i+2]))
            else:
                spade.append(int(S[i+2])+10)
        elif S[i] == 'D':
            if S[i+1] == '0':
                dia.append(int(S[i+2]))
            else:
                dia.append(int(S[i+2])+10)
        elif S[i] == 'H':
            if S[i+1] == '0':
                heart.append(int(S[i+2]))
            else:
                heart.append(int(S[i+2])+10)
        else:
            if S[i+1] == '0':
                clova.append(int(S[i+2]))
            else:
                clova.append(int(S[i+2])+10)

    # 중복검증
    spade_cnt = len(set(spade))
    dia_cnt = len(set(dia))
    heart_cnt = len(set(heart))
    clova_cnt = len(set(clova))

    if spade_cnt + dia_cnt + heart_cnt + clova_cnt == len(S) // 3:
        print(f'#{tc} {13-spade_cnt} {13-dia_cnt} {13-heart_cnt} {13-clova_cnt}')
    else:
        print(f'#{tc} ERROR')