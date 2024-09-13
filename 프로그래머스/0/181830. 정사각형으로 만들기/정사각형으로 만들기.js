function solution(arr) {
    const row_len = arr.length;
    const col_len = arr[0].length;
    const max_len = Math.max(row_len, col_len);
    
    var answer = Array.from(new Array(max_len), () => Array(max_len).fill(0));
    for (let i = 0; i < row_len; i++) {
        for (let j = 0; j < col_len; j++) {
            answer[i][j] = arr[i][j];
        }
    }
    
    if (row_len > col_len) {
        for (let i = 0; i < row_len; i++) {
            for (let j = col_len; j < row_len; j++) {
                answer[i][j] = 0;
            }
        }
    } else if (row_len < col_len) {
        for (let i = row_len; i < col_len; i++) {
            for (let j = 0; j < col_len; j++) {
                answer[i][j] = 0;
            }
        }
    }
    
    return answer;
}