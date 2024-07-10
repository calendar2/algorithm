function solution(num, k) {
    var answer = 0;
    const str_num = '' + num;
    
    for (let i = 0; i < str_num.length; i++) {
        if (k == str_num[i]) {
            answer = i+1;
            break;
        }
        
        if (i === str_num.length - 1) {
            answer = -1;
        }
    }
    
    return answer;
}