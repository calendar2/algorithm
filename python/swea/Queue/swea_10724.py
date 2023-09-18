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
        oven[rear] = item

def deQueue():
    global front
    if isEmpty():
        return -1
    else:
        front = (front+1) % (N+1)
        return oven[front]

T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())    # N : 화덕의 크기, M : 피자 갯수
    c_list = list(map(int, input().split()))    # 치즈의 양

    oven = [0] * (N+1)  # 화덕 배열
    front = 0
    rear = 0
    index = 0
    last_pizza = -1

    # 화덕에 제일 처음 피자 넣기
    for i in range(N):
        enQueue(i)
        index += 1

    # 피자 굽기
    while True:
        pizza_idx = deQueue()      # 화덕에서 피자 빼기
        if pizza_idx is None:   # 화덕에 피자가 없으면
            continue
        if pizza_idx == -1:
            break
        c_list[pizza_idx] = c_list[pizza_idx] // 2    # 치즈양 절반으로 줄이기
        if c_list[pizza_idx] == 0:
            if index == M:  # 피자가 다 들어가면
                last_pizza = pizza_idx
                continue
            else:
                enQueue(index)
                index += 1
        else:
            enQueue(pizza_idx)         # 화덕에 다시 넣기


    print(f'#{tc} {last_pizza+1}')