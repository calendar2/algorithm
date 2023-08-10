T = int(input())
for tc in range(1, T+1):
    word_list = list(input())   # 입력단어 리스트화

    save_list = []      # 리스트에서 빠져나온 글자 보관용
    word = ''   # 현재 단어
    prev_word = ''      # 이전 단어

    # 각 리스트의 길이
    word_length = len(word_list)
    save_length = 0

    flag = True

    while flag:
        if save_length == 0:
            # word_list에 마지막 요소를 prev_word에 할당하고 길이를 1 줄임
            prev_word = word_list.pop()
            word_length -= 1

            # save_list에 꺼내온 요소를 push하고 길이를 1 늘림
            save_list.append(prev_word)
            save_length += 1
        else:
            # save_list에 요소가 존재하니까 word에 할당하고 길이를 1 줄임
            word = word_list.pop()
            word_length -= 1

            if word == prev_word:   # 글자가 연속하면
                save_list.pop()
                save_length -= 1

                # prev_word를 업데이트 해준다.
                if save_length != 0:
                    prev_word = save_list.pop()
                    save_list.append(prev_word)

            else:
                prev_word = word
                save_list.append(prev_word)
                save_length += 1

        # 기존 단어 리스트의 길이가 0이면 반복 종료
        if word_length == 0:
            flag = False

    print(f'#{tc} {save_length}')