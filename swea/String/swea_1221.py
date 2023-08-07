T = int(input())
for tc in range(1, T+1):
    t, N = map(str, input().split())    # t : 테스트 케이스 번호, N : 테스트 케이스의 길이
    arr = list(map(str, input().split()))   # 테스트 케이스

    # n = int(N)  # 테스트 케이스의 길이를 숫자로 변경
    count_arr = [0] * 10    # 카운트 배열

    # 배열 요소를 key, 상응하는 숫자를 value로 갖는 딕셔너리
    num_dict = {'ZRO': 0, 'ONE': 1, 'TWO': 2, 'THR': 3, 'FOR': 4, 'FIV': 5, 'SIX': 6, 'SVN': 7, 'EGT': 8, 'NIN': 9}
    num_dict_reverse = {0: 'ZRO', 1: 'ONE', 2: 'TWO', 3: 'THR', 4: 'FOR', 5: 'FIV', 6: 'SIX', 7: 'SVN', 8: 'EGT', 9: 'NIN'}
    # 테스트 케이스 요소를 순회하며 해당 요소의 키값과 j가 일치할 때 그 j를 인덱스로 하여 count_arr의 값 증가
    for i in arr:
        for j in range(10):
            if num_dict[i] == j:    # 딕셔너리 값이 j와 일치하면
                count_arr[j] += 1
                break   # for j

    temp = []   # 정렬된 배열

    # 카운트 배열을 순회하며 카운팅된 값이 0이 될 때까지 정렬된 배열에 요소 추가
    for i in range(10):
        while count_arr[i] > 0:
            temp.append(num_dict_reverse[i])
            count_arr[i] -= 1

    print(t)
    print(*temp)