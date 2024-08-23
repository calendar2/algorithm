function solution(myString, pat) {
    const len = pat.length;
    let right = myString.length;
    let left = right - len;
    
    let idx = 0;
    while (left >= 0) {
        if (myString.slice(left, right) === pat) {
            idx = right;
            break;
        }
        left--;
        right--;
    }
    
    return myString.slice(0, idx);
}