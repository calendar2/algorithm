function solution(n, k) {
    const drink = k - Math.floor(n / 10);
    const answer = n * 12000 + drink * 2000;
    
    return answer;
}