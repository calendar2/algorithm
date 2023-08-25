T = int(input())
for tc in range(1, T+1):
    N = int(input())    # 당근의 갯수
    c_list = list(map(int, input().split()))    # 당근의 크기
    c_list.sort()

    min_v = N   # 차이의 최솟값
    count = [0] * 31    # 카운트 배열

    for c in c_list:
        count[c] += 1

    # 같은 크기의 당근은 한 개로 가정하고 다시 갯수를 세면
    n = 0
    for i in count:
        if i != 0:
            n += 1

    # 기존 count에서 0을 제외한 새로운 카운트 배열
    new_cnt = [0] * n
    idx = 0
    for i in count:
        if i != 0:
            new_cnt[idx] = i
            idx += 1

    # 소, 중, 대 순열?
    s_cnt = 0
    m_cnt = 0
    l_cnt = 0
    for i in range(n-2):
        m_cnt = 0
        s_cnt += new_cnt[i]
        for j in range(i+1, n-1):
            l_cnt = 0
            m_cnt += new_cnt[j]
            for k in range(j+1, n):
                l_cnt += new_cnt[k]

            # 당근 갯수 N // 2 조건 충족하는지?
            if s_cnt <= N//2 and m_cnt <= N//2 and l_cnt <= N//2:
                # 이제야 최솟값 비교
                c_tuple = (s_cnt, m_cnt, l_cnt)
                if min_v > max(c_tuple)-min(c_tuple):
                    min_v = max(c_tuple) - min(c_tuple)

    if min_v == N:
        min_v = -1

    print(f'#{tc} {min_v}')