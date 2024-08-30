function solution(arr) {
    let depth = 1;
    
    while (depth < arr.length) {
        depth *= 2;
    }
    
    const diff = depth - arr.length;
    
    for (let i = 0; i < diff; i++) {
        arr.push(0);
    }
    
    return arr;
}