function solution(code) {
    var answer = '';
    const length = code.length;
    let idx = 0;
    let mode = 0;
    
    while (idx < length) {
        if (mode === 0) {
            if (code[idx] === '1') {
                mode = 1;
            } else {
                if (idx % 2 === 0) {
                    answer += code[idx];
                }
            }
        } else {
            if (code[idx] === '1') {
                mode = 0;
            } else {
                if (idx % 2 === 1) {
                    answer += code[idx];
                }
            }
        }
        idx++;
    }
    
    if (answer === '') {
        answer = 'EMPTY';
    }
    
    return answer;
}