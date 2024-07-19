function solution(common) {
    var answer = 0;
    const length = common.length;
    
    let operation = '*';
    if (common[2] - common[1] === common[1] - common[0]) {
        operation = '+';
    }
    
    let num = 0;
    if (operation === '+') {
        num = common[1] - common[0];
        answer = common[length-1] + num;
    } else {
        num = common[1] / common[0];
        answer = common[length-1] * num;
    }
    
    return answer;
}