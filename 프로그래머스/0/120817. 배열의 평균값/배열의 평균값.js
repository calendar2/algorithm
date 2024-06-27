function solution(numbers) {
    let length = numbers.length;
    let total = 0;
    
    for (const number of numbers) {
        total += number;
    }
    
    return total / length;
}