function solution(strArr) {
    const counts = new Array(31).fill(0);
    
    for (const str of strArr) {
        counts[str.length]++;
    }
    
    let max = 0;
    for (const count of counts) {
        if (max < count) {
            max = count;
        }
    }
    
    return max;
}