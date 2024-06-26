function solution(n) {
    var answer = [];
    let num = 1;
    
    while (num <= n) {
        answer.push(num);
        num += 2;
    }
    
    return answer;
}