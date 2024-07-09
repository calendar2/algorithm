function solution(s1, s2) {
    var answer = 0;
    
    for (const s3 of s1) {
        for (const s4 of s2) {
            if (s3 === s4) {
                answer++;
            }
        }
    }
    
    return answer;
}