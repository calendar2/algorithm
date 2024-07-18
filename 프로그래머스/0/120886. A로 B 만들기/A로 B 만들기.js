function solution(before, after) {
    const before_arr = before.split('').sort();
    const after_arr = after.split('').sort();
    
    var answer = 1;
    for (let i = 0; i < before.length; i++) {
        if (before_arr[i] !== after_arr[i]) {
            answer = 0;
            break;
        }
    }
    
    return answer;
}