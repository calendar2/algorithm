function solution(order) {
    var answer = 0;
    
    for (const o of order) {
        if (o.includes('cafelatte')) {
            answer += 5000;
        } else {
            answer += 4500;
        }
    }
    
    return answer;
}