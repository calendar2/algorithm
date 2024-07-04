const factorial = (num) => {
    if (num === 1) {
        return 1;
    }
    
    return num * factorial(num-1);
}

function solution(n) {
    var answer = 0;
    
    for (let i = 1; i <= 10; i++) {
        if (factorial(i) <= n) {
            answer = i;
        } else {
            break;
        }
    }
    
    return answer;
}