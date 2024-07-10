function solution(quiz) {
    var answer = [];
    
    for (const q of quiz) {
        const temp = q.split(' ');
        let num = Number(temp[0]);
        let idx = 1;
        
        while (true) {
            if (temp[idx] === '+') {
                num += Number(temp[++idx]);
            } else if (temp[idx] === '-') {
                num -= Number(temp[++idx]);
            }
            idx++;
            
            if (temp[idx] === '=') {
                break;
            }
        }
        
        if (num === Number(temp[++idx])) {
            answer.push('O');
        } else {
            answer.push('X');
        }
    }
    
    return answer;
}