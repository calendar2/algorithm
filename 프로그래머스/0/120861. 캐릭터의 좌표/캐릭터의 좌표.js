function solution(keyinput, board) {
    var answer = [0, 0];
    
    for (const key of keyinput) {
        switch (key) {
            case 'left':
                if (answer[0] - 1 >= Math.floor(board[0] / 2) * (-1)) {
                    answer[0] -= 1;
                }
                break;
            case 'right':
                if (answer[0] + 1 <= Math.floor(board[0] / 2)) {
                    answer[0] += 1;
                }
                break;
            case 'up':
                if (answer[1] + 1 <= Math.floor(board[1] / 2)) {
                    answer[1] += 1;
                }
                break;
            case 'down':
                if (answer[1] - 1 >= Math.floor(board[1] / 2) * (-1)) {
                    answer[1] -= 1;
                }
                break;
        }
    }
    
    return answer;
}