function solution(arr, n) {
    const len = arr.length;
    
    if (len % 2) {
        for (let i = 0; i < len; i++) {
            if (i % 2 === 0) {
                arr[i] += n;
            }
        }
    } else {
        for (let i = 0; i < len; i++) {
            if (i % 2) {
                arr[i] += n;
            }
        }
    }
    
    return arr;
}