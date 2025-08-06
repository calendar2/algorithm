class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int employee_num = schedules.length;
        int answer = employee_num;
        
        for (int i = 0; i < timelogs.length; i++) {
            int deadline = schedules[i] + 10;
            int hour = deadline / 100;
            int min = deadline % 100;
            
            if (min >= 60) {
                hour += 1;
                min -= 60;
            }
            
            deadline = hour * 100 + min;
            
            for (int j = 0; j < 7; j++) {
                int day = (j + startday) % 7;
                if (day == 0 || day == 6) {
                    continue;
                }
                
                if (timelogs[i][j] > deadline) {
                    answer -= 1;
                    break;
                }
            }
        }
        
        return answer;
    }
}