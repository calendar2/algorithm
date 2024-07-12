function solution(my_str, n) {
    var answer = [];
    let length = 0;
    
    let str = '';
    for (let i = 0; i < my_str.length; i++) {
        str += my_str[i];
        length++;
        
        if (length === n) {
            answer.push(str);
            str = '';
            length = 0;
        }
    }
    
    if (str !== '') {
        answer.push(str);
    }
    return answer;
}