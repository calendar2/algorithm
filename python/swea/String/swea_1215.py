for tc in range(1, 11):
    length = int(input())   # 회문의 길이
    arr = [list(map(str, input())) for _ in range(8)]   # 문자 배열

    word_list = []      # 단어를 담을 리스트
    cnt = 0     # 회문의 갯수

    # 회문의 갯수 찾기(행 우선)
    for i in range(8):
        for j in range(9-length):
            word_list = []

            # 길이가 length인 단어 리스트 만들기
            for k in range(j, j+length):
                word_list.append(arr[i][k])

            for k in range(length):
                if word_list[k] != word_list[length-k-1]:   # 회문이 아니면 반복 종료
                    break
                else:
                    if k == length//2:     # 단어의 절반 이상 탐색하면 회문으로 인정
                        cnt += 1
                        break

    # 회문의 갯수 찾기(열 우선)
    for i in range(8):
        for j in range(9 - length):
            word_list = []

            # 길이가 length인 단어 리스트 만들기
            for k in range(j, j + length):
                word_list.append(arr[k][i])

            for k in range(length):
                if word_list[k] != word_list[length - k - 1]:  # 회문이 아니면 반복 종료
                    break
                else:
                    if k == length//2:  # 단어의 절반 이상 탐색하면 회문으로 인정
                        cnt += 1
                        break

    print(f'#{tc} {cnt}')