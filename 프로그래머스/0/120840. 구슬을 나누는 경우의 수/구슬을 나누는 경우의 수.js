function solution(balls, share) {
    var answer = 1;
    let div = balls - share;
    
    while (balls > share) {
        answer *= balls--;
    }
    
    while (div > 1) {
        answer /= div--;
    }
    
    return answer;
}