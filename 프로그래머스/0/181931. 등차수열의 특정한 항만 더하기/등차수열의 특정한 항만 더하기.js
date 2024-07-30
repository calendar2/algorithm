function solution(a, d, included) {
    const numbers = new Array(included.length).fill(a);
    
    for (let i = 1; i < numbers.length; i++) {
        numbers[i] += d * i;
    }
    
    var answer = 0;
    
    for (let i = 0; i < included.length; i++) {
        if (included[i]) {
            answer += numbers[i];
        }
    }
    
    return answer;
}