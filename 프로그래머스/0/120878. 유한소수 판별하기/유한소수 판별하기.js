function solution(a, b) {
    b /= gcd(a, b);
    
    while (b % 2 === 0) {
        b /= 2;
    }
    
    while (b % 5 === 0) {
        b /= 5;
    }
    
    var answer = 2;
    if (b === 1) {
        answer = 1;
    }
    
    return answer;
}

const gcd = (num1, num2) => {
    if (num2 === 0) {
        return num1;
    }
    
    return gcd(num2, num1 % num2);
}