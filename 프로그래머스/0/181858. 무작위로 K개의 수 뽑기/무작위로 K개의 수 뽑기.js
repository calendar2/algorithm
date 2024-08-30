function solution(arr, k) {
    var answer = [];
    const set = new Set(arr);
    const setArr = [...set];
    
    for (let i = 0; i < k; i++) {
        if (i < setArr.length) {
            answer.push(setArr[i]);
        } else {
            answer.push(-1);
        }
    }
    
    return answer;
}