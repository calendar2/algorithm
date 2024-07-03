function solution(numbers, k) {
    const idx = 2 * (k-1);
    const answer = idx % numbers.length;
    
    return numbers[answer];
}