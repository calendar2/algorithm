function solution(my_string) {
    const answer = new Array(52).fill(0);
    
    for (const s of my_string) {
        let idx = s.charCodeAt() - 65;
        if (idx > 25) {
            idx -= 6;
        }
        
        answer[idx]++;
    }
    
    return answer;
}