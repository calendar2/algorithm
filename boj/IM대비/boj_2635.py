import sys

first_num = int(sys.stdin.readline())    # 첫 번째 수
max_cnt = 0
max_list = []

for i in range(99, 0, -1):
    num_list = [first_num, i]
    idx = 0
    while True:
        next_num = num_list[idx] - num_list[idx+1]
        if next_num < 0:
            break
        else:
            num_list.append(next_num)
            idx += 1

    cnt = len(num_list)
    if max_cnt < cnt:
        max_cnt = cnt
        for j in num_list:
            max_list.append(j)
        num_list.clear()

print(max_cnt)
print(*max_list)