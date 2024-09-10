function solution(picture, k) {
    var answer = [];
    
    for (const p of picture) {
        for (let i = 0; i < k; i++) {
            let temp = '';
            for (let j = 0; j < p.length; j++) {
                temp += p[j].repeat(k);
            }
            answer.push(temp);
        }
    }
    
    return answer;
}