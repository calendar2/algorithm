function solution(myString, pat) {
    var answer = 0;
    
    const newMyString = myString.toLowerCase();
    const newPat = pat.toLowerCase();
    
    let left = 0;
    let right = pat.length;
    
    while (right <= myString.length) {
        if (newMyString.slice(left, right) === newPat) {
            answer = 1;
            break;
        }
        left++;
        right++;
    }
    
    return answer;
}