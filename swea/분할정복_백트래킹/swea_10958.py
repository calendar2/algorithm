def hoare_partition(arr, left, right):
    pivot = arr[right]
    # i = 작은 요소들을 추적
    i = left - 1

    for j in range(left, right):
        if arr[j] <= pivot:
            i += 1
            arr[i], arr[j] = arr[j], arr[i]

    # 피벗 위치 교환
    arr[i + 1], arr[right] = arr[right], arr[i + 1]
    # 피벗의 새 위치를 반환
    return i + 1

def quick_sort(arr, left, right):
    if left < right:
        pivot = hoare_partition(arr, left, right)
        quick_sort(arr, left, pivot - 1)
        quick_sort(arr, pivot + 1, right)

T = int(input())
for tc in range(1, T+1):
    N = int(input())    # 숫자의 갯수
    arr = list(map(int, input().split()))   # 원소들

    quick_sort(arr, 0, N-1)
    print(f'#{tc} {arr[N//2]}')
    # print(arr)