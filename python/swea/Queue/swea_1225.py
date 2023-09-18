def enQueue(item):      # 큐 삽입
    global rear

    if (rear+1) % 9 == front:
        print("Full")
    else:
        rear = (rear+1) % 9
        queue[rear] = item

def deQueue():
    global front

    if front == rear:
        return -1
    else:
        front = (front+1) % 9
        return queue[front]

for tc in range(10):
    T = int(input())    # 테스트 케이스 번호
    data_list = list(map(int, input().split()))      # 8개의 데이터

    queue = [0] * 9     # 원형 큐
    front = 0
    rear = 0
    trans_end = False

    # 큐에 데이터 삽입
    for data in data_list:
        enQueue(data)

    # 암호화 작업
    while True:
        for i in range(1, 6):
            num = deQueue()
            num -= i

            # 이때 num이 0 이하가 되면
            if num <= 0:
                enQueue(0)
                trans_end = True
                break
            else:
                enQueue(num)
        if trans_end:
            break

    # 변환된 암호를 데이터리스트에 다시 담기
    for i in range(8):
        num = deQueue()
        data_list[i] = num

    print(f'#{T}', *data_list)