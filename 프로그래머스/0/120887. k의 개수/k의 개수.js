function solution(i, j, k) {
    var answer = 0;
    const k_str = '' + k;
    
    for (let num = i; num <= j; num++) {
        const num_str = '' + num;
        for (const n of num_str) {
            if (n === k_str) {
                answer++;
            }
        }
    }
    return answer;
}