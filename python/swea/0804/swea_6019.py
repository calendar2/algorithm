T = int(input())
for tc in range(1, T+1):
    # D : 기차 사이의 거리, A, B : 기차 A, B의 속력, F : 파리의 속력
    D, A, B, F = map(float, input().split())
    # F_dir = 1       # 파리의 현재 진행 방향(0이면 A를 향해, 1이면 B를 향해 움직이는 중)
    v_AB = A + B    # 기차 A, B의 속력 합
    t = D / v_AB       # 기차가 부딪히는 시간
    F_dis = F * t   # 파리가 움직인 거리
    #
    # while D > 0:
    #     if F_dir:
    #         v = F + B   # 파리와 기차 B의 속력의 합(전체 속력)
    #         t = D / v   # 파리가 기차 B와 부딪힌 시간
    #         F_dir = 0   # 파리 방향 전환
    #     else:
    #         v = F + A
    #         t = D / v
    #         F_dir = 1
    #
    #     distance = v_AB * t     # 기차가 t초만큼 움직인 거리
    #     D = D - distance    # 기차가 t초 후에 남아있는 거리
    #     F_dis += F * t

    print(f'#{tc} {F_dis}')