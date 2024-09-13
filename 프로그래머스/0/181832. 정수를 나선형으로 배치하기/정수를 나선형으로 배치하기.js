function solution(n) {
    var answer = Array.from(Array(n), () => Array(n).fill(0));
    let direction = 0;
    let row = 0;
    let col = 0;
    let num = 1;
    const visited = Array.from(Array(n), () => Array(n).fill(false));
    
    while (true) {
        if (num > n*n) {
            break;
        }
        
        answer[row][col] = num++;
        visited[row][col] = true;
        
        switch (direction % 4) {
            case 0 :
                if (col + 1 < n && !visited[row][col+1]) {
                    col++;
                } else {
                    direction++;
                    row++;
                }
                break;
            case 1 :
                if (row + 1 < n && !visited[row+1][col]) {
                    row++;
                } else {
                    direction++;
                    col--;
                }
                break;
            case 2 :
                if (col - 1 >= 0 && !visited[row][col-1]) {
                    col--;
                } else {
                    direction++;
                    row--;
                }
                break;
            case 3 :
                if (row - 1 >= 0 && !visited[row-1][col]) {
                    row--;
                } else {
                    direction++;
                    col++;
                }
                break;
        }
    }
    
    return answer;
}