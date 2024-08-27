function solution(my_string) {
    const temp = my_string.split(' ');
    const answer = [];
    
    for (const t of temp) {
        if (t !== '') {
            answer.push(t);
        }
    }
    
    return answer;
}