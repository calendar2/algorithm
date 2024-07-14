function solution(dots) {
    var answer = 0;
    let width = 0;
    let height = 0;
    
    for (let i = 0; i < 4; i++) {
        for (let j = i+1; j < 4; j++) {
            if (dots[i][0] === dots[j][0] || dots[i][1] === dots[j][1]) {
                continue;
            }
            width = Math.abs(dots[i][0] - dots[j][0]);
            height = Math.abs(dots[i][1] - dots[j][1]);
            answer = width * height;
            break;
        }
        
        if (answer !== 0) {
            break;
        }
    }
    
    return answer;
}