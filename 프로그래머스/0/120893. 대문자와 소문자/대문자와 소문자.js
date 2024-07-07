function solution(my_string) {
    var answer = '';
    
    for (const letter of my_string) {
        if (letter === letter.toUpperCase()) {
            answer += letter.toLowerCase();
        } else {
            answer += letter.toUpperCase();
        }
    }
    return answer;
}