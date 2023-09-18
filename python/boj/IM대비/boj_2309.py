import sys

height_dict = {}
height_total = 0
fake_idx = [0, 0]

for i in range(1, 10):
    height = int(sys.stdin.readline())
    height_dict[i] = height
    height_total += height     # 9명 키의 총합

unneed_height = height_total - 100  # 불필요한 키의 합
isSearch = False

# 불필요한 키 찾기
for i in range(1, 9):
    for j in range(i+1, 10):
        fake_height = height_dict[i] + height_dict[j]
        if unneed_height == fake_height:
            fake_idx[0] = i
            fake_idx[1] = j
            isSearch = True
            break
    if isSearch:
        break

seven = []     # 난쟁이 키 배열
for i in range(1, 10):
    if i in fake_idx:
        continue
    else:
        seven.append(height_dict[i])

# 정렬
seven.sort()
for i in seven:
    print(i)