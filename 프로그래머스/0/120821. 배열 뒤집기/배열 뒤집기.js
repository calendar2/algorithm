function solution(num_list) {
    var answer = [];
    
    while (num_list.length > 0) {
        answer.push(num_list.pop());
    }
    
    return answer;
}