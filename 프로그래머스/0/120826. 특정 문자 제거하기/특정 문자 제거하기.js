function solution(my_string, letter) {
    var answer = '';
    
    for (const my_char of my_string) {
        if (my_char !== letter) {
            answer += my_char;
        }
    }
    
    return answer;
}