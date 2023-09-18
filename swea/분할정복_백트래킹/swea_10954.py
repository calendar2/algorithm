def merge(left, right):
    global ans
    l_idx = 0
    r_idx = 0
    result = []

    # left 마지막 요소와 right 마지막 요소를 비교해 left쪽이 더 큰 경우 경우의 수 +1
    if left[-1] > right[-1]:
        ans += 1

    # 한 쪽이 빌 때까지 반복
    while l_idx < len(left) or r_idx < len(right):
        # 둘 다 남아 있으면, 두 리스트의 가장 앞에 있는 것 중 작은 것을 선택하여 result 에 추가
        if l_idx < len(left) and r_idx < len(right):
            if left[l_idx] <= right[r_idx]:
                result.append(left[l_idx])
                l_idx += 1
            else:
                result.append(right[r_idx])
                r_idx += 1
        # 한 쪽만 남아있으면, 남은것을 모두 result 에 추가
        elif l_idx < len(left):
            result.append(left[l_idx])
            l_idx += 1
        elif r_idx < len(right):
            result.append(right[r_idx])
            r_idx += 1

    return result

def merge_sort(unordered_list):
    # 길이가 1인 배열까지 나누면 stop
    if len(unordered_list) == 1:
        return unordered_list

    middle = len(unordered_list) // 2
    left = [0] * middle
    right = [0] * (len(unordered_list) - middle)
    r_idx = 0

    # 왼쪽을 따로 리스트에 저장
    for l in range(middle):
        left[l] = unordered_list[l]

    # 오른쪽을 따로 리스트에 저장
    for r in range(middle, len(unordered_list)):
        right[r_idx] = unordered_list[r]
        r_idx += 1

    left = merge_sort(left)
    right = merge_sort(right)

    return merge(left, right)

T = int(input())
for tc in range(1, T+1):
    N = int(input())    # 정수의 갯수
    arr = list(map(int, input().split()))   # 원소들

    ans = 0
    arr = merge_sort(arr)

    print(f'#{tc} {arr[N//2]} {ans}')