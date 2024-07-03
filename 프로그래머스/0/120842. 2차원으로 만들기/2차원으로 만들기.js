function solution(num_list, n) {
    var answer = [];
    let temp = [];
    
    for (const num of num_list) {
        temp.push(num);
        
        if (temp.length === n) {
            answer.push(temp);
            temp = [];
        }
    }
    
    return answer;
}