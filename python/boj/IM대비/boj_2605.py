N = int(input())    # 학생의 수
order = list(map(int, input().split())) # 학생들이 뽑은 번호

student_dic = {}   # 학생 딕셔너리
for i in range(1, N+1):
    student_dic[i] = i

# 학생들이 뽑은 번호에 따라 학생의 순서를 바꾼다.
for i in range(N):
    move = order[i]    # 학생이 움직일 수
    student_num = i + 1 # 학생 번호

    # 학생이 움직이는 횟수만큼 반복
    for j in range(move):
        student_dic[student_num-1], student_dic[student_num] = student_dic[student_num], student_dic[student_num-1]
        student_num -= 1

print(*student_dic.values())
# print(**student_dic)