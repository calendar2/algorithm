function solution(arr) {
    var answer = 1;
    const len = arr.length;
    let flag = false;
    
    for (let i = 0; i < len; i++) {
        for (let j = 0; j < len; j++) {
            if (arr[i][j] !== arr[j][i]) {
                answer = 0;
                flag = true;
                break;
            }
        }
        
        if (flag) {
            break;
        }
    }
    
    return answer;
}