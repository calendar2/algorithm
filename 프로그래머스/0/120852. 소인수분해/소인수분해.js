function solution(n) {
    var answer = [];
    let num = 2;
    
    while (num <= n) {
        if (n % num === 0) {
            n /= num;
            answer.push(num);
        } else {
            num++;
        }
    }
    
    return [...new Set(answer)];
}