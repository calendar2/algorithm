function solution(box, n) {
    var answer = 1;
    
    for (const length of box) {
        answer *= ~~(length / n);
    }
    
    return answer;
}