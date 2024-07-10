function solution(n) {
    const numstr = '' + n;
    let answer = 0;
    
    for (const num of numstr) {
        answer += Number(num);
    }
    
    return answer;
}