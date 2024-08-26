function solution(myString, pat) {
    var answer = 0;
    let left = 0;
    let right = pat.length;
    
    while (right <= myString.length) {
        if (myString.slice(left, right) === pat) {
            answer++;
        }
        left++;
        right++;
    }
    
    return answer;
}