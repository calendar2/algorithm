def find(x):
    # 같은 조로 묶어서 학생 리스트를 변경할 경우 후속으로 나오는 학생을 찾을 수가 없다.
    # 그래서 while loop를 진행하며 해당 학생이 속한 조를 찾아낸다.
    while x != students[x]:
        x = students[x]
    return x

def union(x, y):    # 해당하는 학생들을 같은 조로 묶어주는 역할
    students[find(y)] = find(x)

T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())    # 학생 수, 신청서 갯수
    arr = list(map(int, input().split()))   # 신청서 내용
    students = [i for i in range(N+1)]    # 1번 학생부터 N번 학생까지(0번은 나중에 빼기)

    # 신청서 갯수만큼 순회하며 같은 조가 되는 학생들을 합치기
    for i in range(M):
        s1 = arr[i*2]
        s2 = arr[i*2+1]

        union(s1, s2)

    # 3번 케이스의 4,5 4,6 7,4 모두 같은 조이기 때문에 solution 리스트를 생성하여 학생들이 속한 조를 한번 더 찾아준다.
    solution = [0] * N
    for i in range(N):
        solution[i] = find(i+1)

    solution_set = set(solution)
    print(f'#{tc} {len(solution_set)}')