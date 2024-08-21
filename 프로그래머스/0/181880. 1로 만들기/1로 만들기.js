function solution(num_list) {
    var answer = 0;
    let idx = 0;
    
    while (idx < num_list.length) {
        let num = num_list[idx];
        while (num > 1) {
            if (num % 2) {
                num--;
            }
            num /= 2;
            answer++;
        }
        idx++;
    }
    
    return answer;
}