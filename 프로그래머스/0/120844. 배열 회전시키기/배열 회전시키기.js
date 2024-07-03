function solution(numbers, direction) {
    let num = 0;
    
    if (direction === 'right') {
        num = numbers.pop();
        numbers.unshift(num);
    } else {
        num = numbers.shift();
        numbers.push(num);
    }
    
    return numbers;
}