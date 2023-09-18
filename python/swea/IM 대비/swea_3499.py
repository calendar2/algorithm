T = int(input())
for tc in range(1, T+1):
    N = int(input())    # 카드의 갯수
    cards = list(input().split())   # 카드 이름

    queue1 = []
    queue2 = []
    shuffle = []

    # 반으로 나눠서 각 큐에 삽입
    if N % 2:
        for i in range(N//2+1):
            queue1.append(cards.pop(0))
        for i in cards:
            queue2.append(i)
    else:
        for i in range(N//2):
            queue1.append(cards.pop(0))
        for i in cards:
            queue2.append(i)

    # 다시 카드에 삽입
    for i in range(N // 2):
        shuffle.append(queue1.pop(0))
        shuffle.append(queue2.pop(0))

    if N % 2:
        shuffle.append(queue1.pop())

    print(f'#{tc}', *shuffle)