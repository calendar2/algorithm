function solution(arr, queries) {
    for (const query of queries) {
        for (let i = query[0]; i <= query[1]; i++) {
            arr[i]++;
        }
    }
    
    return arr;
}