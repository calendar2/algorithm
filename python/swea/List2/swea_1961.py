T = int(input())
for tc in range(1, T+1):
    N = int(input())    # 행렬의 크기
    arr = [list(map(int, input().split())) for _ in range(N)]

    temp = [[0] * 3 for _ in range(N)]  # 변환된 수 담을 배열

    # 90도 회전한 수
    for i in range(N):
        new_str = ''    # 새로운 배열값
        for j in range(N-1, -1, -1):
            arr_val = arr[j][i]     # 해당 배열값
            str_trans = str(arr_val)    # 배열값을 문자열로
            new_str += str_trans    # 문자열을 붙여준다.
        # int_trans = int(new_str)    # 문자열을 다시 숫자로
        temp[i][0] = new_str

    # 180도 회전한 수
    for i in range(N-1, -1, -1):
        new_str = ''    # 새로운 배열값
        for j in range(N-1, -1, -1):
            arr_val = arr[i][j]     # 해당 배열값
            str_trans = str(arr_val)    # 배열값을 문자열로
            new_str += str_trans    # 문자열을 붙여준다.
        # int_trans = int(new_str)    # 문자열을 다시 숫자로
        temp[N-i-1][1] = new_str

    # 270도 회전한 수
    for i in range(N-1, -1, -1):
        new_str = ''  # 새로운 배열값
        for j in range(N):
            arr_val = arr[j][i]  # 해당 배열값
            str_trans = str(arr_val)  # 배열값을 문자열로
            new_str += str_trans  # 문자열을 붙여준다.
        # int_trans = int(new_str)  # 문자열을 다시 숫자로
        temp[N-i-1][2] = new_str

    print(f'#{tc}')
    for i in range(N):
        print(*temp[i])