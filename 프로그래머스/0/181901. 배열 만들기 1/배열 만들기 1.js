function solution(n, k) {
    var answer = [];
    let num = 1;
    
    while (num <= n) {
        if (num % k === 0) {
            answer.push(num);
        }
        num++;
    }
    
    return answer;
}