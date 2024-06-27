function solution(n) {
    let answer = n / gcd(n, 6);
    return answer;
}

const gcd = (num1, num2) => {
    if (num1 % num2 === 0) {
        return num2;
    }
    
    return gcd(num2, num1 % num2);
}