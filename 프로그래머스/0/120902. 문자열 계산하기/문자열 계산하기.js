function solution(my_string) {
    const array = my_string.split(' ');
    var answer = Number(array[0]);
    let idx = 1;
    
    while (idx < array.length) {
        if (array[idx] === '+') {
            answer += Number(array[++idx]);
        } else if (array[idx] === '-') {
            answer -= Number(array[++idx]);
        }
        idx++;
    }
    
    return answer;
}