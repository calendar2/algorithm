function solution(str_list) {
    let idx = -1;
    let direction = -1;
    
    for (let i = 0; i < str_list.length; i++) {
        if (str_list[i] === 'l') {
            direction = 0;
            idx = i;
            break;
        } else if (str_list[i] === 'r') {
            direction = 1;
            idx = i;
            break;
        }
    }
    
    let answer;
    if (direction === 0) {
        answer = str_list.slice(0, idx);
    } else if (direction === 1) {
        answer = str_list.slice(idx+1);
    } else {
        answer = [];
    }
    
    return answer;
}