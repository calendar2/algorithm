function solution(num_list, n) {
    var answer = num_list.slice(n);
    
    for (let i = 0; i < n; i++) {
        answer.push(num_list[i]);
    }
    
    return answer;
}