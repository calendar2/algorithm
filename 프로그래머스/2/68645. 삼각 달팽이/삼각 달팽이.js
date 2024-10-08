function solution(n) {
    const arr = Array(n).fill().map((_, i) => Array(i+1).fill(0));
    const max = (n+1) * n / 2;
    let row = 0;
    let col = 0;
    let dir = 0;
    let num = 1;
    
    while (num <= max) {
        while (row < n && !arr[row][col]) {
            arr[row++][col] = num++;
        }
        row--;
        col++;
        
        while (col < n && !arr[row][col]) {
            arr[row][col++] = num++;
        }
        row--;
        col -= 2;
        
        while (row > 0 && col > 0 && !arr[row][col]) {
            arr[row--][col--] = num++;
        }
        row += 2;
        col++;
    }
    
    return arr.flat();
}