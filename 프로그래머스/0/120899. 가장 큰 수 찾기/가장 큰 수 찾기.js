function solution(array) {
    let idx = 0;
    let max = 0;
    
    for (let i = 0; i < array.length; i++) {
        if (array[i] > max) {
            max = array[i];
            idx = i;
        }
    }
    
    return [max, idx];
}