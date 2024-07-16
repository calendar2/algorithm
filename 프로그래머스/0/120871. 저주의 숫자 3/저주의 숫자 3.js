function solution(n) {
    var answer = 0;
    let str = '';
    
    for (let i = 0; i < n; i++) {
        answer++;
        while (true) {
            str = '' + answer;
            
            if (str.includes('3') || answer % 3 === 0) {
                answer++;
            } else {
                break;
            }
        }
    }
    
    return answer;
}