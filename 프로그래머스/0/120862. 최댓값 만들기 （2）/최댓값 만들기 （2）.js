function solution(numbers) {
    const length = numbers.length;
    var answer = numbers.sort((a, b) => a - b);
    
    return Math.max(answer[0] * answer[1], answer[length-1] * answer[length-2]);
}