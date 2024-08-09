function solution(my_string, m, c) {
    var answer = '';
    const arr = [];
    let idx = 0;
    
    while (idx < my_string.length) {
        arr.push(my_string.slice(idx, idx+m));
        idx += m;
    }
    
    for (const a of arr) {
        answer += a[c-1];
    }
    
    return answer;
}