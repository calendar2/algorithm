function solution(arr) {
    let left = 0;
    let right = arr.length;
    
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] === 2) {
            left = i;
            break;
        }
    }
    
    for (let i = arr.length-1; i >= 0; i--) {
        if (arr[i] === 2) {
            right = i;
            break;
        }
    }
    
    var answer = [];
    
    if (right === arr.length) {
        answer.push(-1);
    } else {
        for (let i = left; i <= right; i++) {
            answer.push(arr[i]);
        }
    }
    
    return answer;
}