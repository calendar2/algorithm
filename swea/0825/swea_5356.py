T = int(input())
for tc in range(1, T+1):
    words = [list(input()) for _ in range(5)]   # 칠판에 쓰여진 단어

    length_max = 0  # 단어 길이의 최댓값
    l_list = [0] * 5
    for i in range(5):
        l_list[i] = len(words[i])
        if length_max < l_list[i]:
            length_max = l_list[i]

    # 단어 변경(최대길이와 비교해서 부족한 길이만큼 추가로 단어 생성)
    for i in range(5):
        for j in range(length_max-l_list[i]):
            words[i].append('')

    new_word = ''   # 새로운 단어

    # 단어를 세로로 읽어가며 새로운 단어에 추가
    for i in range(length_max):
        for j in range(5):
            if words[j][i]:
                new_word += words[j][i]
            else:
                continue

    print(f'#{tc} {new_word}')