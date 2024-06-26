function solution(array) {
    const counts = [];
    
    for (let i = 0; i < 1000; i++) {
        counts[i] = 0;
    }
    
    for (const element of array) {
        counts[element]++;
    }
    
    let max = 0;
    let maxIdx = -1;
    
    for (let i = 0; i < 1000; i++) {
        if (max === counts[i]) {
            maxIdx = -1;
        } else if (max < counts[i]) {
            max = counts[i];
            maxIdx = i;
        }
    }
    
    return maxIdx;
}