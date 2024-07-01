function solution(emergency) {
    var answer = [];
    for (let i = 0; i < emergency.length; i++) {
        answer.push(0);
    }
    
    const emergency_sorted = [...emergency].sort((a, b) => b - a);
    
    let order = 1;
    for (const es of emergency_sorted) {
        for (let i = 0; i < emergency.length; i++) {
            if (es === emergency[i]) {
                answer[i] = order;
                order++;
                break;
            }
        }
    }
    
    return answer;
}