function solution(arr, intervals) {
    var answer = [];
    
    for (const interval of intervals) {
        for (let i = interval[0]; i <= interval[1]; i++) {
            answer.push(arr[i]);
        }
    }
    
    return answer;
}