function solution(my_string) {
    var answer = [];
    
    for (const letter of my_string) {
        if (!isNaN(letter)) {
            answer.push(Number(letter));
        }
    }
    
    answer.sort((a, b) => a - b);
    return answer;
}