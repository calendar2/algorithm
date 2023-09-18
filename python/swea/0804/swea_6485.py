T = int(input())
for tc in range(1, T+1):
    N = int(input())    # 버스 노선 갯수

    # 버스 노선 : arr[i][0]번 정류장부터 arr[i][1]번 정류장까지 버스가 다닌다.
    arr = [list(map(int, input().split())) for _ in range(N)]
    P = int(input())    # 확인해야할 버스 정류장 개수
    C = []
    for i in range(P):
        num = int(input())  # 확인해야할 버스 정류장 번호
        C.append(num)       # 확인해야할 버스 정류장 번호 리스트

    cnt = 0     # 해당 버스 정류장을 다니는 버스 노선의 갯수
    cnt_arr = []    # cnt로 이루어진 배열

    # 확인해야할 버스 정류장 리스트를 순회한다.
    for i in C:
        cnt = 0
        # 버스 노선 리스트를 순회하며 각 버스의 출발지와 도착지를 a, b라는 변수에 할당한다.
        for a, b in arr:
            if a <= i <= b:
                cnt += 1
        cnt_arr.append(cnt)

    print(f'#{tc}', *cnt_arr)