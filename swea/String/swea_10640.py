T = int(input())
for tc in range(1, T+1):
    str1 = input()  # 첫 번째 문자열
    str2 = input()  # 두 번째 문자열

    # str1_list = list(str1)  # str1 리스트화
    str2_list = list(str2)  # str2 리스트화

    M = len(str2_list)      # str2 리스트의 길이
    N = len(str1)   # str1 문자열의 길이

    isCorrect = False       # 문자열 일치 여부
    # cnt = 0     # 일치 횟수

    for i in range(M-N+1):
        s = ''      # 빈 문자열 생성
        for j in range(i, i+N):
            s += str2_list[j]

        if str1 == s:
            isCorrect = True
            break

    ans = 0
    if isCorrect:
        ans = 1

    print(f'#{tc} {ans}')