function solution(n) {
    var answer = 0;
    
    if (n % 2 === 1) {
        for (let i = n; i >= 1; i -= 2) {
            answer += i;
        }
    } else {
        for (let i = n; i >= 2; i -= 2) {
            answer += i * i;
        }
    }
    
    return answer;
}