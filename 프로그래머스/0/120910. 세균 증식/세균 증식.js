function solution(n, t) {
    const dp = [n];
    
    for (let i = 0; i < t; i++) {
        dp.push(dp[i] * 2);
    }
    
    return dp[t];
}