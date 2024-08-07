function solution(my_string) {
    var answer = [];
    let left = 0;
    let right = my_string.length;
    
    while (left < right) {
        answer.push(my_string.substring(left));
        left++;
    }
    
    answer.sort();
    return answer;
}