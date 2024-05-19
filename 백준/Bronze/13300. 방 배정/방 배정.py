N, K = map(int, input().split())    # N : 학생 수, K : 한 방에 배정할 수 있는 최대 인원 수
total_student_list = []

for i in range(N):
    student_list = list(map(int, input().split()))
    total_student_list.append(student_list)

cnt = 0     # 성별별, 학년별 학생 수
room_cnt = 0    # 방의 갯수

# 여학생부터 남학생순으로, 1학년부터 6학년까지 각각 몇 명인지
# 그리고 K와 비교해서 방의 갯수를 결정한다.
for i in range(2):
    for j in range(1, 7):
        cnt = 0
        for k in range(N):
            if total_student_list[k][0] == i and total_student_list[k][1] == j:
                cnt += 1

        # 만약 학년별, 성별별 학생 수와 K값의 나머지가 0이라면 몫 그대로 방의 갯수로 한다.
        if cnt % K == 0:
            room_cnt += cnt // K
        else:
            room_cnt += (cnt // K) + 1

print(room_cnt)