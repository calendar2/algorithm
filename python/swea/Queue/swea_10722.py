def isEmpty():  # 큐가 비었는지
    return front == rear

def isFull():   # 큐가 가득 찼는지
    global N
    return (rear+1) % (N+1) == front

def enQueue(item):      # 큐 삽입
    global rear
    if isFull():
        print("Full")
    else:
        rear = (rear+1) % (N+1)
        queue[rear] = item

def deQueue():
    global front
    if isEmpty():
        print("empty")
    else:
        front = (front+1) % (N+1)
        return queue[front]

T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())    # N : 자연수 갯수, M : M번 반복
    arr = list(map(int, input().split()))   # 주어진 자연수

    queue = [None] * (N+1)      # N+1 크기의 원형 큐 생성
    front = 0
    rear = 0

    # 자연수를 큐에 삽입
    for i in arr:
        enQueue(i)

    # M번 반복하며 가장 앞에 숫자를 맨 뒤로 보내기
    for _ in range(M):
        num = deQueue()
        enQueue(num)

    result = deQueue()  # 큐에 가장 앞에 있는 숫자
    print(f'#{tc} {result}')
    print(queue)