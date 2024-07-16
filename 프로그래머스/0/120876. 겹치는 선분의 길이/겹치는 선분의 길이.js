function solution(lines) {
    let dp = [];
    for (let i = 0; i <= 200; i++) {
        dp.push(0);
    }
    
    for (const line of lines) {
        for (let i = line[0]+100; i < line[1]+100; i++) {
            dp[i]++;
        }
    }
    
    var answer = 0;
    for (let i = 0; i <= 200; i++) {
        if (dp[i] >= 2) {
            answer++;
        }
    }
    
    return answer;
}