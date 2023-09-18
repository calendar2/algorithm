T = int(input())
for tc in range(1, T+1):
    A, B = map(str, input().split())    # 문자열 두 개

    # 각 문자의 길이
    cnt_A = 0
    cnt_B = 0
    for _ in A:
        cnt_A += 1
    for _ in B:
        cnt_B += 1

    cnt_typing = 0     # 타이핑 횟수

    # 문자열 B의 길이만큼 A를 살펴보며 일치하는지 확인
    word = ''
    k = 0
    for i in range(cnt_A):
        word = ''
        if i >= k:
            # 비교할 단어 만드는 for
            if i+cnt_B <= cnt_A:
                for j in range(i, i+cnt_B):
                    word += A[j]

            if word == B:
                cnt_typing += 1
                k += cnt_B
            else:               # 만들어진 단어가 일치하지 않는다면
                cnt_typing += 1
                k += 1

    print(f'#{tc} {cnt_typing}')