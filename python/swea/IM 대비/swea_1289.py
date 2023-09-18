T = int(input())
for tc in range(1, T+1):
    memory = list(map(int, input()))    # 메모리의 원래 값

    idx = -1     # 메모리에서 1이 있는 인덱스(가장 빠른 인덱스)

    # 인덱스 탐색
    for i in range(len(memory)):
        if memory[i]:
            idx = i
            break

    ans = 0
    finish = False
    if idx != -1:
        while True:
            finish = True
            for i in range(idx, len(memory)):
                if memory[i]:
                    memory[i] = 0
                else:
                    memory[i] = 1

            ans += 1
            # 복구됐는지 확인
            for i in range(idx+1, len(memory)):
                if memory[i]:
                    finish = False
                    idx = i
                    break

            if finish:
                break

    print(f'#{tc} {ans}')