function solution(my_string) {
    var answer = 0;
    let left = 0;
    let right = 0;
    
    while (right < my_string.length) {
        if (isNaN(my_string[right])) {
            right++;
        } else {
            left = right;
            
            while (!isNaN(my_string[right])) {
                right++;
            }
            
            answer += Number(my_string.substring(left, right));
        }
    }
    
    return answer;
}