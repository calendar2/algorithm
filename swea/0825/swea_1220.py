for tc in range(1, 11):
    N = int(input())    # 테이블 한 변의 길이
    table = [list(map(int, input().split())) for _ in range(N)]     # 테이블

    cnt = 0     # 교착상태의 갯수
    stopping = False    # 교착 가능성

    # 어차피 N 자성체(1)은 아래로 S 자성체(2)는 위로 올라가니까 테이블을 열 우선 순회하며 1 아래 2가 있을때마다 교착 갯수를 세면 그게 정답 아닐까?
    for i in range(N):
        for j in range(N):
            if table[j][i] == 1:
                stopping = True

            if stopping and table[j][i] == 2:
                stopping = False
                cnt += 1

        stopping = False

    print(f'#{tc} {cnt}')