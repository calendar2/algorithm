def enQueue(item):
    global rear
    if rear == len(queue) - 1:
        print("queue is full!")
    else:
        rear += 1
        queue[rear] = item

def deQueue():
    global front
    if front == rear:
        print("queue is empty!")
    else:
        front += 1
        return queue[front]

queue = [0] * 3
front = -1
rear = -1

for i in range(1, 5):
    enQueue(i)

for _ in range(4):
    print(deQueue())