function solution(arr, query) {
    for (let i = 0; i < query.length; i++) {
        if (i % 2) {
            for (let j = 0; j < query[i]; j++) {
                arr.shift();
            }
        } else {
            const cnt = arr.length - 1 - query[i];
            for (let j = 0; j < cnt; j++) {
                arr.pop();
            }
        }
    }
    
    return arr;
}