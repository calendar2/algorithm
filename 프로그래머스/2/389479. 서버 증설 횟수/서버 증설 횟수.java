class Solution {
    public int solution(int[] players, int m, int k) {
        int[] servers = new int[24];
        int len = players.length;
        int answer = 0;
        
        for (int i = 0; i < len; i++) {
            int need = players[i] / m;
            if (servers[i] < need) {
                int extend = need - servers[i];
                answer += extend;
                for (int j = i; j < i+k; j++) {
                    if (j >= 24) {
                        break;
                    }
                    servers[j] += extend;
                }
            }
        }
        
        return answer;
    }
}