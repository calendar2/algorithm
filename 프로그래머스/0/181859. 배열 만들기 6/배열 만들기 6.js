function solution(arr) {
    var answer = [];
    let idx = 0;
    
    while (idx < arr.length) {
        if (answer.length === 0) {
            answer.push(arr[idx]);
        } else {
            if (answer[answer.length-1] === arr[idx]) {
                answer.pop();
            } else {
                answer.push(arr[idx]);
            }
        }
        idx++;
    }
    
    if (answer.length === 0) {
        answer.push(-1);
    }
    
    return answer;
}