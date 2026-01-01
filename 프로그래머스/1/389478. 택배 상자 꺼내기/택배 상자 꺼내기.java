class Solution {
    public int solution(int n, int w, int num) {
        int h = n / w;
        int mod = n % w;
        if (mod != 0) {
            h++;
        }
        
        int[][] storage = new int[h][w];
        int row = h - 1;
        int col = 0;
        boolean isRight = true;
        
        boolean isFind = false;
        int box_col = -1;
        int answer = 1;
        
        for (int i = 1; i <= n; i++) {
            storage[row][col] = i;
            
            if (isFind && col == box_col) {
                answer++;
            }
            
            if (i == num) {
                isFind = true;
                box_col = col;
            }
            
            if (isRight) {
                if (col == w-1) {
                    isRight = false;
                    row--;
                } else {
                    col++;
                }
            } else {
                if (col == 0) {
                    isRight = true;
                    row--;
                } else {
                    col--;
                }
            }
        }
        
        return answer;
    }
}