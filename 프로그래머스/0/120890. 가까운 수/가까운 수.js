function solution(array, n) {
    array.sort((a, b) => a - b);
    let idx = 0;
    
    for (let i = 1; i < array.length; i++) {
        if (Math.abs(n - array[i]) < Math.abs(n - array[idx])) {
            idx = i;
        }
    }
    
    return array[idx];
}