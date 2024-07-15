function solution(board) {
    const dr = [-1, -1, 0, 1, 1, 1, 0, -1];
    const dc = [0, 1, 1, 1, 0, -1, -1, -1];
    const length = board.length;
    
    for (let i = 0; i < length; i++) {
        for (let j = 0; j < length; j++) {
            if (board[i][j] === 1) {
                for (let k = 0; k < 8; k++) {
                    let nr = i + dr[k];
                    let nc = j + dc[k];
                    
                    if (nr >= 0 && nr < length && nc >= 0 && nc < length) {
                        if (board[nr][nc] === 0) {
                            board[nr][nc] = 2;
                        }
                    }
                }
            }
        }
    }
    
    let answer = 0;
    for (let i = 0; i < length; i++) {
        for (let j = 0; j < length; j++) {
            if (board[i][j] === 0) {
                answer++;
            }
        }
    }
    
    return answer;
}