for tc in range(1, 11):
    # N : 문자열 길이, long_password : 조절하기 전 비밀번호
    N, long_password = map(str, input().split())
    password_list = list(long_password)
    N_int = int(N)
    idx = 0     # 위치를 추정할 인덱스

    while idx <= N_int-2:
        if password_list[idx] == password_list[idx+1]:
            password_list.pop(idx)
            password_list.pop(idx)
            N_int -= 2
            idx = 0
        else:
            idx += 1

    new_password = ''
    for i in password_list:
        new_password += i

    print(f'#{tc} {int(new_password)}')