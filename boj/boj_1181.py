N = int(input())    # 단어의 갯수
word_list = [input() for _ in range(N)]     # 단어 리스트

# 중복된 단어 제거
word_list_set = list(set(word_list))
length = len(word_list_set)     # 새로운 리스트의 길이

for i in range(length-1, -1, -1):
    for j in range(i):
        if len(word_list_set[j]) > len(word_list_set[j+1]):
            word_list_set[j], word_list_set[j+1] = word_list_set[j+1], word_list_set[j]
        elif len(word_list_set[j]) == len(word_list_set[j+1]):
            for k in range(len(word_list_set[j])):
                if ord(word_list_set[j][k]) > ord(word_list_set[j+1][k]):
                    word_list_set[j], word_list_set[j + 1] = word_list_set[j + 1], word_list_set[j]
                    break

for i in word_list_set:
    print(i)