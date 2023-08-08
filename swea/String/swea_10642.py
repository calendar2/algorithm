T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())    # N : 문자열 배열의 길이, M : 찾아야할 회문의 길이
    arr = [list(map(str, input())) for _ in range(N)]       # 주어진 문자열 배열

    isSame = False      # 회문 여부
    word = ''       # 회문
    # cnt = 0     # 회문 길이
    word_list = []

    # 행 우선 순회
    for i in range(N):
        for j in range(N-M+1):      # 회문의 길이만큼만 행을 순회하고
            word_list = []
            word = ''
            for k in range(j, j+M):
                word_list.append(arr[i][k])     # 회문의 길이만큼 리스트에 입력

            for k in range(M):
                if word_list[k] != word_list[M-1-k]:  # 회문의 끝과 끝이 다를 경우 반복 종료
                    break
                else:
                    word += word_list[k]
                    if k == M-1:
                        isSame = True

            if isSame:
                break   # for j
        if isSame:
            break       # for i

    if isSame is False:
        # 열 우선 순회
        for i in range(N):
            for j in range(N - M + 1):  # 회문의 길이만큼만 행을 순회하고
                word_list = []
                word = ''
                for k in range(j, j + M):
                    word_list.append(arr[k][i])  # 회문의 길이만큼 리스트에 입력

                for k in range(M):
                    if word_list[k] != word_list[M-1-k]:  # 회문의 끝과 끝이 다를 경우 반복 종료
                        break
                    else:
                        word += word_list[k]
                        if k == M - 1:
                            isSame = True

                if isSame:
                    break  # for j
            if isSame:
                break  # for i

    print(f'#{tc} {word}')