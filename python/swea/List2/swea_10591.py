T = int(input())

for tc in range(1, T+1):
    P, Pa, Pb = map(int, input().split())   # P : 책의 전체 쪽수, Pa : A가 찾을 페이지, Pb : B가 잧을 페이지

    # l = 1   # 책의 첫 페이지
    # c = (l + P) // 2    # 중간 페이지

    def binary_search(N, key):
        start = 1
        end = N
        cnt = 0
        while start <= end:
            middle = (start + end) // 2
            if middle == key:
                return cnt
            elif middle > key:
                end = middle
            else:
                start = middle
            cnt += 1
        return -1

    A = binary_search(P, Pa) # A가 찾아낸 횟수
    B = binary_search(P, Pb) # B가 찾아낸 횟수

    # A랑 B를 비교해서 숫자가 작은 쪽이 먼저 찾은 것이므로 해당 문자를 출력한다.
    if A < B:
        print(f'#{tc} {"A"}')
    elif A == B:
        print(f'#{tc} {0}')
    else:
        print(f'#{tc} {"B"}')