function solution(num_list) {
    let multiple = 1;
    let sum = 0;
    
    for (const num of num_list) {
        multiple *= num;
        sum += num;
    }
    
    var answer = 0;
    
    if (multiple < sum * sum) {
        answer = 1;
    }
    
    return answer;
}