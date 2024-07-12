function solution(array) {
    var answer = 0;
    
    for (const num of array) {
        const str = '' + num;
        for (const s of str) {
            if (s === '7') {
                answer++;
            }
        }
    }
    
    return answer;
}