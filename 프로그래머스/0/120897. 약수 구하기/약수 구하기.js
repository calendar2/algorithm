function solution(n) {
    var answer = [];
    let num = 1;
    
    while (num <= n) {
        if (n % num === 0) {
            answer.push(num);
        }
        num++;
    }
    
    return answer;
}