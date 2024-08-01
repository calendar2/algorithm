function solution(arr, queries) {
    var answer = [];
    
    for (const query of queries) {
        let min = 1000001;
        for (let i = query[0]; i <= query[1]; i++) {
            if (arr[i] > query[2] && arr[i] < min) {
                min = arr[i];
            }
        }
        
        if (min === 1000001) {
            min = -1;
        }
        answer.push(min);
    }
    
    return answer;
}