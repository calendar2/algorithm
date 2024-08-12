function solution(my_string, indices) {
    var answer = '';
    
    for (let i = 0; i < my_string.length; i++) {
        for (let j = 0; j < indices.length; j++) {
            if (i === indices[j]) {
                break;
            }
            
            if (j === indices.length-1) {
                answer += my_string[i];
            }
        }
    }
    
    return answer;
}