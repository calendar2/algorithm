class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        // 시간당 체력 배열 생성
        int attacks_len = attacks.length;
        int max_time = attacks[attacks_len-1][0];
        int[][] health_time_arr = new int[max_time+1][2];
        
        // 초기값 세팅
        health_time_arr[0][0] = health;
        
        // 시계열에 따른 계산
        int attacks_idx = 0;
        for (int i = 1; i <= max_time; i++) {
            // 1. 몬스터한테 공격 당하는 상황인지 판단
            if (attacks_idx < attacks_len && i == attacks[attacks_idx][0]) {
                health_time_arr[i][0] = health_time_arr[i-1][0] - attacks[attacks_idx][1];
                attacks_idx++;
                
                if (health_time_arr[i][0] <= 0) {
                    break;
                }
            } else {
                health_time_arr[i][0] = Math.min(health_time_arr[i-1][0] + bandage[1], health);
                health_time_arr[i][1] = health_time_arr[i-1][1] + 1;
                
                // 2. 추가 회복을 받을 수 있는지 판단
                if (health_time_arr[i][1] == bandage[0]) {
                    health_time_arr[i][0] = Math.min(health_time_arr[i][0] + bandage[2], health);
                    health_time_arr[i][1] = 0;
                }
            }
        }
        
        // 최종 체력 제출
        int answer = health_time_arr[max_time][0];
        if (answer <= 0) {
            answer = -1;
        }
        
        return answer;
    }
}