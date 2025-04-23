class Solution {
    public long solution(int price, int money, int count) {
        // count 번 놀이기구를 이용할 때 필요한 금액 계산
        long total_price = 0L;
        
        for (int i = 1; i <= count; i++) {
            total_price += price * i;
        }
        
        // 계산 금액과 현재 가지고 있는 money랑 비교
        if (total_price <= money) {
            return 0;
        } else {
            return total_price - money;
        }
    }
}