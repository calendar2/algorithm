function solution(sides) {
    const big = Math.max(sides[0], sides[1]);
    const small = Math.min(sides[0], sides[1]);
    
    var answer = 0;
    let num = 1;
    while (num < big) {
        if (num + small > big) {
            answer++;
        }
        num++;
    }
    
    while (num < big + small) {
        answer++;
        num++;
    }
    
    return answer;
}