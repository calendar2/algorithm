for tc in range(1, 2):
    N = int(input())    # 정점의 총수
    infos = [list(map(str, input().split())) for _ in range(N)]     # 정점의 정보

    # print(infos)





    # 공부하자
    # def postorder(n):  # 자손 수를 세야하므로 후위 순회
    #     global cnt
    #     if n:  # 존재하는 정점이면
    #         postorder(ch1[n])  # 왼쪽 서브트리로 이동
    #         postorder(ch2[n])  # 오른쪽
    #         cnt += 1  # visit(n)

    # T = int(input())
    # for tc in range(1, T + 1):
    #     E, N = map(int, input().split())  # 간선 수 E, 루트 N
    #     arr = list(map(int, input().split()))
    #     # 부모를 인덱스로 자식을 저장
    #     ch1 = [0] * (E + 2)  # 정점 수 = 간선 수 + 1
    #     ch2 = [0] * (E + 2)
    #     for i in range(E):
    #         p, c = arr[i * 2], arr[i * 2 + 1]
    #         if ch1[p] == 0:  # 자식 1이 아직 없으면
    #             ch1[p] = c
    #         else:
    #             ch2[p] = c
    #     # print(ch1)
    #     # print
    #
    #     cnt = 0
    #     postorder(N)
    #     print(f'#{tc} {cnt}')