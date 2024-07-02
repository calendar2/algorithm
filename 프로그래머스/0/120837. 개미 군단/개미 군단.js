function solution(hp) {
    var answer = 0;
    
    let atk = 5;
    while (atk !== 1) {
        answer += Math.floor(hp / atk);
        hp = hp % atk;
        atk -= 2;
    }
    
    return answer + hp;
}