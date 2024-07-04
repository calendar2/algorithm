function solution(n) {
    let answer = 0;
    let cnt = 0;
    let num = 1;
    
    while (num <= n) {
        for (let i = 1; i <= num; i++) {
            if (num % i === 0) {
                cnt++;
            }
        }
        
        if (cnt > 2) {
            answer++;
        }
        num++;
        cnt = 0;
    }
    
    return answer;
}