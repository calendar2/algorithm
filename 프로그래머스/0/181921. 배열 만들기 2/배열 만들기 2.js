function solution(l, r) {
    var answer = [];
    
    for (let i = l; i <= r; i++) {
        const str = '' + i;
        for (let j = 0; j < str.length; j++) {
            if (str[j] !== '0' && str[j] !== '5') {
                break;
            }
            
            if (j === str.length - 1) {
                answer.push(i);
            }
        }
    }
    
    if (answer.length === 0) {
        answer.push(-1);
    }
    
    return answer;
}