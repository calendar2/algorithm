T = int(input())
for tc in range(1, T+1):
    N = int(input())    # 가로의 크기
    n = N // 10     # N은 10의 배수이므로 일의 단위로 크기 조정

    # 타일링 메서드
    def tiling(wid):
        tiles = [0] * wid   # 타일링 배열(0번째 인덱스가 N이 10일때, 1번째 인덱스가 N이 20일때... 쭉쭉...)
        tiles[0] = 1        # N이 10일때 종이붙이는 갯수는 1개
        tiles[1] = 3        # N이 20일때 종이붙이는 갯수는 3개

        # 2*1, 2*2 종이로 타일작업하는 경우의 수 구하는 공식
        for i in range(2, wid):
            tiles[i] = tiles[i-1] + 2*tiles[i-2]

        return tiles[wid-1]

    ans = tiling(n)
    print(f'#{tc} {ans}')
    # print(n)